package com.nf.lc.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "/spring/spring-dao.xml")
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void deleteByPrimaryKey() {

    }

    @Test
    public void insert() {
    }

    @Test
    public void selectByPrimaryKey() {
        assert userService.selectByPrimaryKey(1) != null;
    }

    @Test
    public void selectAll() {
        assert userService.selectAll() != null;
    }

    @Test
    public void updateByPrimaryKey() {
    }
}