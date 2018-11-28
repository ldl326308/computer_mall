package com.nf.lc.service;

import com.nf.lc.dao.HardDiskMapper;
import com.nf.lc.entity.HardDisk;
import com.nf.lc.service.impl.HardDiskServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HardDiskService implements HardDiskServiceImp {

    @Autowired
    private HardDiskMapper hardDiskMapper;

    @Override
    public int deleteByPrimaryKey(Integer hardDiskId) {
        return hardDiskMapper.deleteByPrimaryKey(hardDiskId);
    }

    @Override
    public int insert(HardDisk record) {
        return hardDiskMapper.insert(record);
    }

    @Override
    public HardDisk selectByPrimaryKey(Integer hardDiskId) {
        return hardDiskMapper.selectByPrimaryKey(hardDiskId);
    }

    @Override
    public List<HardDisk> selectAll() {
        return hardDiskMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(HardDisk record) {
        return hardDiskMapper.updateByPrimaryKey(record);
    }
}
