package com.nf.lc.controller;

import com.nf.lc.dto.Result;
import com.nf.lc.entity.Order;
import com.nf.lc.entity.User;
import com.nf.lc.exception.EmptyException;
import com.nf.lc.exception.FailureException;
import com.nf.lc.service.impl.OrderServiceImp;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.ws.rs.Path;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderServiceImp orderServiceImp;

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
            orderServiceImp.insert(order);
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
            List<Order> orders = orderServiceImp.selectAllIsUserId(currentUser.getUserId());
            return Result.success(orders);
        } catch (EmptyException e) {
            return Result.error(e.getMessage());
        }

    }

    /**
     * 根据订单状态查询订单信息
     * @param orderState
     * @return
     */
    @RequestMapping(value = "/order" , method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result selectAll(int orderState){
        try {
            List<Order> orders = orderServiceImp.selectAllIsOrderState(orderState);
            return Result.success(orders,orderServiceImp.selectAllIsOrderStateCount(orderState));
        } catch (EmptyException e) {
            return Result.error(e.getMessage());
        }
    }

    /**
     * 通过订单编号查询数据
     * @param orderNumber
     * @return
     */
    @RequestMapping(value = "/order/{orderNumber}" , method = RequestMethod.GET , produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result selectByOrderNumber(@PathVariable("orderNumber") String orderNumber){
        try {
            Order order = orderServiceImp.selectByOrderNumber(orderNumber);
            return Result.success(order);
        } catch (EmptyException e) {
            return Result.error(e.getMessage());
        }
    }

    /**
     * 通过订单编号修改状态
     * @param orderNumber
     * @return
     */
    @RequestMapping(value = "/order/orderState/{orderNumber}" , method = RequestMethod.POST , produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result updateByOrderNumberIsState(@PathVariable("orderNumber") String orderNumber){
        try {
            orderServiceImp.updateByOrderNumberIsState(orderNumber);
            return Result.successMessage("修改成功！");
        } catch (FailureException e) {
            return Result.error(e.getMessage());
        }
    }


}
