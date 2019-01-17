package com.nf.lc.controller;

import com.nf.lc.dto.Result;
import com.nf.lc.entity.ShoppingCart;
import com.nf.lc.entity.User;
import com.nf.lc.exception.EmptyException;
import com.nf.lc.exception.FailureException;
import com.nf.lc.exception.FrozenAccountsException;
import com.nf.lc.service.impl.ShoppingCartServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;

@Controller
public class ShoppingCartController {

    @Autowired
    private ShoppingCartServiceImp shoppingCartServiceImp;

    /**
     * 添加到购物车
     *
     * @param shoppingCart
     * @return
     */
    @RequestMapping(value = "/shoppingCart", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result insert(@RequestBody ShoppingCart shoppingCart, HttpSession session) {
        User currentUser = (User) session.getAttribute("currentUser");
        if (currentUser == null) {  //等于null，未登入
            return Result.error("您还未登入，请先登入！");
        }
        shoppingCart.setUserId(currentUser.getUserId()); //写入当前登入用户的id
        try {
            shoppingCartServiceImp.insert(shoppingCart);
            return Result.successMessage("已将商品添加到购物车中！");
        } catch (FailureException e) {
            return Result.error(e.getMessage());
        }
    }

    /**
     * 查询当前登入用户的购物车信息
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "/shoppingCart/selectAll", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result selectAll(HttpSession session) {
        User currentUser = (User) session.getAttribute("currentUser");
        if (currentUser == null) {
            return Result.error("无法获得您的信息，请重新登入！");
        }
        try {
            return Result.success(shoppingCartServiceImp.selectAll(currentUser.getUserId()));
        } catch (EmptyException e) {
            return Result.successMessage(e.getMessage());
        }
    }

    /**
     * 删除购物车上的东西
     *
     * @param shoppingCartId
     * @return
     */
    @RequestMapping(value = "/shoppingCart/{shoppingCartId}", method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result deleteByPrimaryKey(@PathVariable("shoppingCartId") int shoppingCartId) {
        try {
            shoppingCartServiceImp.deleteByPrimaryKey(shoppingCartId);
            return Result.successMessage("移除成功！");
        } catch (FrozenAccountsException e) {
            return Result.error(e.getMessage());
        }
    }

    /**
     * 修改购物车信息
     * @param shoppingCart
     * @return
     */
    @RequestMapping(value = "/shoppingCart",method = RequestMethod.PUT ,produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result updateByPrimaryKey(@RequestBody ShoppingCart shoppingCart){
        try {
            shoppingCartServiceImp.updateByPrimaryKey(shoppingCart);
            return Result.successMessage("修改购物车商品数量成功！");
        } catch (FrozenAccountsException e) {
            return Result.error(e.getMessage());
        }
    }

    /**
     * 计算选中商品的总价
     * @param shoppingIds
     * @return
     */
    @RequestMapping(value = "/calculationTotal" , method = RequestMethod.GET , produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result selectShoppingCartIsTotalPrice(@RequestParam String shoppingIds){
        BigDecimal bigDecimal = null;
        try {
            bigDecimal = shoppingCartServiceImp.selectShoppingCartIsTotalPrice(shoppingIds);
            return Result.success(bigDecimal);
        } catch (EmptyException e) {
            return Result.success(0);
        }
    }

    /**
     * 根据id查询数据
     * @param shoppingIds
     * @return
     */
    @RequestMapping(value = "/shoppingCart/selectIds" , method = RequestMethod.GET , produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result selectShoppingCartIsIds(@RequestParam String shoppingIds,HttpSession session){
        User currentUser = (User) session.getAttribute("currentUser");
        if (currentUser == null) {
            return Result.error("无法获得您的信息，请重新登入！");
        }
        try {
            List<ShoppingCart> shoppingCarts = shoppingCartServiceImp.selectShoppingCartIsIds(shoppingIds,currentUser.getUserId());
            return Result.success(shoppingCarts);
        } catch (EmptyException e) {
            return Result.error(e.getMessage());
        }
    }

}