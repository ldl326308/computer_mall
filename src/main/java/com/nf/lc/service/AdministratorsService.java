package com.nf.lc.service;

import com.nf.lc.dao.AdministratorsMapper;
import com.nf.lc.entity.Administrators;
import com.nf.lc.service.impl.AdministratorsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdministratorsService implements AdministratorsServiceImp {

    @Autowired
    private AdministratorsMapper administratorsMapper;

    @Override
    public int deleteByPrimaryKey(Integer adminId) {
        return administratorsMapper.deleteByPrimaryKey(adminId);
    }

    @Override
    public int insert(Administrators record) {
        return administratorsMapper.insert(record);
    }

    @Override
    public Administrators selectByPrimaryKey(Integer adminId) {
        return administratorsMapper.selectByPrimaryKey(adminId);
    }

    @Override
    public List<Administrators> selectAll() {
        return administratorsMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Administrators record) {
        return administratorsMapper.updateByPrimaryKey(record);
    }
}
