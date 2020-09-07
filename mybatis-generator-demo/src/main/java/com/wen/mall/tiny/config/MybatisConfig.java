package com.wen.mall.tiny.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 21up on 2020/9/7
 */
@Configuration
@MapperScan("com.wen.mall.tiny.mbg.mapper")
public class MybatisConfig {
}
