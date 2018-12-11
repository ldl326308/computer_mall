package com.nf.lc.controller;

import com.nf.lc.dto.Result;
import com.nf.lc.entity.Processor;
import com.nf.lc.service.ProcessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
    public Result selectAll(){
        List<Processor> processors = processorService.selectAll();
        return Result.success(processors,processors.size());
    }

    /**
     * 根据id删除
     * @param processorId
     * @return
     */
    @RequestMapping(value = "/processor/{processorId}" , method = RequestMethod.DELETE , produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result deleteByPrimaryKey(@PathVariable("processorId") int processorId){
        return processorService.deleteByPrimaryKey(processorId) > 0 ? Result.successMessage("删除成功！") : Result.error("删除失败！");
    }

    /**
     * 添加单个
     * @param processor
     * @return
     */
    @RequestMapping(value = "/processor" , method = RequestMethod.POST , produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result insert(Processor processor){
        return processorService.insert(processor) > 0 ? Result.successMessage("添加成功！") : Result.error("添加失败！");
    }

    /**
     * 根据id查询
     * @param processorId
     * @return
     */
    @RequestMapping(value = "/processor/{processorId}" , method = RequestMethod.GET , produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result selectByPrimaryKey(@PathVariable("processorId") int processorId){
        return Result.success(processorService.selectByPrimaryKey(processorId));
    }

    /**
     * 修改
     * @param processor
     * @return
     */
    @RequestMapping(value = "/processor" , method = RequestMethod.PUT , produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result updateByPrimaryKey(Processor processor){
        return processorService.updateByPrimaryKey(processor) > 0 ? Result.successMessage("修改成功！") : Result.error("修改失败！");
    }
}
