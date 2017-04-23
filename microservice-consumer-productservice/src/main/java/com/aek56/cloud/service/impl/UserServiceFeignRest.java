package com.aek56.cloud.service.impl;

import com.aek56.cloud.bean.UserBean;
import com.aek56.cloud.vbean.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * 定义通过rest方式访问接口
 * Created by aek56 on 2017/3/6.
 */
@Component
public class UserServiceFeignRest {

    @Autowired
    private RestTemplate restTemplate;

    public ResultInfo<UserBean> getUser(Long id) {
        ResultInfo<UserBean> resultInfo  = restTemplate.exchange("http://microservice-provider-userservice/users/{id}", HttpMethod.GET, null, new ParameterizedTypeReference<ResultInfo<UserBean>>() {
        }, id).getBody();
        return resultInfo;
    }
}
