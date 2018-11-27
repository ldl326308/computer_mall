package com.nf.lc.dao;

import com.nf.lc.entity.Type;
import java.util.List;

public interface TypeMapper {
    int deleteByPrimaryKey(Integer typeId);

    int insert(Type record);

    Type selectByPrimaryKey(Integer typeId);

    List<Type> selectAll();

    int updateByPrimaryKey(Type record);
}