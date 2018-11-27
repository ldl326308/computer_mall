package com.nf.lc.dao;

import com.nf.lc.entity.Administrators;
import java.util.List;

public interface AdministratorsMapper {
    int deleteByPrimaryKey(Integer adminId);

    int insert(Administrators record);

    Administrators selectByPrimaryKey(Integer adminId);

    List<Administrators> selectAll();

    int updateByPrimaryKey(Administrators record);
}