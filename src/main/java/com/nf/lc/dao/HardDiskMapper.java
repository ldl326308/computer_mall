package com.nf.lc.dao;

import com.nf.lc.entity.HardDisk;
import java.util.List;

public interface HardDiskMapper {
    int deleteByPrimaryKey(Integer hardDiskId);

    int insert(HardDisk record);

    HardDisk selectByPrimaryKey(Integer hardDiskId);

    List<HardDisk> selectAll();

    int updateByPrimaryKey(HardDisk record);
}