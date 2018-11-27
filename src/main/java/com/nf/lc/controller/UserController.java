package com.nf.lc.controller;

import com.nf.lc.dao.UserMapper;
import com.nf.lc.entity.User;
import com.nf.lc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询所有user数据
     * @return
     */
    @RequestMapping(value = "/user" ,method = RequestMethod.GET ,produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<User> selectAll(){
        return userService.selectAll();
    }


}
