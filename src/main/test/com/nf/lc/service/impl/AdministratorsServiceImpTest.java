package com.nf.lc.service.impl;

import com.nf.lc.dao.AdministratorsMapper;
import com.nf.lc.entity.Administrators;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration("/spring/spring-dao.xml")
public class AdministratorsServiceImpTest {

    @Autowired
    private AdministratorsMapper mapper;

    @Test
    public void loginVerify() {

        Administrators administrators = mapper.loginVerify("ldl12345", "nihaoma");
        System.out.println(administrators);

    }
}