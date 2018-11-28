package com.nf.lc.service.impl;

import com.nf.lc.entity.Administrators;

import java.util.List;

public interface AdministratorsServiceImp {
    int deleteByPrimaryKey(Integer adminId);

    int insert(Administrators record);

    Administrators selectByPrimaryKey(Integer adminId);

    List<Administrators> selectAll();

    int updateByPrimaryKey(Administrators record);

}
