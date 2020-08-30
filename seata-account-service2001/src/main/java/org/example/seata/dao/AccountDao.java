package org.example.seata.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @Author caopz
 * @Date 2020/8/30
 * @Description:
 */
@Mapper
public interface AccountDao {

    /**
     * 扣减余额
     *
     * @param userId
     * @param money
     */
    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);


}
