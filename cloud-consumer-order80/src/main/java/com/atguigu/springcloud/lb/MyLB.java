package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLB implements LoadBalance {
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    // final不给修改
    public final int getAndIncrement() {
        int current;
        int next; // 第几次访问
        do {
            current = this.atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        } while (!this.atomicInteger.compareAndSet(current, next)); // 自旋
        return next;
    }

    @Override
    public ServiceInstance getInstance(List<ServiceInstance> instances) {
        int i = getAndIncrement() % instances.size();
        return instances.get(i);
    }
}