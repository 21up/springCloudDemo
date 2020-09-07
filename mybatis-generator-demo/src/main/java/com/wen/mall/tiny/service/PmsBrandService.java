package com.wen.mall.tiny.service;

import com.wen.mall.tiny.mbg.model.PmsBrand;

import java.util.List;

public interface PmsBrandService {
    List<PmsBrand> listAllBrand();
    int createBrand(PmsBrand brand);
    int updateBrand(Long id,PmsBrand pmsBrand);
    int deleteBrand(Long id);
    List<PmsBrand> listBrand(int pageNum,int pageSize);
    PmsBrand getBrand(Long id);
}
