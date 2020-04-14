package com.example.sharding.shardingdemo;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication(exclude={DruidDataSourceAutoConfigure.class})
@ComponentScan(basePackages ="com.example")
@MapperScan(basePackages = "com.example.sharding.shardingdemo.dao")
public class ShardingdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingdemoApplication.class, args);
    }

}
