package com.nf.lc.controller;

import com.nf.lc.dto.Result;
import com.nf.lc.entity.Brand;
import com.nf.lc.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
    public Result selectAll() {
        List<Brand> brands = brandService.selectAll();
        return Result.success(brands,brands.size());
    }

    /**
     * 删除单个brand
     *
     * @param brandId
     * @return
     */
    @RequestMapping(value = "/brand/{brandId}", method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result deleteByPrimaryKey(@PathVariable("brandId") int brandId) {
        return brandService.deleteByPrimaryKey(brandId) > 0 ? Result.successMessage("删除成功！") : Result.error("删除失败！");
    }

    /**
     * 添加brand
     *
     * @param brand
     * @return
     */
    @RequestMapping(value = "/brand", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result insert(Brand brand) {
        return brandService.insert(brand) > 0 ? Result.successMessage("添加成功！") : Result.error("添加失败！");
    }

    /**
     * 查询单个brand
     *
     * @param brandId
     * @return
     */
    @RequestMapping(value = "/brand/{brandId}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result selectByPrimaryKey(@PathVariable("brandId") int brandId) {
        return Result.success(brandService.selectByPrimaryKey(brandId));
    }

    /**
     * 修改brand
     *
     * @param brand
     * @return
     */
    @RequestMapping(value = "/brand", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result updateByPrimaryKey(Brand brand) {
        return brandService.updateByPrimaryKey(brand) > 0 ? Result.successMessage("修改成功！") : Result.error("修改失败！");
    }

}
