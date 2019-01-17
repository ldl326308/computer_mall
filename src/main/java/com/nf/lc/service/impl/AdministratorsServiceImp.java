package com.nf.lc.service.impl;

import com.github.pagehelper.PageHelper;
import com.nf.lc.dao.AdministratorsMapper;
import com.nf.lc.dto.IdNumberVerifyAndAnalyze;
import com.nf.lc.entity.Administrators;
import com.nf.lc.exception.EmptyException;
import com.nf.lc.exception.FailureException;
import com.nf.lc.service.AdministratorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class AdministratorsServiceImp implements AdministratorsService {

    @Autowired
    private AdministratorsMapper administratorsMapper;

    @Override
    public int deleteByPrimaryKey(Integer adminId) throws FailureException {
        if (adminId != 1) {
            int flag = administratorsMapper.deleteByPrimaryKey(adminId);
            if (flag > 0) {
                return flag;
            } else {
                throw new FailureException("删除失败！");
            }
        }
        throw new FailureException("无法删除此管理员！");

    }

    @Override
    public int insert(Administrators record) throws FailureException {
        HashMap<String, Object> result = IdNumberVerifyAndAnalyze.verifyAndAnalyze(record.getAdminIdNumber());

        List<String> errors = (List<String>) result.get("errors");
        if (errors.size() > 0) {
            throw new FailureException(errors.get(0));
        }

        //验证该身份证号是否注册过
        List<Administrators> administrators = administratorsMapper.selectByLikeAdminIdNumber(record.getAdminIdNumber());
        if (administrators.size() > 0) {
            throw new FailureException("添加失败，身份证号：" + record.getAdminIdNumber() + "已经注册过了！");
        }

        //验证账号是否被注册
        if (administratorsMapper.selectByAdminAccountNumber(record.getAdminAccountNumber()) != null) {
            throw new FailureException("添加失败,账号：" + record.getAdminAccountNumber() + "已经被注册过了！");
        }

        record.setAdminAge((Integer) result.get("age"));
        record.setAdminSexual((String) result.get("sexual"));
        record.setAdminPassword("123456");
        int count = administratorsMapper.insert(record);
        if (count > 0) {
            return count;
        }

        throw new FailureException("添加失败了！");
    }

    @Override
    public Administrators selectByPrimaryKey(Integer adminId) {
        return administratorsMapper.selectByPrimaryKey(adminId);
    }

    @Override
    public List<Administrators> selectByLikeAdminIdNumber(int page, String adminIdNumber) throws EmptyException {
        PageHelper.startPage(page, 10);
        List<Administrators> list = administratorsMapper.selectByLikeAdminIdNumber(adminIdNumber);
        if (list.size() > 0) {
            return list;
        }
        throw new EmptyException("没有查询到数据");
    }

    @Override
    public int resetAdminPassword(int adminId) throws FailureException {
        if(adminId == 1){
            throw new FailureException("不可以重置该管理员密码！");
        }

        int count = administratorsMapper.resetAdminPassword(adminId);
        if(count > 0){
            return count;
        }
        throw new FailureException("重置密码失败！");
    }

    @Override
    public int selectByLikeAdminIdNumberCount(String adminIdNumber) {
        return administratorsMapper.selectByLikeAdminIdNumberCount(adminIdNumber);
    }

    @Override
    public int selectAdministratorsCountIsState(int state) {
        return administratorsMapper.selectAdministratorsCountIsState(state);
    }

    @Override
    public List<Administrators> selectAll(int page, int state) throws EmptyException {
        PageHelper.startPage(page, 10);
        List<Administrators> list = administratorsMapper.selectAll(state);
        if (list.size() > 0) {
            return list;
        }
        throw new EmptyException("没有查询到数据");
    }

    @Override
    public int updateByPrimaryKey(Administrators record) throws FailureException {
        if (record.getAdminId() == 1) {
            throw new FailureException("无法修改此管理员信息！");
        } else {

            HashMap<String, Object> result = IdNumberVerifyAndAnalyze.verifyAndAnalyze(record.getAdminIdNumber());

            List<String> errors = (List<String>) result.get("errors");
            if(errors.size() > 0){
                throw new FailureException(errors.get(0));
            }

            record.setAdminSexual((String) result.get("sexual"));
            record.setAdminAge((Integer) result.get("age"));

            if (administratorsMapper.updateByPrimaryKey(record) > 0) {
                return 1;
            } else {
                throw new FailureException("修改失败！");
            }
        }
    }

    @Override
    public Administrators loginVerify(String adminAccountNumber, String adminPassword) throws EmptyException {
        if(administratorsMapper.selectByAdminAccountNumber(adminAccountNumber) == null){
            throw new EmptyException("账号错误，登入失败！");
        }

        Administrators administrators = administratorsMapper.loginVerify(adminAccountNumber, adminPassword);
        if(administrators == null){
            throw new EmptyException("密码错误，登入失败！");
        }
        return administrators;
    }

}
