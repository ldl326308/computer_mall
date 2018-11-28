package com.nf.lc.service;

import com.nf.lc.dao.ComputerMapper;
import com.nf.lc.entity.Computer;
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
    public Computer selectByPrimaryKey(Integer computerId) {
        return computerMapper.selectByPrimaryKey(computerId);
    }

    @Override
    public List<Computer> selectAll() {
        return computerMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Computer record) {
        return computerMapper.updateByPrimaryKey(record);
    }
}
