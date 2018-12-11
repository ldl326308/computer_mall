package com.nf.lc.controller;

import com.nf.lc.dto.Result;
import com.nf.lc.entity.Computer;
import com.nf.lc.entity.QueryDataParameter;
import com.nf.lc.entity.SelectLikePrams;
import com.nf.lc.exception.EmptyException;
import com.nf.lc.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@Controller
public class ComputerController {

    @Autowired
    private ComputerService computerService;

    /**
     * 删除单个
     *
     * @param computerId
     * @return
     */
    @RequestMapping(value = "/computer/{computerId}", method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result deleteByPrimaryKey(@PathVariable("computerId") int computerId) {
        return computerService.deleteByPrimaryKey(computerId) > 0 ? Result.successMessage("删除成功!") : Result.error("删除失败！");
    }

    /**
     * 添加computer
     *
     * @param computer
     * @return
     */
    @RequestMapping(value = "/computer", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result insert(Computer computer) {
        return computerService.insert(computer) > 0 ? Result.successMessage("添加成功！") : Result.error("添加失败！");
    }

    /**
     * 查询单个brand
     *
     * @param computerId
     * @return
     */
    @RequestMapping(value = "/computer/{computerId}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result selectByPrimaryKey(@PathVariable("computerId") int computerId) {
        try {
            return Result.success(computerService.selectByPrimaryKey(computerId));
        } catch (EmptyException e) {
            return Result.error(e.getMessage());
        }
    }

    /**
     * 修改
     *
     * @param computer
     * @return
     */
    @RequestMapping(value = "/computer", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result updateByPrimaryKey(Computer computer) {
        return computerService.updateByPrimaryKey(computer) > 0 ? Result.successMessage("修改成功！") : Result.error("修改失败！");
    }


    /**
     * 查询所有computer数据
     *
     * @return
     */
    @RequestMapping(value = "/computer/query", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result selectCount(@RequestBody QueryDataParameter queryDataParameter){
        try {
            return  Result.success(computerService.selectAll(queryDataParameter),computerService.selectCount(queryDataParameter));
        } catch (EmptyException e) {
            return Result.successMessage(e.getMessage()); //成功，没有数据返回
        }
    }

    /**
     * 模糊搜索
     *
     * @return
     */
    @RequestMapping(value = "/computer/query/like", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result selectLikeDescribe(@RequestBody SelectLikePrams selectLikePrams){
        try {
            return Result.success(computerService.selectLikeDescribe(selectLikePrams),computerService.selectLikeDescribeCount(selectLikePrams));
        } catch (EmptyException e) {
            return Result.successMessage("没有数据");
        }

    }

}
