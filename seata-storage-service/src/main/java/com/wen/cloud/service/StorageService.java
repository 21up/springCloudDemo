package com.wen.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;


public interface StorageService {
    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);
}
