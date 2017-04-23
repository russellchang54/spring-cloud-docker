package com.aek56.cloud.service.impl;

import com.aek56.cloud.service.UserServiceFeign;
import com.aek56.cloud.utils.ReturnInfoEnum;
import com.aek56.cloud.vbean.ResultInfo;
import org.springframework.stereotype.Component;

/**
 * 定义各接口对应的fallback方法
 * Created by aek56 on 2017/3/6.
 */
@Component
public class UserServiceFeignFallback implements UserServiceFeign {

    @Override
    public ResultInfo getUserById(Long id) throws Exception {
        return new ResultInfo<>(ReturnInfoEnum.NULL.getState(), ReturnInfoEnum.NULL.getStateInfo());
    }

}
