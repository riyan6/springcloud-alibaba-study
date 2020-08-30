package org.example.seata;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author caopz
 * @Date 2020/8/30
 * @Description:
 */
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan({"org.example.seata.dao"})
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SeataAccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeataAccountApplication.class, args);
    }

}
