package com.nf.lc.service;

import com.nf.lc.entity.Brand;

import java.util.List;

public interface BrandService {
    int deleteByPrimaryKey(Integer brandId);

    int insert(Brand record);

    Brand selectByPrimaryKey(Integer brandId);

    List<Brand> selectAll();

    int updateByPrimaryKey(Brand record);
}
