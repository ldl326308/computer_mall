package com.nf.lc.service.impl;

import com.nf.lc.entity.Computer;

import java.util.List;

public interface ComputerServiceImp {
    int deleteByPrimaryKey(Integer computerId);

    int insert(Computer record);

    Computer selectByPrimaryKey(Integer computerId);

    List<Computer> selectAll();

    int updateByPrimaryKey(Computer record);
}
