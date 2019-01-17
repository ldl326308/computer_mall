package com.nf.lc.service.impl;

import com.nf.lc.dao.BrandMapper;
import com.nf.lc.entity.Brand;
import com.nf.lc.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImp implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public int deleteByPrimaryKey(Integer brandId) {
        return brandMapper.deleteByPrimaryKey(brandId);
    }

    @Override
    public int insert(Brand record) {
        return brandMapper.insert(record);
    }

    @Override
    public Brand selectByPrimaryKey(Integer brandId) {
        return brandMapper.selectByPrimaryKey(brandId);
    }

    @Override
    public List<Brand> selectAll() {
        return brandMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Brand record) {
        return brandMapper.updateByPrimaryKey(record);
    }
}
