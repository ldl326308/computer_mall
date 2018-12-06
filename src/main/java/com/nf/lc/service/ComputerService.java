package com.nf.lc.service;

import com.github.pagehelper.PageHelper;
import com.nf.lc.dao.ComputerMapper;
import com.nf.lc.entity.Computer;
import com.nf.lc.entity.MyPageHelper;
import com.nf.lc.exception.EmptyException;
import com.nf.lc.service.impl.ComputerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<Computer> selectAll(MyPageHelper myPageHelper) throws EmptyException {
        List<Computer> list = new ArrayList<Computer>();
        list = computerMapper.selectAll(myPageHelper);
        if(list == null || list.size() == 0){
            throw new EmptyException("没有数据！");
        }
        return list;
    }

    @Override
    public int updateByPrimaryKey(Computer record) {
        return computerMapper.updateByPrimaryKey(record);
    }

    @Override
    public int selectCount() {
        return computerMapper.selectCount();
    }
}
