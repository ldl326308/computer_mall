package com.nf.lc.controller;

import com.nf.lc.entity.User;
import com.nf.lc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


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
    public ResponseEntity selectAll() {
        return ResponseEntity.ok(userService.selectAll());
    }

    /**
     * 删除单个用户
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.DELETE, produces = "text/html;charset=utf-8")
    @ResponseBody
    public ResponseEntity deleteByPrimaryKey(@PathVariable("userId") int userId) {
        return userService.deleteByPrimaryKey(userId) > 0 ? ResponseEntity.ok("删除成功!") : ResponseEntity.ok("删除失败!");
    }

    /**
     * 添加单个用户
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/user", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
    @ResponseBody
    public ResponseEntity insert(User user) {
        return userService.insert(user) > 0 ? ResponseEntity.ok("添加成功!") : ResponseEntity.ok("添加失败!");
    }

    /**
     * 根据id查找单个用户
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public ResponseEntity selectByPrimaryKey(@PathVariable("userId") int userId) {
        return ResponseEntity.ok(userService.selectByPrimaryKey(userId));
    }

    /**
     * 修改用户
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/user", method = RequestMethod.PUT, produces = "text/html;charset=utf-8")
    @ResponseBody
    public ResponseEntity updateByPrimaryKey(User user) {
        return userService.updateByPrimaryKey(user) > 0 ? ResponseEntity.ok("修改成功！") : ResponseEntity.ok("修改失败！");
    }


}
