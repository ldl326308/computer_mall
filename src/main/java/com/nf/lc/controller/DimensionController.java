package com.nf.lc.controller;


import com.nf.lc.entity.Dimension;
import com.nf.lc.service.DimensionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class DimensionController {

    @Autowired
    private DimensionService dimensionService;

    /**
     * 根据id删除
     * @param dimensionId
     * @return
     */
    @RequestMapping(value = "/dimension/{dimensionId}" , method = RequestMethod.DELETE , produces = "application/json;charset=utf-8")
    @ResponseBody
    public ResponseEntity deleteByPrimaryKey(@PathVariable("dimensionId") int dimensionId){
        return dimensionService.deleteByPrimaryKey(dimensionId) > 0 ? ResponseEntity.ok("删除成功！") : ResponseEntity.ok("删除失败！");
    }

    /**
     * 单个添加
     * @param dimension
     * @return
     */
    @RequestMapping(value = "/dimension" , method = RequestMethod.POST , produces = "application/json;charset=utf-8")
    @ResponseBody
    public ResponseEntity insert(Dimension dimension){
        return dimensionService.insert(dimension) > 0 ? ResponseEntity.ok("添加成功！") : ResponseEntity.ok("添加失败！");
    }

    /**
     * 根据id查询
     * @param dimensionId
     * @return
     */
    @RequestMapping(value = "/dimension/{dimensionId}" , method = RequestMethod.GET , produces = "application/json;charset=utf-8")
    @ResponseBody
    public ResponseEntity selectByPrimaryKey(@PathVariable("dimensionId") int dimensionId){
        return ResponseEntity.ok(dimensionService.selectByPrimaryKey(dimensionId));
    }

    /**
     * 查询所有数据
     * @return
     */
    @RequestMapping(value = "/dimension" , method = RequestMethod.GET , produces = "application/json;charset=utf-8")
    @ResponseBody
    public ResponseEntity selectAll(){
        return ResponseEntity.ok(dimensionService.selectAll());
    }

    /**
     * 根据id修改
     * @param dimension
     * @return
     */
    @RequestMapping(value = "/dimension" , method = RequestMethod.PUT , produces = "application/json;charset=utf-8")
    @ResponseBody
    public ResponseEntity updateByPrimaryKey(Dimension dimension){
        return dimensionService.updateByPrimaryKey(dimension) > 0 ? ResponseEntity.ok("修改成功！") : ResponseEntity.ok("修改失败！");
    }


}
