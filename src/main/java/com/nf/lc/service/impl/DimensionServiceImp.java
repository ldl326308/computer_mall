package com.nf.lc.service.impl;

import com.nf.lc.entity.Dimension;

import java.util.List;

public interface DimensionServiceImp {
    int deleteByPrimaryKey(Integer dimensionId);

    int insert(Dimension record);

    Dimension selectByPrimaryKey(Integer dimensionId);

    List<Dimension> selectAll();

    int updateByPrimaryKey(Dimension record);
}
