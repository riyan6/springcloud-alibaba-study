package org.example.seata.controller;

import org.apache.ibatis.annotations.Param;
import org.example.seata.domain.CommonResult;
import org.example.seata.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @Author caopz
 * @Date 2020/8/30
 * @Description:
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/decrease")
    public CommonResult decrease(@Param("userId") Long userId, @Param("money") BigDecimal money) {
        accountService.decrease(userId, money);
        return CommonResult.builder().code(200).message("扣减余额成功！").build();
    }

}
