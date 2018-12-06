package com.nf.lc.service;

import com.nf.lc.dao.ComputerMapper;
import com.nf.lc.entity.Computer;
import com.nf.lc.entity.ComputerImage;
import com.nf.lc.entity.MyPageHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration("/spring/spring-dao.xml")
public class ComputerServiceTest {

    @Autowired
    private ComputerMapper computerMapper;

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void selectByPrimaryKey() {
    }

    @Test
    public void selectAll() {
        assert computerMapper.selectAll(new MyPageHelper(0,10)) != null;
        assert computerMapper.selectAll(new MyPageHelper(0,10)).size() == 10;
        for (Computer computer : computerMapper.selectAll(new MyPageHelper(0,20))) {
            System.out.println(computer.getComputerDescribe());
            System.out.println(computer.getComputerPrice());
            System.out.println("品牌："+computer.getBrand().getBrandName());
            System.out.println("系统："+computer.getComputerSystem().getComputerSystemName());
            System.out.println("图片路径：");
            for (ComputerImage computerImage : computer.getComputerImageList()) {
                System.out.println("  "+computerImage.getComputerImageUrl());
            }
            break;
        }

    }

    @Test
    public void updateByPrimaryKey() {
    }
}