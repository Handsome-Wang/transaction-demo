package com.example.transaction.service.impl;

import com.example.transaction.mapper.TransactionMapper;
import com.example.transaction.service.MoneyService;
import com.example.transaction.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @program: transaction-demo
 * @description:
 * @author: wangshuai
 * @create: 2022-04-08 11:22
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private TransactionMapper transactionMapper;

    @Autowired
    private MoneyService moneyService;

    /**
     * 扣钱
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createOrder() {

        // 创建订单
        transactionMapper.createOrder(UUID.randomUUID().toString());
        System.out.println("===================生成订单成功");

        // 扣钱
        moneyService.decryMoney();
        System.out.println("===================用户扣钱成功");

    }


}
