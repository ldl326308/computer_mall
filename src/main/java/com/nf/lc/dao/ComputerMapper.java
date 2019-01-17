package com.nf.lc.dao;

import com.nf.lc.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ComputerMapper {
    int deleteByPrimaryKey(Integer computerId);

    int insert(InsertComputerParam record);

    List<Computer> selectAllByComputerState(@Param("computerState") int computerState);

    int selectAllByComputerStateCount(@Param("computerState") int computerState);

    Computer selectByPrimaryKey(Integer computerId);

    List<Computer> selectAll(QueryDataParameter queryDataParameter);

    int updateByPrimaryKey(UpdateComputerParam record);

    int selectCount(QueryDataParameter queryDataParameter);

    List<Computer> selectLikeDescribe(SelectLikePrams selectLikePrams);

    int selectLikeDescribeCount(SelectLikePrams selectLikePrams);

}