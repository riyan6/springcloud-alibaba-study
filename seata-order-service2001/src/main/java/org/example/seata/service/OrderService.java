package org.example.seata.service;

import org.example.seata.domain.Order;

/**
 * @Author caopz
 * @Date 2020/8/30
 * @Description:
 */
public interface OrderService {

    void create(Order order);

}
