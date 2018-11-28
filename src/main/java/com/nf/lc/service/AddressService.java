package com.nf.lc.service;

import com.nf.lc.dao.AddressMapper;
import com.nf.lc.entity.Address;
import com.nf.lc.service.impl.AddressServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService implements AddressServiceImp {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public int deleteByPrimaryKey(Integer addressId) {
        return addressMapper.deleteByPrimaryKey(addressId);
    }

    @Override
    public int insert(Address record) {
        return addressMapper.insert(record);
    }

    @Override
    public Address selectByPrimaryKey(Integer addressId) {
        return addressMapper.selectByPrimaryKey(addressId);
    }

    @Override
    public List<Address> selectAll() {
        return addressMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Address record) {
        return addressMapper.updateByPrimaryKey(record);
    }


}
