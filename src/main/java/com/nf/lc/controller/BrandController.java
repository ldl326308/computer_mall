package com.nf.lc.controller;

import com.nf.lc.entity.Brand;
import com.nf.lc.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class BrandController {

    @Autowired
    private BrandService brandService;

    /**
     * 查询所有brand数据
     *
     * @return
     */
    @RequestMapping(value = "/brand", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public ResponseEntity selectAll() {
        return ResponseEntity.ok(brandService.selectAll());
    }

    /**
     * 删除单个brand
     *
     * @param brandId
     * @return
     */
    @RequestMapping(value = "/brand/{brandId}", method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
    @ResponseBody
    public ResponseEntity deleteByPrimaryKey(@PathVariable("brandId") int brandId) {
        return brandService.deleteByPrimaryKey(brandId) > 0 ? ResponseEntity.ok("删除成功!") : ResponseEntity.ok("删除失败！");
    }

    /**
     * 添加brand
     *
     * @param brand
     * @return
     */
    @RequestMapping(value = "/brand", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public ResponseEntity insert(Brand brand) {
        return brandService.insert(brand) > 0 ? ResponseEntity.ok("添加成功！") : ResponseEntity.ok("添加失败！");
    }

    /**
     * 查询单个brand
     *
     * @param brandId
     * @return
     */
    @RequestMapping(value = "/brand/{brandId}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public ResponseEntity selectByPrimaryKey(@PathVariable("brandId") int brandId) {
        return ResponseEntity.ok(brandService.selectByPrimaryKey(brandId));
    }

    /**
     * 修改brand
     *
     * @param brand
     * @return
     */
    @RequestMapping(value = "/brand", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public ResponseEntity updateByPrimaryKey(Brand brand) {
        return brandService.updateByPrimaryKey(brand) > 0 ? ResponseEntity.ok("修改成功！") : ResponseEntity.ok("修改失败！");
    }

}
