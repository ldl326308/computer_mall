package com.nf.lc.service.impl;

import com.nf.lc.entity.MemoryCapacity;

import java.util.List;

public interface MemoryCapacityServiceImp {
    int deleteByPrimaryKey(Integer memoryCapacityId);

    int insert(MemoryCapacity record);

    MemoryCapacity selectByPrimaryKey(Integer memoryCapacityId);

    List<MemoryCapacity> selectAll();

    int updateByPrimaryKey(MemoryCapacity record);
}
