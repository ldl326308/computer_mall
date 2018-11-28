package com.nf.lc.controller;

import com.nf.lc.entity.MemoryCapacity;
import com.nf.lc.service.MemoryCapacityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemoryCapacityController {

    @Autowired
    private MemoryCapacityService memoryCapacityService;

    /**
     * 根据id删除
     * @param memoryCapacityId
     * @return
     */
    @RequestMapping(value = "/memoryCapacity/{memoryCapacityId}" , method = RequestMethod.DELETE , produces = "application/json;charset=utf-8")
    @ResponseBody
    public ResponseEntity deleteByPrimaryKey(@PathVariable("memoryCapacityId") int memoryCapacityId){
        return memoryCapacityService.deleteByPrimaryKey(memoryCapacityId) > 0 ? ResponseEntity.ok("删除成功！") : ResponseEntity.ok("删除失败！");
    }

    /**
     * 单个添加
     * @param memoryCapacity
     * @return
     */
    @RequestMapping(value = "/memoryCapacity" , method = RequestMethod.POST , produces = "application/json;charset=utf-8")
    @ResponseBody
    public ResponseEntity insert(MemoryCapacity memoryCapacity){
        return memoryCapacityService.insert(memoryCapacity) > 0 ? ResponseEntity.ok("添加成功！") : ResponseEntity.ok("添加失败！");
    }

    /**
     * 根据id查询
     * @param memoryCapacityId
     * @return
     */
    @RequestMapping(value = "/memoryCapacity/{memoryCapacityId}" ,method = RequestMethod.GET , produces = "application/json;charset=utf-8")
    @ResponseBody
    public ResponseEntity selectByPrimaryKey(int memoryCapacityId){
        return ResponseEntity.ok(memoryCapacityService.selectByPrimaryKey(memoryCapacityId));
    }

    /**
     * 查询所有数据
     * @return
     */
    @RequestMapping(value = "/memoryCapacity" , method = RequestMethod.GET , produces = "application/json;charset=utf-8")
    @ResponseBody
    public ResponseEntity selectAll(){
        return ResponseEntity.ok(memoryCapacityService.selectAll());
    }

    /**
     * 根据id修改
     * @param memoryCapacity
     * @return
     */
    @RequestMapping(value = "/memoryCapacity" , method = RequestMethod.PUT , produces = "application/json;charset=utf-8")
    @ResponseBody
    public ResponseEntity updateByPrimaryKey(MemoryCapacity memoryCapacity){
        return memoryCapacityService.updateByPrimaryKey(memoryCapacity) > 0 ? ResponseEntity.ok("修改成功！") : ResponseEntity.ok("修改失败！");
    }


}
