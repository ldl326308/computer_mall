package com.nf.lc.dao;

import com.nf.lc.entity.Address;
import java.util.List;

public interface AddressMapper {
    int deleteByPrimaryKey(Integer addressId);

    int insert(Address record);

    Address selectByPrimaryKey(Integer addressId);

    List<Address> selectAll();

    int updateByPrimaryKey(Address record);
}