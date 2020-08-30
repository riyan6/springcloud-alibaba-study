package org.example.seata.controller;

import org.example.seata.domain.CommonResult;
import org.example.seata.domain.Order;
import org.example.seata.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author caopz
 * @Date 2020/8/30
 * @Description:
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order) {
        orderService.create(order);
        return CommonResult.builder()
                .code(200)
                .message("订单创建成功")
                .build();
    }


}
