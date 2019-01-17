package com.nf.lc.controller;

import com.nf.lc.dto.Result;
import com.nf.lc.entity.MemoryCapacity;
import com.nf.lc.service.impl.MemoryCapacityServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MemoryCapacityController {

    @Autowired
    private MemoryCapacityServiceImp memoryCapacityServiceImp;

    /**
     * 根据id删除
     * @param memoryCapacityId
     * @return
     */
    @RequestMapping(value = "/memoryCapacity/{memoryCapacityId}" , method = RequestMethod.DELETE , produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result deleteByPrimaryKey(@PathVariable("memoryCapacityId") int memoryCapacityId){
        return memoryCapacityServiceImp.deleteByPrimaryKey(memoryCapacityId) > 0 ? Result.successMessage("删除成功！") : Result.error("删除失败！");
    }

    /**
     * 单个添加
     * @param memoryCapacity
     * @return
     */
    @RequestMapping(value = "/memoryCapacity" , method = RequestMethod.POST , produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result insert(MemoryCapacity memoryCapacity){
        return memoryCapacityServiceImp.insert(memoryCapacity) > 0 ? Result.successMessage("添加成功！") : Result.error("添加失败！");
    }

    /**
     * 根据id查询
     * @param memoryCapacityId
     * @return
     */
    @RequestMapping(value = "/memoryCapacity/{memoryCapacityId}" ,method = RequestMethod.GET , produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result selectByPrimaryKey(int memoryCapacityId){
        return Result.success(memoryCapacityServiceImp.selectByPrimaryKey(memoryCapacityId));
    }

    /**
     * 查询所有数据
     * @return
     */
    @RequestMapping(value = "/memoryCapacity" , method = RequestMethod.GET , produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result selectAll(){
        List<MemoryCapacity> memoryCapacities = memoryCapacityServiceImp.selectAll();
        return Result.success(memoryCapacities,memoryCapacities.size());
    }

    /**
     * 根据id修改
     * @param memoryCapacity
     * @return
     */
    @RequestMapping(value = "/memoryCapacity" , method = RequestMethod.PUT , produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result updateByPrimaryKey(MemoryCapacity memoryCapacity){
        return memoryCapacityServiceImp.updateByPrimaryKey(memoryCapacity) > 0 ? Result.successMessage("修改成功！") : Result.error("修改失败！");
    }


}
