package com.nf.lc.controller;

import com.nf.lc.dto.Result;
import com.nf.lc.entity.ComputerSystem;
import com.nf.lc.service.impl.ComputerSystemServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class ComputerSystemController {

    @Autowired
    private ComputerSystemServiceImp computerSystemServiceImp;

    /**
     * 根据id删除
     * @param computerSystemId
     * @return
     */
    @RequestMapping(value = "/computerSystem/{computerSystemId}" , method = RequestMethod.DELETE , produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result deleteByPrimaryKey(@PathVariable("computerSystemId") int computerSystemId){
        return computerSystemServiceImp.deleteByPrimaryKey(computerSystemId) > 0 ? Result.successMessage("删除成功！") : Result.error("删除失败！");
    }

    /**
     * 单个添加
     * @param computerSystem
     * @return
     */
    @RequestMapping(value = "/computerSystem" , method = RequestMethod.POST , produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result insert(ComputerSystem computerSystem){
        return computerSystemServiceImp.insert(computerSystem) > 0 ? Result.successMessage("添加成功！") : Result.error("添加失败！");
    }

    /**
     * 根据id查询
     * @param computerSystemId
     * @return
     */
    @RequestMapping(value = "/computerSystem/{computerSystemId}" , method = RequestMethod.GET , produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result selectByPrimaryKey(@PathVariable("computerSystemId") int computerSystemId){
        return Result.success(computerSystemServiceImp.selectByPrimaryKey(computerSystemId));
    }

    /**
     * 查询所有数据
     * @return
     */
    @RequestMapping(value = "/computerSystem" , method = RequestMethod.GET , produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result selectAll(){
        List<ComputerSystem> computerSystems = computerSystemServiceImp.selectAll();
        return Result.success(computerSystems,computerSystems.size());
    }

    /**
     * 根据id修改
     * @param computerSystem
     * @return
     */
    @RequestMapping(value = "/computerSystem" , method = RequestMethod.PUT , produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result updateByPrimaryKey(ComputerSystem computerSystem){
        return computerSystemServiceImp.updateByPrimaryKey(computerSystem) > 0 ? Result.successMessage("修改成功！") : Result.error("修改失败！");
    }


}
