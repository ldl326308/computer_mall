package com.nf.lc.dao;

import com.nf.lc.entity.Nvdia;
import java.util.List;

public interface NvdiaMapper {
    int deleteByPrimaryKey(Integer nvdiaId);

    int insert(Nvdia record);

    Nvdia selectByPrimaryKey(Integer nvdiaId);

    List<Nvdia> selectAll();

    int updateByPrimaryKey(Nvdia record);
}