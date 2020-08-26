package com.wen.cloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 21up on 2020/8/25
 */
@Configuration
@MapperScan({"com.wen.cloud.dao"})
public class MybatisConfig {
}
