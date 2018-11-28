package com.nf.lc.service.impl;

import com.nf.lc.entity.Processor;

import java.util.List;

public interface ProcessorServiceImp {

    int deleteByPrimaryKey(Integer processorId);

    int insert(Processor record);

    Processor selectByPrimaryKey(Integer processorId);

    List<Processor> selectAll();

    int updateByPrimaryKey(Processor record);

}
