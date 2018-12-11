package com.nf.lc.service;

import com.nf.lc.dao.ComputerMapper;
import com.nf.lc.entity.Computer;
import com.nf.lc.entity.QueryDataParameter;
import com.nf.lc.entity.SelectLikePrams;
import com.nf.lc.exception.EmptyException;
import com.nf.lc.service.impl.ComputerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComputerService implements ComputerServiceImp {

    @Autowired
    private ComputerMapper computerMapper;

    @Override
    public int deleteByPrimaryKey(Integer computerId) {
        return computerMapper.deleteByPrimaryKey(computerId);
    }

    @Override
    public int insert(Computer record) {
        return computerMapper.insert(record);
    }

    @Override
    public Computer selectByPrimaryKey(Integer computerId) throws EmptyException {
        Computer computer = computerMapper.selectByPrimaryKey(computerId);
        if(computer == null){
            throw new EmptyException("数据获取失败！");
        }
        return computer;
    }


    @Override
    public int updateByPrimaryKey(Computer record) {
        return computerMapper.updateByPrimaryKey(record);
    }

    @Override
    public int selectCount(QueryDataParameter queryDataParameter) {
        return computerMapper.selectCount(queryDataParameter);
    }

    @Override
    public List<Computer> selectLikeDescribe(SelectLikePrams selectLikePrams) throws EmptyException {
        selectLikePrams.setPage((selectLikePrams.getPage() - 1) * selectLikePrams.getCount());
        List<Computer> computers = computerMapper.selectLikeDescribe(selectLikePrams);
        if (computers == null || computers.size() == 0) {
            throw new EmptyException("没有数据！");
        }
        return computers;
    }

    @Override
    public int selectLikeDescribeCount(SelectLikePrams selectLikePrams) {
        selectLikePrams.setPage((selectLikePrams.getPage() - 1) * selectLikePrams.getCount());
        return computerMapper.selectLikeDescribeCount(selectLikePrams);
    }


    @Override
    public List<Computer> selectAll(QueryDataParameter queryDataParameter) throws EmptyException {
        queryDataParameter.setPage((queryDataParameter.getPage() - 1) * queryDataParameter.getCount());
        List<Computer> computers = computerMapper.selectAll(queryDataParameter);
        if (computers.size() == 0 || computers == null) {
            throw new EmptyException("没有数据！");
        }
        return computers;
    }

}
