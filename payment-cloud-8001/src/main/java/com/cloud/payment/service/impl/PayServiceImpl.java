package com.cloud.payment.service.impl;

import com.cloud.payment.entities.Pay;
import com.cloud.payment.mapper.PayMapper;
import com.cloud.payment.service.PayService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Title: PayServiceImpl
 * @Author David
 * @Package com.cloud.payment.service.impl
 * @Date 2024/7/8 下午12:21
 * @description: 实现PayService接口
 */
@Service
public class PayServiceImpl implements PayService {

    @Resource
    private PayMapper payMapper;

    @Override
    public int add(Pay pay) {
        return payMapper.insertSelective(pay);
    }

    @Override
    public int delete(Integer id) {
        return payMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Pay pay) {
        return payMapper.updateByPrimaryKeySelective(pay);
    }

    @Override
    public Pay getById(Integer id) {
        return payMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Pay> getAll() {
        return payMapper.selectAll();
    }
}
