package com.example.transaction.service.impl;

import com.example.transaction.mapper.TransactionMapper;
import com.example.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.UUID;

/**
 * @program: transaction-demo
 * @description:
 * @author: wangshuai
 * @create: 2022-04-08 11:22
 **/
@Service
public class TransactionImpl implements TransactionService {

    @Autowired
    private TransactionMapper transactionMapper;

    @Autowired
    private TransactionService transactionService;

    /**
     *
     */
    @Override
    @Transactional(rollbackFor = ArithmeticException.class,propagation = Propagation.REQUIRED)
    public void testTransaction() {
        transactionMapper.decryMoney();
        System.out.println("===================用户扣钱成功");

        // 手动添加一个异常
        try {
            int a = 1 / 0;

        } catch (Exception e){
            throw new NullPointerException();
        }




        transactionMapper.createOrder(UUID.randomUUID().toString());
        System.out.println("===================生成订单成功");

    }




    /**
     * 扣钱
     */
    @Override
    @Transactional(rollbackFor = IOException.class, propagation = Propagation.REQUIRED)
    public void decryMoney() {
        // 扣钱
        transactionMapper.decryMoney();
        // 创建订单
        transactionService.createOrder();
        this.createOrder1();

        //String a = null;
        //a.toString();
    }


    @Transactional(propagation = Propagation.REQUIRED)
    public void createOrder1() {

        transactionMapper.createOrder(UUID.randomUUID().toString());

        transactionMapper.createOrder(UUID.randomUUID().toString());
        // 手动异常
        int a = 1 / 0;


        System.out.println("===================生成订单成功");
    }

    /**
     * 创建订单
     */
    @Override
    @Transactional(propagation = Propagation.NESTED)
    public void createOrder() {

        transactionMapper.createOrder(UUID.randomUUID().toString());

        transactionMapper.createOrder(UUID.randomUUID().toString());
        // 手动异常
        //int a = 1 / 0;


        System.out.println("===================生成订单成功");
    }


    //public void example() {
    //    TransactionManager tm = null;
    //    try {
    //        //获得一个JTA事务管理器
    //        tm = getTransactionManager();
    //        tm.begin();//开启一个新的事务
    //        Transaction ts1 = tm.getTransaction();
    //        doSomeThing();
    //        tm.suspend();//挂起当前事务
    //        try {
    //            tm.begin();//重新开启第二个事务
    //            Transaction ts2 = tm.getTransaction();
    //            methodB();
    //            ts2.commit();//提交第二个事务
    //        } Catch(RunTimeException ex) {
    //            ts2.rollback();//回滚第二个事务
    //        } finally{
    //            //释放资源
    //        }
    //        //methodB执行完后，恢复第一个事务
    //        tm.resume(ts1);
    //        doSomeThingB();
    //        ts1.commit();//提交第一个事务
    //    } catch (
    //            RunTimeException ex) {
    //        ts1.rollback();//回滚第一个事务
    //    } finally {
    //        //释放资源
    //    }
    //}


}
