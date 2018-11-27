package com.nf.lc.service.impl;

import com.nf.lc.entity.User;

import java.util.List;

public interface UserServiceImp {

    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    User selectByPrimaryKey(Integer userId);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

}
