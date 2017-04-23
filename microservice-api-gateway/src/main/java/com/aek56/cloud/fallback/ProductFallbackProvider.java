package com.aek56.cloud.fallback;

import com.aek56.cloud.utils.ReturnInfoEnum;
import com.aek56.cloud.vbean.ResultInfo;
import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 商品微服务短路器返回调用
 * Created by aek56 on 2017/3/14.
 */
@Component
public class ProductFallbackProvider implements ZuulFallbackProvider {
    @Override
    public String getRoute() {
        return "microservice-consumer-productservice";
    }

    @Override
    public ClientHttpResponse fallbackResponse() {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return 200;
            }

            @Override
            public String getStatusText() throws IOException {
                return "OK";
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                ResultInfo resultInfo = new ResultInfo<>(ReturnInfoEnum.ERROR_SERVICE.getState(),
                        ReturnInfoEnum.ERROR_SERVICE.getStateInfo()+";服务名为："+ProductFallbackProvider.this.getRoute());
                return new ByteArrayInputStream(resultInfo.toString().getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }
        };
    }
}
