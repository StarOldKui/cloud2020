package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * 自己实现负载均衡
 */
public interface LoadBalance {

    /**
     * 得到instance对象
     *
     * @param instances
     * @return
     */
    ServiceInstance getInstance(List<ServiceInstance> instances);

}