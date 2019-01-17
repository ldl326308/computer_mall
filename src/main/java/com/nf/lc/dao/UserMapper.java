package com.nf.lc.dao;

import com.nf.lc.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    User selectByPrimaryKey(Integer userId);

    User selectByUserAccountNumber(String userAccountNumber);

    List<User> selectAll(@Param("userState") int userState);

    User loginVerify(User record);

    User selectAccountNumber(User record);

    int updateByPrimaryKey(User record);

    User selectVerifyState(User record);

    int updateByPrimaryKeyToState(User user);

    int selectUserCountIsState(@Param("userState") int userState);

    int updateResetUserPassword(int userId);

    List<User> exportUser(@Param("userState") int userState,@Param("start") int start,@Param("end")  int end);

}