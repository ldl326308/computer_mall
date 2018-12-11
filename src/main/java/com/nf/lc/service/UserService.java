package com.nf.lc.service;

import com.nf.lc.dao.UserMapper;
import com.nf.lc.entity.User;
import com.nf.lc.exception.FailureException;
import com.nf.lc.exception.FrozenAccountsException;
import com.nf.lc.exception.NonExistentException;
import com.nf.lc.service.impl.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceImp {

    @Autowired
    private UserMapper userMapper;


    @Override
    public int deleteByPrimaryKey(Integer userId) {
        return userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public void insert(User record) throws FailureException {

        //该账号被注册
        if (userMapper.selectAccountNumber(record) != null) {
            throw new FailureException("注册失败，该账号已被注册！");
        } else {
            if (userMapper.insert(record) < 0) {
                throw new FailureException("意料之外的错误，请联系S3S147班LC程序员！");
            }
        }
    }

    @Override
    public User selectByPrimaryKey(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public User loginVerify(User record) throws NonExistentException, FrozenAccountsException {
        if (userMapper.loginVerify(record) != null) { //验证通过，账号和密码都正确
            //验证该用户状态是否为冻结
            User user = userMapper.selectVerifyState(record);
            if (user != null) {
                return user;
            }
            throw new FrozenAccountsException("登入失败，该账号已经冻结！");
        } else {
            //没有找到，验证失败
            if (userMapper.selectAccountNumber(record) != null) {
                throw new NonExistentException("验证失败，密码错误！");
            }
            throw new NonExistentException("验证失败，账号错误！");
        }
    }

    @Override
    public User selectAccountNumber(User record) {
        return userMapper.selectAccountNumber(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }


    @Override
    public User selectVerifyState(User record) {
        return userMapper.selectVerifyState(record);
    }
}
