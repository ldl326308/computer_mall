package com.nf.lc.service.impl;

import com.nf.lc.dao.ProcessorMapper;
import com.nf.lc.entity.Processor;
import com.nf.lc.service.ProcessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessorServiceImp implements ProcessorService {

    @Autowired
    private ProcessorMapper processorMapper;

    @Override
    public int deleteByPrimaryKey(Integer processorId) {
        return processorMapper.deleteByPrimaryKey(processorId);
    }

    @Override
    public int insert(Processor record) {
        return processorMapper.insert(record);
    }

    @Override
    public Processor selectByPrimaryKey(Integer processorId) {
        return processorMapper.selectByPrimaryKey(processorId);
    }

    @Override
    public List<Processor> selectAll() {
        return processorMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Processor record) {
        return processorMapper.updateByPrimaryKey(record);
    }
}
