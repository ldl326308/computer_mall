package com.nf.lc.controller;

import com.nf.lc.dto.Result;
import com.nf.lc.entity.User;
import com.nf.lc.exception.FailureException;
import com.nf.lc.exception.FrozenAccountsException;
import com.nf.lc.exception.NonExistentException;
import com.nf.lc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询所有user数据
     *
     * @return
     */
    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result selectAll() {
        return Result.success(userService.selectAll());
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
        return userService.deleteByPrimaryKey(userId) > 0 ? Result.successMessage("删除成功!") : Result.error("删除失败!");
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
            userService.insert(user);
            //根据注册传来的账号进行查询，并保存到Session中
            User fullDetail = userService.selectAccountNumber(user);
            session.setAttribute("currentUser", fullDetail);
            return Result.success("恭喜您注册成功，已为您自动登入！", fullDetail);
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
        return Result.success(userService.selectByPrimaryKey(userId));
    }

    /**
     * 修改用户
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

        if (userService.updateByPrimaryKey(sessionUser) > 0) {  //修改成功
            session.setAttribute("currentUser", sessionUser);  //更新Session里的用户信息
            return Result.success("信息修改成功！", sessionUser);
        }
        return Result.error("信息修改失败了！");

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
            User data = userService.loginVerify(user);
            //获得用户的所有信息
            User fullDetail = userService.selectAccountNumber(user);
            session.setAttribute("currentUser", fullDetail);  //保存到Session
            return Result.success("恭喜你，登入成功！", data);
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


}
