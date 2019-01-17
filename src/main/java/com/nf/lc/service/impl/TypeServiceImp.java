package com.nf.lc.service.impl;

import com.nf.lc.dao.TypeMapper;
import com.nf.lc.entity.Type;
import com.nf.lc.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImp implements TypeService {

    @Autowired
    private TypeMapper typeMapper;

    @Override
    public int deleteByPrimaryKey(Integer typeId) {
        return typeMapper.deleteByPrimaryKey(typeId);
    }

    @Override
    public int insert(Type record) {
        return typeMapper.insert(record);
    }

    @Override
    public Type selectByPrimaryKey(Integer typeId) {
        return typeMapper.selectByPrimaryKey(typeId);
    }

    @Override
    public List<Type> selectAll() {
        return typeMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Type record) {
        return typeMapper.updateByPrimaryKey(record);
    }
}
