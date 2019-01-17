package com.nf.lc.service;

import com.nf.lc.entity.User;
import com.nf.lc.exception.EmptyException;
import com.nf.lc.exception.FailureException;
import com.nf.lc.exception.FrozenAccountsException;
import com.nf.lc.exception.NonExistentException;

import java.util.List;

public interface UserService {

    int deleteByPrimaryKey(Integer userId);

    void insert(User record) throws FailureException;

    User selectByPrimaryKey(Integer userId);

    User selectByUserAccountNumber(String userAccountNumber) throws EmptyException, FailureException;

    List<User> selectAll(int page,int userState) throws EmptyException;

    User loginVerify(User record) throws NonExistentException, FrozenAccountsException;

    User selectAccountNumber(User record);

    int updateByPrimaryKey(User record);

    User selectVerifyState(User record);

    int updateByPrimaryKeyToState(User user) throws FrozenAccountsException;

    int selectUserCountIsState(int userState);

    int updateResetUserPassword(int userId) throws FrozenAccountsException;

}
