package com.zzb.test.admin.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zzb on 2019/11/15 9:36
 */
@Configuration
@MapperScan(basePackages = {"com.zzb.test.admin.mbg.mapper","com.zzb.test.admin.dao"})
public class MybatisConfig {
}
