package com.example.transaction.controller;

import com.example.transaction.service.OrderService;
import com.example.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: transaction-demo
 * @description:
 * @author: wangshuai
 * @create: 2022-04-08 11:36
 **/
@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/createOrder")
    public String createOrder() {
        try {
            transactionService. testTransaction();

        } catch (Exception e) {
            return "下单失败" + e;

        }
        return "下单成功";
    }


    @GetMapping("/testPropagation")
    public String testPropagation() {
        transactionService.decryMoney();


        return "下单成功";
    }

    @GetMapping("/testCreateOrder")
    public String testCreateOrder() {
        try {
            transactionService.createOrder();

        } catch (Exception e) {
            return "下单失败" + e;

        }
        return "下单成功";
    }
}
