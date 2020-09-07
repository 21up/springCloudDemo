package com.wen.mall.tiny.service.impl;

import com.github.pagehelper.PageHelper;
import com.wen.mall.tiny.mbg.mapper.PmsBrandMapper;
import com.wen.mall.tiny.mbg.model.PmsBrand;
import com.wen.mall.tiny.mbg.model.PmsBrandExample;
import com.wen.mall.tiny.service.PmsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 21up on 2020/9/7
 */
@Service
public class PmsBrandServiceImpl implements PmsBrandService{
    @Autowired
    private PmsBrandMapper pmsBrandMapper;
    @Override
    public List<PmsBrand> listAllBrand() {
        return pmsBrandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public int createBrand(PmsBrand brand) {
        return pmsBrandMapper.insertSelective(brand);
    }

    @Override
    public int updateBrand(Long id,PmsBrand pmsBrand) {
        return pmsBrandMapper.updateByPrimaryKeySelective(pmsBrand);
    }

    @Override
    public int deleteBrand(Long id) {
        return pmsBrandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<PmsBrand> listBrand(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return pmsBrandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public PmsBrand getBrand(Long id) {
        return pmsBrandMapper.selectByPrimaryKey(id);
    }
}
