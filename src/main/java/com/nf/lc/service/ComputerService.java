package com.nf.lc.service;

import com.nf.lc.entity.*;
import com.nf.lc.exception.EmptyException;
import com.nf.lc.exception.FailureException;

import java.util.List;

public interface ComputerService {
    int deleteByPrimaryKey(Integer computerId);

    int insert(InsertComputerParam record) throws FailureException;

    List<Computer> selectAllByComputerState(int page,int computerState) throws EmptyException;

    int selectAllByComputerStateCount(int computerState);

    Computer selectByPrimaryKey(Integer computerId) throws EmptyException;

    List<Computer> selectAll(QueryDataParameter queryDataParameter) throws EmptyException;

    int updateByPrimaryKey(UpdateComputerParam record) throws FailureException;

    int selectCount(QueryDataParameter queryDataParameter);

    List<Computer> selectLikeDescribe(SelectLikePrams selectLikePrams) throws EmptyException;

    int selectLikeDescribeCount(SelectLikePrams selectLikePrams);
}
