package com.nf.lc.controller;


import com.nf.lc.dto.Result;
import com.nf.lc.entity.Dimension;
import com.nf.lc.service.impl.DimensionServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class DimensionController {

    @Autowired
    private DimensionServiceImp dimensionServiceImp;

    /**
     * 根据id删除
     * @param dimensionId
     * @return
     */
    @RequestMapping(value = "/dimension/{dimensionId}" , method = RequestMethod.DELETE , produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result deleteByPrimaryKey(@PathVariable("dimensionId") int dimensionId){
        return dimensionServiceImp.deleteByPrimaryKey(dimensionId) > 0 ? Result.successMessage("删除成功！") : Result.error("删除失败！");
    }

    /**
     * 单个添加
     * @param dimension
     * @return
     */
    @RequestMapping(value = "/dimension" , method = RequestMethod.POST , produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result insert(Dimension dimension){
        return dimensionServiceImp.insert(dimension) > 0 ? Result.successMessage("添加成功！") : Result.error("添加失败！");
    }

    /**
     * 根据id查询
     * @param dimensionId
     * @return
     */
    @RequestMapping(value = "/dimension/{dimensionId}" , method = RequestMethod.GET , produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result selectByPrimaryKey(@PathVariable("dimensionId") int dimensionId){
        return Result.success(dimensionServiceImp.selectByPrimaryKey(dimensionId));
    }

    /**
     * 查询所有数据
     * @return
     */
    @RequestMapping(value = "/dimension" , method = RequestMethod.GET , produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result selectAll(){
        List<Dimension> dimensions = dimensionServiceImp.selectAll();
        return Result.success(dimensions,dimensions.size());
    }

    /**
     * 根据id修改
     * @param dimension
     * @return
     */
    @RequestMapping(value = "/dimension" , method = RequestMethod.PUT , produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result updateByPrimaryKey(Dimension dimension){
        return dimensionServiceImp.updateByPrimaryKey(dimension) > 0 ? Result.successMessage("修改成功！") : Result.error("修改失败！");
    }


}
