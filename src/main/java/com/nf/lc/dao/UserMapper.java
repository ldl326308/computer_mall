package com.nf.lc.dao;

import com.nf.lc.entity.User;
import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    User selectByPrimaryKey(Integer userId);

    List<User> selectAll();

    User loginVerify(User record);

    User selectAccountNumber(User record);

    int updateByPrimaryKey(User record);

    User selectVerifyState(User record);

}