package com.nf.lc.service;

import com.nf.lc.entity.HardDisk;

import java.util.List;

public interface HardDiskService {
    int deleteByPrimaryKey(Integer hardDiskId);

    int insert(HardDisk record);

    HardDisk selectByPrimaryKey(Integer hardDiskId);

    List<HardDisk> selectAll();

    int updateByPrimaryKey(HardDisk record);
}
