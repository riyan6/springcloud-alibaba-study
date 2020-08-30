package org.example.seata.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.seata.dao.AccountDao;
import org.example.seata.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @Author caopz
 * @Date 2020/8/30
 * @Description:
 */
@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("======> 账号服务 扣减余额开始");
        accountDao.decrease(userId, money);
        log.info("======> 账号服务 扣减余额结束");
    }

}
