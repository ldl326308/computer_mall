package com.nf.lc.service.impl;

import com.nf.lc.entity.Computer;
import com.nf.lc.entity.MyPageHelper;
import com.nf.lc.exception.EmptyException;

import java.util.List;

public interface ComputerServiceImp {
    int deleteByPrimaryKey(Integer computerId);

    int insert(Computer record);

    Computer selectByPrimaryKey(Integer computerId);

    List<Computer> selectAll(MyPageHelper myPageHelper) throws EmptyException;

    int updateByPrimaryKey(Computer record);

    int selectCount();
}
