package com.nf.lc.controller;

import com.nf.lc.dto.Result;
import com.nf.lc.entity.Order;
import com.nf.lc.entity.User;
import com.nf.lc.exception.EmptyException;
import com.nf.lc.exception.FailureException;
import com.nf.lc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 添加订单的方法
     * @param order
     * @param session
     * @return
     */
    @RequestMapping(value = "/order" , method = RequestMethod.POST , produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result insert(@RequestBody Order order, HttpSession session){
        User currentUser = (User) session.getAttribute("currentUser");
        if(currentUser == null){
            return Result.error("无法获得您的登入信息，请重新登入！");
        }
        order.setUserId(currentUser.getUserId()); //写入用户id
        try {
            orderService.insert(order);
        } catch (FailureException e) {
            return Result.error(e.getMessage());
        }
        return Result.successMessage("下单成功！");
    }

    /**
     * 查询当前用户的所有订单
     * @param session
     * @return
     */
    @RequestMapping(value = "/order/selectAllIsUserId" , method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result selectAllIsUserId(HttpSession session){
        User currentUser = (User) session.getAttribute("currentUser");
        if(currentUser == null){
            return Result.error("无法获得您的登入信息，请重新登入！");
        }

        try {
            List<Order> orders = orderService.selectAllIsUserId(currentUser.getUserId());
            return Result.success(orders);
        } catch (EmptyException e) {
            return Result.error(e.getMessage());
        }

    }

}
