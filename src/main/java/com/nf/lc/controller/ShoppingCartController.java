package com.nf.lc.controller;

import com.nf.lc.dto.Result;
import com.nf.lc.entity.ShoppingCart;
import com.nf.lc.entity.User;
import com.nf.lc.exception.FailureException;
import com.nf.lc.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    /**
     * 添加到购物车
     * @param shoppingCart
     * @return
     */
    @RequestMapping(value = "/shoppingCart" , method = RequestMethod.POST , produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result insert(@RequestBody ShoppingCart shoppingCart , HttpSession session){
        User currentUser = (User) session.getAttribute("currentUser");
        if(currentUser == null){  //等于null，未登入
            return Result.error("您还未登入，请先登入！");
        }
        shoppingCart.setUserId(currentUser.getUserId()); //写入当前登入用户的id
        try {
            shoppingCartService.insert(shoppingCart);
            return Result.successMessage("已将商品添加到购物车中！");
        } catch (FailureException e) {
            return Result.error(e.getMessage());
        }
    }

//    int deleteByPrimaryKey(Integer shoppingId);
//    int insert(ShoppingCart record);
//    ShoppingCart selectByPrimaryKey(Integer shoppingId);
//    List<ShoppingCart> selectAll();
//    int updateByPrimaryKey(ShoppingCart record);


}
