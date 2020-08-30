package org.example.seata.service;

/**
 * @Author caopz
 * @Date 2020/8/30
 * @Description:
 */
public interface StorageService {

    /**
     * 扣减库存
     *
     * @param productId
     * @param count
     */
    void decrease(Long productId, Integer count);

}
