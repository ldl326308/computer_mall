package com.nf.lc.service;

import com.nf.lc.entity.Address;
import com.nf.lc.exception.EmptyException;
import com.nf.lc.exception.FailureException;

import java.util.List;

public interface AddressService {
    int deleteByPrimaryKey(Integer addressId);

    int insert(Address record) throws FailureException, EmptyException;

    Address selectByPrimaryKey(Integer addressId);

    List<Address> selectAll(int uId) throws EmptyException;

    int updateByPrimaryKey(Address record);
}
