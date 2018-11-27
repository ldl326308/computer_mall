package com.nf.lc.dao;

import com.nf.lc.entity.ComputerImage;
import java.util.List;

public interface ComputerImageMapper {
    int deleteByPrimaryKey(Integer computerImageId);

    int insert(ComputerImage record);

    ComputerImage selectByPrimaryKey(Integer computerImageId);

    List<ComputerImage> selectAll();

    int updateByPrimaryKey(ComputerImage record);
}