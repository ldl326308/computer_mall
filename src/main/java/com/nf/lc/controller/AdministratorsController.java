package com.nf.lc.controller;

import com.nf.lc.dto.Result;
import com.nf.lc.entity.Administrators;
import com.nf.lc.exception.EmptyException;
import com.nf.lc.exception.FailureException;
import com.nf.lc.service.impl.AdministratorsServiceImp;
import com.nf.lc.service.impl.ExportToolImp;
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
public class AdministratorsController {

    @Autowired
    private AdministratorsServiceImp administratorsServiceImp;

    @Autowired
    private ExportToolImp exportUserToolImp;

    @RequestMapping(value = "/admin", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result selectAll(@RequestParam("page") int page ,@RequestParam("adminState") int adminState) {
        try {
            List<Administrators> admins = administratorsServiceImp.selectAll(page ,adminState);
            return Result.success(admins,administratorsServiceImp.selectAdministratorsCountIsState(adminState));
        } catch (EmptyException e) {
            return Result.error(e.getMessage());
        }
    }

    /**
     * 根据 adminIdNumber 模糊查询
     * @param page
     * @param adminIdNumber
     * @return
     */
    @RequestMapping(value = "/admin/idNumber" , method = RequestMethod.GET , produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result selectByLikeAdminIdNumber(@RequestParam("page") int page,@RequestParam("adminIdNumber") String adminIdNumber){
        try {
            List<Administrators> administrators = administratorsServiceImp.selectByLikeAdminIdNumber(page,adminIdNumber);
            return Result.success(administrators,administratorsServiceImp.selectByLikeAdminIdNumberCount(adminIdNumber));
        } catch (EmptyException e) {
            return Result.error(e.getMessage());
        }
    }

    /**
     * 修改权限及状态
     * @param administrators
     * @return
     */
    @RequestMapping(value = "/admin" , method = RequestMethod.PUT , produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result updateByPrimaryKey(@RequestBody Administrators administrators){
        try {
            administratorsServiceImp.updateByPrimaryKey(administrators);
            return Result.successMessage("修改成功！");
        } catch (FailureException e) {
            return Result.error(e.getMessage());
        }
    }

    /**
     * 根据id删除
     * @param adminId
     * @return
     */
    @RequestMapping(value = "/admin/{adminId}" , method = RequestMethod.DELETE , produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result deleteByPrimaryKey(@PathVariable("adminId") int adminId){
        try {
            administratorsServiceImp.deleteByPrimaryKey(adminId);
            return Result.successMessage("删除成功！");
        } catch (FailureException e) {
            return Result.error(e.getMessage());
        }
    }

    /**
     * 添加管理员
     * @return
     */
    @RequestMapping(value = "/admin" , method = RequestMethod.POST , produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result insert(@RequestBody Administrators admin){

        try {
            administratorsServiceImp.insert(admin);
        } catch (FailureException e) {
            return Result.error(e.getMessage());
        }

        return Result.successMessage("添加管理员成功！管理员初始密码是：123456");
    }

    /**
     * 导出管理员数据
     * @param response
     * @param adminState
     * @param startPage
     * @param endPage
     * @return
     */
    @RequestMapping(value = "/admin/export" , method = RequestMethod.GET)
    public ResponseEntity<byte[]> exportAdmin(HttpServletResponse response, @Param("adminState") int adminState, @Param("startPage") int startPage, @Param("endPage") int endPage){
        try {
            byte[] bytes = exportUserToolImp.exportAdmin(adminState, startPage, endPage);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentDispositionFormData("attachment", "admin" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".xlsx");
            return ResponseEntity.ok().headers(headers).body(bytes);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    /**
     * 重置管理员密码
     * @param adminId
     * @return
     */
    @RequestMapping(value = "/admin/reset" , method = RequestMethod.PUT ,produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result resetAdminPassword(@RequestParam("adminId") int adminId){

        try {
            administratorsServiceImp.resetAdminPassword(adminId);
            return Result.successMessage("重置密码成功！密码为：123456");
        } catch (FailureException e) {
            return Result.error(e.getMessage());
        }
    }

    /**
     * 登入验证
     * @param adminAccountNumber
     * @param adminPassword
     * @return
     */
    @RequestMapping(value = "/login" , method = RequestMethod.GET , produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result loginVerify(HttpSession session,String adminAccountNumber, String adminPassword){
        try {
            Administrators administrators = administratorsServiceImp.loginVerify(adminAccountNumber, adminPassword);
            session.setAttribute("admin",administrators);
            return Result.success(administrators);
        } catch (EmptyException e) {
            return Result.error(e.getMessage());
        }
    }

    /**
     * 获得当前登入管理员对象
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "/currentAdmin", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result getCurrentUser(HttpSession session) {
        Administrators user = (Administrators) session.getAttribute("currentAdmin");
        if (user != null) {  //存在
            return Result.success(user);
        } else {
            return Result.successMessage("没有当前登入的管理员");
        }
    }

    /**
     * 注销管理员登入
     *
     * @return
     */
    @RequestMapping(value = "/admin/logout", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result logoutCurrentUser(HttpSession session) {
        if (session.getAttribute("currentAdmin") != null) {  //存在，删除
            session.removeAttribute("currentAdmin");
        }
        return Result.successMessage("已注销当前用户！");
    }

}
