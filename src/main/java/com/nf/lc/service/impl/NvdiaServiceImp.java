package com.nf.lc.service.impl;

import com.nf.lc.dao.NvdiaMapper;
import com.nf.lc.entity.Nvdia;
import com.nf.lc.service.NvdiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NvdiaServiceImp implements NvdiaService {

    @Autowired
    private NvdiaMapper nvdiaMapper;

    @Override
    public int deleteByPrimaryKey(Integer nvdiaId) {
        return nvdiaMapper.deleteByPrimaryKey(nvdiaId);
    }

    @Override
    public int insert(Nvdia record) {
        return nvdiaMapper.insert(record);
    }

    @Override
    public Nvdia selectByPrimaryKey(Integer nvdiaId) {
        return nvdiaMapper.selectByPrimaryKey(nvdiaId);
    }

    @Override
    public List<Nvdia> selectAll() {
        return nvdiaMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Nvdia record) {
        return nvdiaMapper.updateByPrimaryKey(record);
    }
}
