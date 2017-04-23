package com.aek56.cloud.service;


import com.aek56.cloud.bean.ProductBean;

/**
 * Created by aek56 on 2017/2/27.
 * 用户业务逻辑处理层
 */
public interface IProductService {


    /**
     * 根据商品ID获取商品信息
     * @param commodityId
     * @return
     */
     public ProductBean getCommodityById(Long commodityId) throws Exception;
}
