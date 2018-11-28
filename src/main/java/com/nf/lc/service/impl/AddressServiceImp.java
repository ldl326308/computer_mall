package com.nf.lc.service.impl;

import com.nf.lc.entity.Address;

import java.util.List;

public interface AddressServiceImp {
    int deleteByPrimaryKey(Integer addressId);

    int insert(Address record);

    Address selectByPrimaryKey(Integer addressId);

    List<Address> selectAll();

    int updateByPrimaryKey(Address record);
}
