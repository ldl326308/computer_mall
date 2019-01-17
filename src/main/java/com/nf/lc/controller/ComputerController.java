package com.nf.lc.controller;

import com.nf.lc.dto.Result;
import com.nf.lc.entity.*;
import com.nf.lc.exception.EmptyException;
import com.nf.lc.exception.FailureException;
import com.nf.lc.service.impl.ComputerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class ComputerController {

    @Autowired
    private ComputerServiceImp computerServiceImp;

    /**
     * 删除单个
     *
     * @param computerId
     * @return
     */
    @RequestMapping(value = "/computer/{computerId}", method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result deleteByPrimaryKey(@PathVariable("computerId") int computerId) {
        return computerServiceImp.deleteByPrimaryKey(computerId) > 0 ? Result.successMessage("删除成功!") : Result.error("删除失败！");
    }

    /**
     * 添加computer
     *
     * @param computer
     * @return
     */
    @RequestMapping(value = "/computer", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result insert(@RequestBody InsertComputerParam computer) {
        try {
            computerServiceImp.insert(computer);
            return Result.successMessage("添加成功！");
        } catch (FailureException e) {
            return Result.error(e.getMessage());
        }
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
            return Result.success(computerServiceImp.selectByPrimaryKey(computerId));
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
    public Result updateByPrimaryKey(@RequestBody UpdateComputerParam computer) {
        try {
            computerServiceImp.updateByPrimaryKey(computer);
            return Result.successMessage("修改成功！");
        } catch (FailureException e) {
            return Result.error(e.getMessage());
        }
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
            return  Result.success(computerServiceImp.selectAll(queryDataParameter), computerServiceImp.selectCount(queryDataParameter));
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
            return Result.success(computerServiceImp.selectLikeDescribe(selectLikePrams), computerServiceImp.selectLikeDescribeCount(selectLikePrams));
        } catch (EmptyException e) {
            return Result.successMessage("没有数据");
        }
    }

    /**
     *通过状态和分页获得数据
     * @param page
     * @param computerState
     * @return
     */
    @RequestMapping(value = "/computer" , method = RequestMethod.GET , produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result selectAllByComputerState(@RequestParam("page") int page, @RequestParam("computerState") int computerState){
        try {
            List<Computer> computers = computerServiceImp.selectAllByComputerState(page, computerState);
            int total = computerServiceImp.selectAllByComputerStateCount(computerState);
            return Result.success(computers,total);
        } catch (EmptyException e) {
            return Result.successMessage(e.getMessage());
        }
    }

}
