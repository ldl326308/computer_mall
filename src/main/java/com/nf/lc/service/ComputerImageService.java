package com.nf.lc.service;

import com.nf.lc.entity.ComputerImage;

import java.util.List;

public interface ComputerImageService {
    int deleteByPrimaryKey(Integer computerImageId);

    int insert(ComputerImage record);

    List<ComputerImage> selectByPrimaryKey(Integer computerId);

    List<ComputerImage> selectAll();

    int updateByPrimaryKey(ComputerImage record);
}
