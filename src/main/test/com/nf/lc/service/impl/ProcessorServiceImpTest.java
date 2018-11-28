package com.nf.lc.service.impl;

import com.nf.lc.service.ProcessorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration("/spring/spring-dao.xml")
public class ProcessorServiceImpTest {

    @Autowired
    private ProcessorService processorService;

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void selectByPrimaryKey() {
    }

    @Test
    public void selectAll() {
        assert processorService.selectAll() != null;
    }

    @Test
    public void updateByPrimaryKey() {
    }
}