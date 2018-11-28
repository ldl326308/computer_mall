package com.nf.lc.controller;

import com.nf.lc.entity.Nvdia;
import com.nf.lc.service.NvdiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class NvdiaController {

    @Autowired
    private NvdiaService nvdiaService;

    /**
     * 查询所有brand数据
     *
     * @return
     */
    @RequestMapping(value = "/nvdia", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public ResponseEntity selectAll() {
        return ResponseEntity.ok(nvdiaService.selectAll());
    }

    /**
     * 删除单个brand
     *
     * @param nvdiaId
     * @return
     */
    @RequestMapping(value = "/nvdia/{nvdiaId}", method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
    @ResponseBody
    public ResponseEntity deleteByPrimaryKey(@PathVariable("nvdiaId") int nvdiaId) {
        return nvdiaService.deleteByPrimaryKey(nvdiaId) > 0 ? ResponseEntity.ok("删除成功!") : ResponseEntity.ok("删除失败！");
    }

    /**
     * 添加brand
     *
     * @param nvdia
     * @return
     */
    @RequestMapping(value = "/nvdia", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public ResponseEntity insert(Nvdia nvdia) {
        return nvdiaService.insert(nvdia) > 0 ? ResponseEntity.ok("添加成功！") : ResponseEntity.ok("添加失败！");
    }

    /**
     * 查询单个brand
     *
     * @param nvdiaId
     * @return
     */
    @RequestMapping(value = "/nvdia/{nvdiaId}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public ResponseEntity selectByPrimaryKey(@PathVariable("nvdiaId") int nvdiaId) {
        return ResponseEntity.ok(nvdiaService.selectByPrimaryKey(nvdiaId));
    }

    /**
     * 修改brand
     *
     * @param nvdia
     * @return
     */
    @RequestMapping(value = "/nvdia", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public ResponseEntity updateByPrimaryKey(Nvdia nvdia) {
        return nvdiaService.updateByPrimaryKey(nvdia) > 0 ? ResponseEntity.ok("修改成功！") : ResponseEntity.ok("修改失败！");
    }

}
