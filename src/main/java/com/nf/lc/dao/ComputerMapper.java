package com.nf.lc.dao;

import com.nf.lc.entity.Computer;
import com.nf.lc.entity.QueryDataParameter;
import com.nf.lc.entity.SelectLikePrams;
import java.util.List;

public interface ComputerMapper {
    int deleteByPrimaryKey(Integer computerId);

    int insert(Computer record);

    Computer selectByPrimaryKey(Integer computerId);

    List<Computer> selectAll(QueryDataParameter queryDataParameter);

    int updateByPrimaryKey(Computer record);

    int selectCount(QueryDataParameter queryDataParameter);

    List<Computer> selectLikeDescribe(SelectLikePrams selectLikePrams);

    int selectLikeDescribeCount(SelectLikePrams selectLikePrams);
}