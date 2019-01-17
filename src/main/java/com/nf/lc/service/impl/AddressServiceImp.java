package com.nf.lc.service.impl;

import com.nf.lc.dao.AddressMapper;
import com.nf.lc.entity.Address;
import com.nf.lc.exception.EmptyException;
import com.nf.lc.exception.FailureException;
import com.nf.lc.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImp implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public int deleteByPrimaryKey(Integer addressId) {
        return addressMapper.deleteByPrimaryKey(addressId);
    }

    @Override
    public int insert(Address record) throws FailureException, EmptyException {
        if(record.getUserId() == null){
            throw new EmptyException("没有您的登入信息，请重新登入！");
        }
        int count = addressMapper.insert(record);
        if(count <= 0){
            throw new FailureException("发生意外，添加失败了！");
        }
        return count;
    }

    @Override
    public Address selectByPrimaryKey(Integer addressId) {
        return addressMapper.selectByPrimaryKey(addressId);
    }

    @Override
    public List<Address> selectAll(int uId) throws EmptyException {
        List<Address> addresses = addressMapper.selectAll(uId);
        if(addresses.size() == 0){
            throw new EmptyException("没有地址信息！");
        }
        return addresses;
    }

    @Override
    public int updateByPrimaryKey(Address record) {
        return addressMapper.updateByPrimaryKey(record);
    }


}
