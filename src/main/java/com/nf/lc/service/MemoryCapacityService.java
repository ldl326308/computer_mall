package com.nf.lc.service;

import com.nf.lc.dao.MemoryCapacityMapper;
import com.nf.lc.entity.MemoryCapacity;
import com.nf.lc.service.impl.MemoryCapacityServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MemoryCapacityService implements MemoryCapacityServiceImp {

    @Autowired
    private MemoryCapacityMapper memoryCapacityMapper;

    @Override
    public int deleteByPrimaryKey(Integer memoryCapacityId) {
        return memoryCapacityMapper.deleteByPrimaryKey(memoryCapacityId);
    }

    @Override
    public int insert(MemoryCapacity record) {
        return memoryCapacityMapper.insert(record);
    }

    @Override
    public MemoryCapacity selectByPrimaryKey(Integer memoryCapacityId) {
        return memoryCapacityMapper.selectByPrimaryKey(memoryCapacityId);
    }

    @Override
    public List<MemoryCapacity> selectAll() {
        return memoryCapacityMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(MemoryCapacity record) {
        return memoryCapacityMapper.updateByPrimaryKey(record);
    }
}
