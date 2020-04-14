/**
 * Project Name:youyuer-framework-proj
 * Package Name:com.youyuer.framework.common.component.RWDataSource
 * Date:2018/10/30下午6:26
 * Copyright (c) 2018, www.youyuer.com All Rights Reserved
 */
package com.example.sharding.shardingdemo.config;

import org.apache.shardingsphere.api.hint.HintManager;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import lombok.extern.slf4j.Slf4j;


@Configuration
@Aspect
@Slf4j
public class DynamicAspect {

    /**
     * Description: 强制切换主库</br>
     * Date: 2020/4/14</br>
     *
     * @param
     * @return
     * @author huangcaijian
     * @since JDK 1.8
    */
    @Around("@annotation(ShardingMasterConnection)")
    public Object setReadOnly(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        HintManager hintManager =null;
        try {
            log.info("dataSource切换到：主库");
            hintManager = HintManager.getInstance() ;
            hintManager.setMasterRouteOnly();
            Object result = proceedingJoinPoint.proceed();
            return result;
        } finally {
            if(hintManager != null){
                hintManager.close();
            }
        }
    }
}
