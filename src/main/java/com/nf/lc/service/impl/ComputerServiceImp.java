package com.nf.lc.service.impl;

import com.github.pagehelper.PageHelper;
import com.nf.lc.dao.ComputerImageMapper;
import com.nf.lc.dao.ComputerMapper;
import com.nf.lc.entity.*;
import com.nf.lc.exception.EmptyException;
import com.nf.lc.exception.FailureException;
import com.nf.lc.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComputerServiceImp implements ComputerService {

    @Autowired
    private ComputerMapper computerMapper;

    @Autowired
    private ComputerImageMapper computerImageMapper;

    @Override
    public int deleteByPrimaryKey(Integer computerId) {
        return computerMapper.deleteByPrimaryKey(computerId);
    }

    @Override
    public int insert(InsertComputerParam record) throws FailureException {
        int count = computerMapper.insert(record);
        if(count > 0){  //添加商品成功
            //添加图片
            List<ComputerImage> computerImageList = record.getComputerImageList();
            for (ComputerImage computerImage : computerImageList) {
                computerImage.setComputerId(record.getComputerId());
                computerImageMapper.insert(computerImage);
            }
            return 1;
        } else{
          throw new FailureException("添加失败了！请重试！");
        }
    }

    @Override
    public List<Computer> selectAllByComputerState(int page ,int computerState) throws EmptyException {
        PageHelper.startPage(page,10); //分页
        List<Computer> computers = computerMapper.selectAllByComputerState(computerState);
        if(computers.size() > 0){
            return computers;
        }
        throw new EmptyException("没有查询到数据哦！");
    }

    @Override
    public int selectAllByComputerStateCount(int computerState) {
        return computerMapper.selectAllByComputerStateCount(computerState);
    }

    @Override
    public Computer selectByPrimaryKey(Integer computerId) throws EmptyException {
        Computer computer = computerMapper.selectByPrimaryKey(computerId);
        if(computer == null){
            throw new EmptyException("数据获取失败！");
        }
        return computer;
    }


    @Override
    public int updateByPrimaryKey(UpdateComputerParam record) throws FailureException {
        List<Integer> updErrors = new ArrayList<>(); //修改失败错误集合
        List<Integer> addErrors = new ArrayList<>(); //添加失败错误集合
        List<Integer> delErrors = new ArrayList<>(); //删除失败错误集合
        //修改除了图片外的信息
        if(computerMapper.updateByPrimaryKey(record) == 0){
            //信息修改失败了
            throw new FailureException("修改失败了！请重试！");
        }

        //客户端传过来的图片集合
        List<ComputerImage> updateImages = record.getComputerImageList();

        //获得数据库中该商品的图片集合
        List<ComputerImage> computerImages = computerImageMapper.selectByPrimaryKey(record.getComputerId());

        for (int i = 0; i < (updateImages.size() > computerImages.size() ? updateImages.size() : computerImages.size()); i++) { //循环要写入数据库的数据
            if(i < computerImages.size() && i < updateImages.size()) {  //同时存在，进行修改操作
                ComputerImage computerImage = computerImages.get(i);  //获得数据库集合的当前数据
                //路径替换，也就是图片地址修改
                computerImage.setComputerImageUrl(updateImages.get(i).getComputerImageUrl());
                if(computerImageMapper.updateByPrimaryKey(computerImage) == 0 ) {  //修改信息失败
                    updErrors.add(i);  //添加到修改失败集合
                }
            } else if(i < computerImages.size()){  //数据库存在，客户端删除了，进行删除操作
                ComputerImage computerImage = computerImages.get(i);  //获得数据库集合的当前数据
                if(computerImageMapper.deleteByPrimaryKey(computerImage.getComputerImageId()) == 0){
                    delErrors.add(i); //添加到删除失败集合
                }
            } else {  //数据库不存在，客户端增加，执行数据库添加操作
                //取出要添加的对象
                ComputerImage addComputerImages = updateImages.get(i);
                //写入商品id
                addComputerImages.setComputerId(record.getComputerId());
                if(computerImageMapper.insert(addComputerImages) ==0){
                    addErrors.add(i); //添加到添加失败集合
                }
            }
        }

        StringBuffer message = new StringBuffer("信息如下：");
        if(updErrors.size() > 0){
            String link = "";
            message.append("修改失败图片第：");
            for (Integer updError : updErrors) {
                message.append(updError + link);
                link = ",";
            }
        }

        if(delErrors.size() > 0){
            String link = "";
            message.append("删除失败的图片第：");
            for (Integer delError : delErrors) {
                message.append(delError + link);
                link = ",";
            }
        }

        if(addErrors.size() > 0){
            String link = "";
            message.append("添加失败的图片第：");
            for (Integer addError : addErrors) {
                message.append(addError + link);
                link = ",";
            }
        }

        if(addErrors.size() >0 | updErrors.size() > 0 |delErrors.size() >0){
            throw new FailureException(message.toString());  //有错误返回
        }

        return 1;
    }

    @Override
    public int selectCount(QueryDataParameter queryDataParameter) {
        return computerMapper.selectCount(queryDataParameter);
    }

    @Override
    public List<Computer> selectLikeDescribe(SelectLikePrams selectLikePrams) throws EmptyException {
        selectLikePrams.setPage((selectLikePrams.getPage() - 1) * selectLikePrams.getCount());
        List<Computer> computers = computerMapper.selectLikeDescribe(selectLikePrams);
        if (computers == null || computers.size() == 0) {
            throw new EmptyException("没有数据！");
        }
        return computers;
    }

    @Override
    public int selectLikeDescribeCount(SelectLikePrams selectLikePrams) {
        selectLikePrams.setPage((selectLikePrams.getPage() - 1) * selectLikePrams.getCount());
        return computerMapper.selectLikeDescribeCount(selectLikePrams);
    }


    @Override
    public List<Computer> selectAll(QueryDataParameter queryDataParameter) throws EmptyException {
        queryDataParameter.setPage((queryDataParameter.getPage() - 1) * queryDataParameter.getCount());
        List<Computer> computers = computerMapper.selectAll(queryDataParameter);
        if (computers.size() == 0 || computers == null) {
            throw new EmptyException("没有数据！");
        }
        return computers;
    }

}
