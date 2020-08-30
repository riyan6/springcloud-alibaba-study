package org.example.seata.service;

import java.math.BigDecimal;

/**
 * @Author caopz
 * @Date 2020/8/30
 * @Description:
 */
public interface AccountService {

    void decrease(Long userId, BigDecimal money);

}
