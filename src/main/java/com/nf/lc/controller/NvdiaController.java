package com.nf.lc.controller;

import com.nf.lc.dto.Result;
import com.nf.lc.entity.Nvdia;
import com.nf.lc.service.impl.NvdiaServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class NvdiaController {

    @Autowired
    private NvdiaServiceImp nvdiaServiceImp;

    /**
     * 查询所有brand数据
     *
     * @return
     */
    @RequestMapping(value = "/nvdia", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result selectAll() {
        List<Nvdia> nvdias = nvdiaServiceImp.selectAll();
        return Result.success(nvdias,nvdias.size());
    }

    /**
     * 删除单个brand
     *
     * @param nvdiaId
     * @return
     */
    @RequestMapping(value = "/nvdia/{nvdiaId}", method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result deleteByPrimaryKey(@PathVariable("nvdiaId") int nvdiaId) {
        return nvdiaServiceImp.deleteByPrimaryKey(nvdiaId) > 0 ? Result.successMessage("删除成功!") : Result.error("删除失败！");
    }

    /**
     * 添加brand
     *
     * @param nvdia
     * @return
     */
    @RequestMapping(value = "/nvdia", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result insert(Nvdia nvdia) {
        return nvdiaServiceImp.insert(nvdia) > 0 ? Result.successMessage("添加成功！") : Result.error("添加失败！");
    }

    /**
     * 查询单个brand
     *
     * @param nvdiaId
     * @return
     */
    @RequestMapping(value = "/nvdia/{nvdiaId}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result selectByPrimaryKey(@PathVariable("nvdiaId") int nvdiaId) {
        return Result.success(nvdiaServiceImp.selectByPrimaryKey(nvdiaId));
    }

    /**
     * 修改brand
     *
     * @param nvdia
     * @return
     */
    @RequestMapping(value = "/nvdia", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Result updateByPrimaryKey(Nvdia nvdia) {
        return nvdiaServiceImp.updateByPrimaryKey(nvdia) > 0 ? Result.successMessage("修改成功！") : Result.error("修改失败！");
    }

}
