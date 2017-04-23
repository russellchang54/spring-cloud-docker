package com.aek56.cloud.service;



import com.aek56.cloud.service.impl.UserServiceFeignFallback;
import com.aek56.feignconfig.FeignConfig;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by aek56 on 2017/3/6.
 */
// name为服务名，对应spring.application.name。注意：此服务名必须已注册进Eureka服务中心
@FeignClient(name = "microservice-provider-userservice",fallback = UserServiceFeignFallback.class, configuration = FeignConfig.class)
public interface UserServiceFeign extends IUserService{

}
