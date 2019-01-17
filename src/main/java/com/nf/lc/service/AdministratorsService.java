package com.nf.lc.service;

import com.nf.lc.entity.Administrators;
import com.nf.lc.exception.EmptyException;
import com.nf.lc.exception.FailureException;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdministratorsService {
    int deleteByPrimaryKey(Integer adminId) throws FailureException;

    int insert(Administrators record) throws FailureException;

    Administrators selectByPrimaryKey(Integer adminId);

    List<Administrators> selectByLikeAdminIdNumber(int page,String adminIdNumber) throws EmptyException;

    int resetAdminPassword(int adminId) throws FailureException;

    int selectByLikeAdminIdNumberCount(String adminIdNumber);

    int selectAdministratorsCountIsState(int state);

    List<Administrators> selectAll(int page,int state) throws EmptyException;

    int updateByPrimaryKey(Administrators record) throws FailureException;

    Administrators loginVerify(String adminAccountNumber ,String adminPassword) throws EmptyException;

}
