package com.nf.lc.controller;

import com.nf.lc.entity.HardDisk;
import com.nf.lc.service.HardDiskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HardDiskController {

    @Autowired
    private HardDiskService hardDiskService;

    /**
     * 根据id删除
     * @param hardDiskId
     * @return
     */
    @RequestMapping(value = "/hardDisk/{hardDiskId}" , method = RequestMethod.DELETE , produces = "application/json;charset=utf-8")
    @ResponseBody
    public ResponseEntity deleteByPrimaryKey(@PathVariable("hardDiskId") int hardDiskId){
        return hardDiskService.deleteByPrimaryKey(hardDiskId) > 0 ? ResponseEntity.ok("删除成功！") : ResponseEntity.ok("删除失败！");
    }

    /**
     * 单个添加
     * @param hardDisk
     * @return
     */
    @RequestMapping(value = "/hardDisk" , method = RequestMethod.POST , produces = "application/json;charset=utf-8")
    @ResponseBody
    public ResponseEntity insert(HardDisk hardDisk){
        return hardDiskService.insert(hardDisk) > 0 ? ResponseEntity.ok("添加成功！") : ResponseEntity.ok("添加失败！");
    }

    /**
     * 根据id查询
     * @param hardDiskId
     * @return
     */
    @RequestMapping(value = "/hardDisk/{hardDiskId}" , method = RequestMethod.GET , produces = "application/json;charset=utf-8")
    @ResponseBody
    public ResponseEntity selectByPrimaryKey(@PathVariable("hardDiskId") int hardDiskId){
        return ResponseEntity.ok(hardDiskService.selectByPrimaryKey(hardDiskId));
    }

    /**
     * 查询所有数据
     * @return
     */
    @RequestMapping(value = "/hardDisk" , method = RequestMethod.GET , produces = "application/json;charset=utf-8")
    @ResponseBody
    public ResponseEntity selectAll(){
        return ResponseEntity.ok(hardDiskService.selectAll());
    }

    /**
     * 根据id修改
     * @param hardDisk
     * @return
     */
    @RequestMapping(value = "/hardDisk" , method = RequestMethod.PUT , produces = "application/json;charset=utf-8")
    @ResponseBody
    public ResponseEntity updateByPrimaryKey(HardDisk hardDisk){
        return hardDiskService.updateByPrimaryKey(hardDisk) > 0 ? ResponseEntity.ok("修改成功！") : ResponseEntity.ok("修改失败！");
    }


}
