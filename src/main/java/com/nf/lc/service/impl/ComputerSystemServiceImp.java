package com.nf.lc.service.impl;

import com.nf.lc.dao.ComputerSystemMapper;
import com.nf.lc.entity.ComputerSystem;
import com.nf.lc.service.ComputerSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ComputerSystemServiceImp implements ComputerSystemService {

    @Autowired
    private ComputerSystemMapper computerSystemMapper;

    @Override
    public int deleteByPrimaryKey(Integer computerSystemId) {
        return computerSystemMapper.deleteByPrimaryKey(computerSystemId);
    }

    @Override
    public int insert(ComputerSystem record) {
        return computerSystemMapper.insert(record);
    }

    @Override
    public ComputerSystem selectByPrimaryKey(Integer computerSystemId) {
        return computerSystemMapper.selectByPrimaryKey(computerSystemId);
    }

    @Override
    public List<ComputerSystem> selectAll() {
        return computerSystemMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(ComputerSystem record) {
        return computerSystemMapper.updateByPrimaryKey(record);
    }
}
