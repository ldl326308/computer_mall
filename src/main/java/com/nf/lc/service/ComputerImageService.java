package com.nf.lc.service;

import com.nf.lc.dao.ComputerImageMapper;
import com.nf.lc.entity.ComputerImage;
import com.nf.lc.service.impl.ComputerImageServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ComputerImageService implements ComputerImageServiceImp {

    @Autowired
    private ComputerImageMapper computerImageMapper;

    @Override
    public int deleteByPrimaryKey(Integer computerImageId) {
        return computerImageMapper.deleteByPrimaryKey(computerImageId);
    }

    @Override
    public int insert(ComputerImage record) {
        return computerImageMapper.insert(record);
    }

    @Override
    public ComputerImage selectByPrimaryKey(Integer computerImageId) {
        return computerImageMapper.selectByPrimaryKey(computerImageId);
    }

    @Override
    public List<ComputerImage> selectAll() {
        return computerImageMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(ComputerImage record) {
        return computerImageMapper.updateByPrimaryKey(record);
    }
}
