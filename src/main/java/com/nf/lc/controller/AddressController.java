package com.nf.lc.controller;

import com.nf.lc.dto.Result;
import com.nf.lc.entity.Address;
import com.nf.lc.entity.User;
import com.nf.lc.exception.EmptyException;
import com.nf.lc.exception.FailureException;
import com.nf.lc.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AddressController {

    @Autowired
    private AddressService addressService;

    /**
     * 添加地址信息
     * @param address
     * @param session
     * @return
     */
    @RequestMapping(value = "/address" , method = RequestMethod.POST , produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result insert(@RequestBody Address address , HttpSession session){
        User currentUser = (User)session.getAttribute("currentUser");
        address.setUserId(currentUser.getUserId());
        try {
            addressService.insert(address);
            return Result.successMessage("添加成功！");
        } catch (FailureException e) {
            return Result.error(e.getMessage());
        } catch (EmptyException e) {
            return Result.error(e.getMessage());
        }
    }

    /**
     * 查询所有地址信息
     * @param session
     * @return
     */
    @RequestMapping(value = "/address" , method = RequestMethod.GET , produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result selectAll(HttpSession session){
        User currentUser = (User)session.getAttribute("currentUser");
        if(currentUser == null){
            return Result.error("没有获取到您的登入信息，请重新登入！");
        }

        try {
            List<Address> addresses = addressService.selectAll(currentUser.getUserId());
            return Result.success(addresses);
        } catch (EmptyException e) {
            return Result.error(e.getMessage());
        }

    }

}
