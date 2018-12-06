package com.nf.lc.service.impl;

import com.nf.lc.entity.User;
import com.nf.lc.exception.FailureException;
import com.nf.lc.exception.FrozenAccountsException;
import com.nf.lc.exception.NonExistentException;

import java.util.List;

public interface UserServiceImp {

    int deleteByPrimaryKey(Integer userId);

    int insert(User record) throws FailureException;

    User selectByPrimaryKey(Integer userId);

    List<User> selectAll();

    User loginVerify(User record) throws NonExistentException, FrozenAccountsException;

    User selectAccountNumber(User record);

    int updateByPrimaryKey(User record);

    User selectVerifyState(User record);

}
