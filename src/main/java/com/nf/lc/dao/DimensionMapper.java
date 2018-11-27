package com.nf.lc.dao;

import com.nf.lc.entity.Dimension;
import java.util.List;

public interface DimensionMapper {
    int deleteByPrimaryKey(Integer dimensionId);

    int insert(Dimension record);

    Dimension selectByPrimaryKey(Integer dimensionId);

    List<Dimension> selectAll();

    int updateByPrimaryKey(Dimension record);
}