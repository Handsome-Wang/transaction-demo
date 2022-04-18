package com.example.transaction.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * @program: transaction-demo
 * @description:
 * @author: wangshuai
 * @create: 2022-04-08 11:25
 **/
public interface TransactionMapper {


    boolean createOrder(@Param("orderNumber") String orderNumber);

    boolean decryMoney();
}
