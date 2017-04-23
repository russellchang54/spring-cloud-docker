package com.aek56.cloud.service;

import com.aek56.cloud.vbean.ResultInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by aek56 on 2017/3/19.
 */
@FeignClient(name = "microservice-sidecar-comment")
public interface CommentServiceFeign {
    @RequestMapping(value = "/comment", method = RequestMethod.GET)
    ResultInfo getComment() throws Exception;
}
