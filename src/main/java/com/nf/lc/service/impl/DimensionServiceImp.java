package com.nf.lc.service.impl;

import com.nf.lc.dao.DimensionMapper;
import com.nf.lc.entity.Dimension;
import com.nf.lc.service.DimensionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DimensionServiceImp implements DimensionService {

    @Autowired
    private DimensionMapper dimensionMapper;

    @Override
    public int deleteByPrimaryKey(Integer dimensionId) {
        return dimensionMapper.deleteByPrimaryKey(dimensionId);
    }

    @Override
    public int insert(Dimension record) {
        return dimensionMapper.insert(record);
    }

    @Override
    public Dimension selectByPrimaryKey(Integer dimensionId) {
        return dimensionMapper.selectByPrimaryKey(dimensionId);
    }

    @Override
    public List<Dimension> selectAll() {
        return dimensionMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Dimension record) {
        return dimensionMapper.updateByPrimaryKey(record);
    }
}
