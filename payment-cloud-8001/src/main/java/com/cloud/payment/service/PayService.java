package com.cloud.payment.service;

import com.cloud.payment.entities.Pay;

import java.util.List;

/**
 * @Title: PayService
 * @Author David
 * @Package com.cloud.payment.service
 * @Date 2024/7/8 下午12:19
 * @description:
 */
public interface PayService {

    public int add(Pay pay);

    public int delete(Integer id);

    public int update(Pay pay);

    public Pay   getById(Integer id);

    public List<Pay> getAll();
}
