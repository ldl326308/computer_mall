package com.nf.lc.dao;

import com.nf.lc.entity.Computer;
import java.util.List;

public interface ComputerMapper {
    int deleteByPrimaryKey(Integer computerId);

    int insert(Computer record);

    Computer selectByPrimaryKey(Integer computerId);

    List<Computer> selectAll();

    int updateByPrimaryKey(Computer record);
}