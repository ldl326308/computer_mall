package com.nf.lc.service;

import com.nf.lc.dao.UserMapper;
import com.nf.lc.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "/spring/spring-dao.xml")
public class UserServiceTest {

    @Autowired
    private UserMapper userMapper;
    @Test
    public void deleteByPrimaryKey() {

    }

    @Test
    public void insert() {
    }

    @Test
    public void loginVerify(){

        User user = new User();
        user.setUserAccountNumber("ldl326308");
        user.setUserPassword("12345");
        assert userMapper.loginVerify(user) != null;

        System.out.println(userMapper.loginVerify(user).getUserAccountNumber());

    }

    @Test
    public void selectByPrimaryKey() {
        assert userMapper.selectByPrimaryKey(1) != null;
        System.out.println(userMapper.selectByPrimaryKey(1).getUserAccountNumber());
    }

    @Test
    public void selectAll() {

    }

    @Test
    public void updateByPrimaryKey() {
    }
}