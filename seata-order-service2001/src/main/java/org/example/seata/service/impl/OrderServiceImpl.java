package org.example.seata.service.impl;

import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.example.seata.dao.OrderDao;
import org.example.seata.domain.Order;
import org.example.seata.service.AccountService;
import org.example.seata.service.OrderService;
import org.example.seata.service.StorageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author caopz
 * @Date 2020/8/30
 * @Description:
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    @Override
    @GlobalTransactional(name = "fsp-create-order", rollbackFor = Exception.class)
    public void create(Order order) {

        log.info("order:{}", order);

        log.info("======> 开始新建订单");
        orderDao.create(order);

        log.info("======> 调用库存服务 扣减库存开始");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("======> 调用库存服务 扣减库存结束");

        log.info("======> 调用账户服务 扣减余额开始");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("======> 调用账户服务 扣减余额结束");

        log.info("======> 修改订单状态 开始");
        orderDao.update(order.getUserId(), 0);
        log.info("======> 修改订单状态 结束");

        log.info("======> 新建订单结束");
    }

}
