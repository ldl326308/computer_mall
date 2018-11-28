package com.nf.lc.service;

import com.nf.lc.dao.TypeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration("/spring/spring-dao.xml")
public class TypeServiceTest {

    @Autowired
    private TypeMapper typeMapper;

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
        assert typeMapper.selectAll() != null;
    }

    @Test
    public void updateByPrimaryKey() {
    }
}