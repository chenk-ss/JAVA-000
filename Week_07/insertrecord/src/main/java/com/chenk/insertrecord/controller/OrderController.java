package com.chenk.insertrecord.controller;

import com.chenk.insertrecord.pojo.Order;
import com.chenk.insertrecord.repo.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.sql.*;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author chenk
 * @create 2020/12/2 12:49
 */
@RequestMapping("/order")
@RestController
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/add")
    String addOrder() throws InterruptedException {
        final String user_id = UUID.randomUUID().toString();
        final String seller_id = UUID.randomUUID().toString();
        final String goods_snapshot_id = UUID.randomUUID().toString();
        final String address_id = UUID.randomUUID().toString();
        final int num = 1;
        final BigDecimal price_total = new BigDecimal(1.1);
        final String pay_type = "支付宝";
        final BigDecimal pay_price = new BigDecimal(1.1);
        final String pay_url = "zhifubao_001";

        ExecutorService pool = Executors.newFixedThreadPool(50);

        // 22.3min
        int size = 1000000;
        CountDownLatch threadsSingal = new CountDownLatch(size);
        for (int i = 0; i < size; i++) {
            pool.execute(new Thread() {
                @Override
                public void run() {
                    Order order = new Order();
                    order.setId(UUID.randomUUID().toString());
                    order.setUserId(user_id);
                    order.setSellerId(seller_id);
                    order.setGoodsSnapshotId(goods_snapshot_id);
                    order.setAddressId(address_id);
                    order.setNum(num);
                    order.setPriceTotal(price_total);
                    order.setPayType(pay_type);
                    order.setPayPrice(pay_price);
                    order.setPayUrl(pay_url);
                    order.setCreateTime(new Date());
                    order.setUpdateTime(new Date());
                    orderRepository.save(order);
                    threadsSingal.countDown();
                }
            });

        }
        threadsSingal.await();
        return "success";
    }
}
