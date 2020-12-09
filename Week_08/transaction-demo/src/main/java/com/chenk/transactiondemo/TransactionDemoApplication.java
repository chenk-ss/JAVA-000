package com.chenk.transactiondemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import javax.annotation.PostConstruct;

@SpringBootApplication
@Import(TransactionConfiguration.class)
public class TransactionDemoApplication {

    @Autowired
    private XAOrderService orderService;

    public static void main(final String[] args) {
        SpringApplication.run(TransactionDemoApplication.class, args);
    }

    @PostConstruct
    public void executeOrderService() {
//        orderService.init();
//        orderService.cleanup();

        System.out.println(orderService.selectAll());
        try {
            orderService.insertFailed(10);
        } catch (final Exception ignore) {
        }
        System.out.println(orderService.selectAll());
        orderService.insert(10);
        System.out.println(orderService.selectAll());
    }
}
