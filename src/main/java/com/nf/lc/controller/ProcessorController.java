package com.nf.lc.controller;

import com.nf.lc.entity.Processor;
import com.nf.lc.service.ProcessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class ProcessorController {

    @Autowired
    private ProcessorService processorService;

    /**
     * 查询所有
     * @return
     */
    @RequestMapping(value = "/processor" , method = RequestMethod.GET , produces = "application/json;charset=utf-8")
    @ResponseBody
    public ResponseEntity selectAll(){
        return ResponseEntity.ok(processorService.selectAll());
    }

    /**
     * 根据id删除
     * @param processorId
     * @return
     */
    @RequestMapping(value = "/processor/{processorId}" , method = RequestMethod.DELETE , produces = "application/json;charset=utf-8")
    @ResponseBody
    public ResponseEntity deleteByPrimaryKey(@PathVariable("processorId") int processorId){
        return processorService.deleteByPrimaryKey(processorId) > 0 ? ResponseEntity.ok("删除成功！") : ResponseEntity.ok("删除失败！");
    }

    /**
     * 添加单个
     * @param processor
     * @return
     */
    @RequestMapping(value = "/processor" , method = RequestMethod.POST , produces = "application/json;charset=utf-8")
    @ResponseBody
    public ResponseEntity insert(Processor processor){
        return processorService.insert(processor) > 0 ? ResponseEntity.ok("添加成功！") : ResponseEntity.ok("添加失败！");
    }

    /**
     * 根据id查询
     * @param processorId
     * @return
     */
    @RequestMapping(value = "/processor/{processorId}" , method = RequestMethod.GET , produces = "application/json;charset=utf-8")
    @ResponseBody
    public ResponseEntity selectByPrimaryKey(@PathVariable("processorId") int processorId){
        return ResponseEntity.ok(processorService.selectByPrimaryKey(processorId));
    }

    /**
     * 修改
     * @param processor
     * @return
     */
    @RequestMapping(value = "/processor" , method = RequestMethod.PUT , produces = "application/json;charset=utf-8")
    @ResponseBody
    public ResponseEntity updateByPrimaryKey(Processor processor){
        return processorService.updateByPrimaryKey(processor) > 0 ? ResponseEntity.ok("修改成功！") : ResponseEntity.ok("修改失败！");
    }
}