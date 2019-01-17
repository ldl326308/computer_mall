package com.nf.lc.service;

import com.nf.lc.entity.MemoryCapacity;

import java.util.List;

public interface MemoryCapacityService {
    int deleteByPrimaryKey(Integer memoryCapacityId);

    int insert(MemoryCapacity record);

    MemoryCapacity selectByPrimaryKey(Integer memoryCapacityId);

    List<MemoryCapacity> selectAll();

    int updateByPrimaryKey(MemoryCapacity record);
}
