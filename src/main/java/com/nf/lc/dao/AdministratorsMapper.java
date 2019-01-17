package com.nf.lc.dao;

import com.nf.lc.entity.Administrators;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdministratorsMapper {
    int deleteByPrimaryKey(Integer adminId);

    int insert(Administrators record);

    Administrators selectByPrimaryKey(Integer adminId);

    List<Administrators> selectByLikeAdminIdNumber(String adminIdNumber);

    Administrators selectByAdminAccountNumber(String adminAccountNumber);

    List<Administrators> selectAll(@Param("state") int state);

    int updateByPrimaryKey(Administrators record);

    int selectAdministratorsCountIsState(@Param("state") int state);

    int selectByLikeAdminIdNumberCount(String adminIdNumber);

    List<Administrators> exportAdmin(@Param("adminState") int adminState, @Param("start") int start, @Param("end") int end);

    int resetAdminPassword(int adminId);

    Administrators loginVerify(@Param("adminAccountNumber") String adminAccountNumber, @Param("adminPassword") String adminPassword);

}
