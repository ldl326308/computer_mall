package com.nf.lc.service.impl;

import com.nf.lc.entity.ComputerImage;

import java.util.List;

public interface ComputerImageServiceImp {
    int deleteByPrimaryKey(Integer computerImageId);

    int insert(ComputerImage record);

    ComputerImage selectByPrimaryKey(Integer computerImageId);

    List<ComputerImage> selectAll();

    int updateByPrimaryKey(ComputerImage record);
}
