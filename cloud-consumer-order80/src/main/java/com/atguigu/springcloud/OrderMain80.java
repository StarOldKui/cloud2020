package com.atguigu.springcloud;

import com.atguigu.myrule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * 负载均衡的算法：rest接口第几次请求数 % 服务器集群总数量 = 实际调用服务器位置下标，
 * 每次服务重启后rest接口计数从1开始
 *
 * @auther zzyy
 * @create 2020-02-18 17:20
 */
@EnableEurekaClient
@SpringBootApplication
// 开启自定义providers访问规则
//@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration= MyRule.class)
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }
}
