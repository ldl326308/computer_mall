package com.nf.lc.controller;

import com.nf.lc.dto.Result;
import com.nf.lc.entity.Type;
import com.nf.lc.service.impl.TypeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class TypeController {

    @Autowired
    private TypeServiceImp typeServiceImp;

    /**
     * 查询所有type数据
     *
     * @return
     */
    @RequestMapping(value = "/type", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result selectAll() {
        List<Type> types = typeServiceImp.selectAll();
        return Result.success(types,types.size());
    }

    /**
     * 删除单个 type
     * @param typeId
     * @return
     */
    @RequestMapping(value = "/type/{typeId}" , method = RequestMethod.DELETE , produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result deleteByPrimaryKey(@PathVariable("typeId") int typeId){
        return typeServiceImp.deleteByPrimaryKey(typeId) > 0 ? Result.successMessage("删除成功！") : Result.error("删除失败！");
    }

    /**
     * 添加 type
     * @param type
     * @return
     */
    @RequestMapping(value = "/type" , method = RequestMethod.POST , produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result insert(Type type){
        return typeServiceImp.insert(type) > 0 ? Result.successMessage("添加成功！") : Result.error("添加失败！");
    }

    @RequestMapping(value = "/type/{typeId}" , method = RequestMethod.GET , produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result selectByPrimaryKey(@PathVariable("typeId") int typeId){
        return Result.success(typeServiceImp.selectByPrimaryKey(typeId));
    }

    @RequestMapping(value = "/type" , method = RequestMethod.PUT , produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result updateByPrimaryKey(Type type){
        return typeServiceImp.updateByPrimaryKey(type) > 0 ? Result.successMessage("修改成功！") : Result.error("修改失败！");
    }


}
