package com.nf.lc.service;

import com.nf.lc.entity.Processor;

import java.util.List;

public interface ProcessorService {

    int deleteByPrimaryKey(Integer processorId);

    int insert(Processor record);

    Processor selectByPrimaryKey(Integer processorId);

    List<Processor> selectAll();

    int updateByPrimaryKey(Processor record);

}
