package com.nf.lc.controller;

import com.nf.lc.dto.Result;
import com.nf.lc.entity.User;
import com.nf.lc.exception.EmptyException;
import com.nf.lc.exception.FailureException;
import com.nf.lc.exception.FrozenAccountsException;
import com.nf.lc.exception.NonExistentException;
import com.nf.lc.service.impl.ExportToolImp;
import com.nf.lc.service.impl.UserServiceImp;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
public class UserController {

    @Autowired
    private UserServiceImp userServiceImp;

    @Autowired
    private ExportToolImp exportUserToolImp;

    /**
     * 查询所有user数据
     *
     * @return
     */
    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result selectAll(@RequestParam("page") int page ,@RequestParam(defaultValue = "-1") int userState) {
        try {
            List<User> users = userServiceImp.selectAll(page ,userState);
            return Result.success(users,userServiceImp.selectUserCountIsState(userState));
        } catch (EmptyException e) {
            return Result.error(e.getMessage());
        }
    }

    /**
     * 删除单个用户
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result deleteByPrimaryKey(@PathVariable("userId") int userId) {
        return userServiceImp.deleteByPrimaryKey(userId) > 0 ? Result.successMessage("删除成功!") : Result.error("删除失败!");
    }

    /**
     * 添加单个用户
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/user", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result insert(@RequestBody User user, HttpSession session) {
        try {
            userServiceImp.insert(user);
            //根据注册传来的账号进行查询，并保存到Session中
            User fullDetail = userServiceImp.selectAccountNumber(user);
            session.setAttribute("currentUser", fullDetail);
            return Result.success("恭喜您注册成功，已为您自动登入！", fullDetail,0);
        } catch (FailureException e) {
            return Result.error(e.getMessage());
        }
    }

    /**
     * 根据id查找单个用户
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result selectByPrimaryKey(@PathVariable("userId") int userId) {
        return Result.success(userServiceImp.selectByPrimaryKey(userId));
    }


    /**
     * 根据账号查询用户信息
     * @param userAccountNumber
     * @return
     */
    @RequestMapping(value = "/user/userAccountNumber" , method = RequestMethod.GET , produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result selectByUserAccountNumber(@RequestParam("userAccountNumber") String userAccountNumber){
        try {
            //找到用户，返回该用户信息
            return Result.success(userServiceImp.selectByUserAccountNumber(userAccountNumber));
        } catch (EmptyException e) {
            return Result.error(e.getMessage());  //发生错误
        } catch (FailureException e) {
            return Result.successMessage(e.getMessage()); //没有找到该用户
        }
    }


    /**
     * 客户端修改用户
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/user", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result updateByPrimaryKey(@RequestBody User user, HttpSession session) {
        //获得Session中保存的对象
        User sessionUser = (User) session.getAttribute("currentUser");
        sessionUser.setUserHeadPortrait(user.getUserHeadPortrait());
        sessionUser.setUserNickname(user.getUserNickname());
        sessionUser.setUserPassword(user.getUserPassword());

        if (userServiceImp.updateByPrimaryKey(sessionUser) > 0) {  //修改成功
            session.setAttribute("currentUser", sessionUser);  //更新Session里的用户信息
            return Result.success("信息修改成功！", sessionUser,0);
        }
        return Result.error("信息修改失败了！");

    }

    /**
     * 通过用户 id 修改状态
     * @param user
     * @return
     */
    @RequestMapping(value = "/user/state", method = RequestMethod.PUT , produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result updateByPrimaryKeyToState(@RequestBody User user){
        try {
            userServiceImp.updateByPrimaryKeyToState(user);
            return Result.successMessage("修改成功！");
        } catch (FrozenAccountsException e) {
            return Result.error(e.getMessage());
        }
    }



    /**
     * 登入验证
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/user/login", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result loginVerify(@RequestBody User user, HttpSession session) {
        try {
            User data = userServiceImp.loginVerify(user);
            //获得用户的所有信息
            User fullDetail = userServiceImp.selectAccountNumber(user);
            session.setAttribute("currentUser", fullDetail);  //保存到Session
            return Result.success("恭喜你，登入成功！", data,0);
        } catch (NonExistentException e) {
            return Result.error(e.getMessage());
        } catch (FrozenAccountsException e) {
            return Result.error(e.getMessage());
        }
    }

    /**
     * 获得当前登入对象
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "/currentUser", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result getCurrentUser(HttpSession session) {
        User user = (User) session.getAttribute("currentUser");
        if (user != null) {  //存在
            return Result.success(user);
        } else {
            return Result.successMessage("没有当前登入的用户");
        }
    }

    /**
     * 注销登入
     *
     * @return
     */
    @RequestMapping(value = "/user/logout", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result logoutCurrentUser(HttpSession session) {
        if (session.getAttribute("currentUser") != null) {  //存在，删除
            session.removeAttribute("currentUser");
        }
        return Result.successMessage("已注销当前用户！");
    }

    /**
     * 重置用户密码
     * @param userId
     * @return
     */
    @RequestMapping(value = "/user/resetPwd",method = RequestMethod.PUT , produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result updateResetUserPassword(@Param("userId") int userId){
        try {
            userServiceImp.updateResetUserPassword(userId);
            return Result.successMessage("重置密码成功！新密码：654321");
        } catch (FrozenAccountsException e) {
            return Result.error(e.getMessage());
        }
    }

    /**
     * 通过状态，查询用户
     * @param userState
     * @return
     */
    @RequestMapping(value = "/user/userState")
    @ResponseBody
    public Result isStateToCount(@Param("userState") int userState){
        return Result.success(userServiceImp.selectUserCountIsState(userState));
    }

    /**
     * 导出数据
     * @param userState
     * @param startPage
     * @param endPage
     * @return
     */
    @RequestMapping(value = "/user/export" , method = RequestMethod.GET)
    public ResponseEntity<byte[]> exportUserData(HttpServletResponse response, @Param("userState") int userState, @Param("startPage") int startPage, @Param("endPage") int endPage){
        try {
            byte[] bytes = exportUserToolImp.exportUser(userState, startPage, endPage);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentDispositionFormData("attachment", "user" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".xlsx");
            return ResponseEntity.ok().headers(headers).body(bytes);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }



}
