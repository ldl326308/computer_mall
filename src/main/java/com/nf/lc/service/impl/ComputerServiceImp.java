package com.nf.lc.service.impl;

import com.nf.lc.entity.Computer;
import com.nf.lc.entity.QueryDataParameter;
import com.nf.lc.entity.SelectLikePrams;
import com.nf.lc.exception.EmptyException;

import java.util.List;

public interface ComputerServiceImp {
    int deleteByPrimaryKey(Integer computerId);

    int insert(Computer record);

    Computer selectByPrimaryKey(Integer computerId) throws EmptyException;

    List<Computer> selectAll(QueryDataParameter queryDataParameter) throws EmptyException;

    int updateByPrimaryKey(Computer record);

    int selectCount(QueryDataParameter queryDataParameter);

    List<Computer> selectLikeDescribe(SelectLikePrams selectLikePrams) throws EmptyException;

    int selectLikeDescribeCount(SelectLikePrams selectLikePrams);
}
