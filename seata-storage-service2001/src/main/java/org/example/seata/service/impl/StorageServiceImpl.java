package org.example.seata.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.seata.dao.StorageDao;
import org.example.seata.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author caopz
 * @Date 2020/8/30
 * @Description:
 */
@Slf4j
@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("======> 库存服务 扣减库存开始");
        storageDao.decrease(productId, count);
        log.info("======> 库存服务 扣减库存结束");
    }
}
