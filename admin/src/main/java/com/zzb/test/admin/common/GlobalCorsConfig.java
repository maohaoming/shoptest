package com.zzb.test.admin.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 全局跨域配置类
 * Created by zzb on 2020/1/9 14:57
 */
@Configuration
public class GlobalCorsConfig {

    /**
     * 配置允许跨域内容
     * @return
     */
    @Bean
    public CorsConfiguration corsConfiguration(){
        return new CorsConfiguration(){
            {
                //允许所有域名进行跨域调用
                addAllowedOrigin("*");
                //允许跨域发送Cookie
                setAllowCredentials(true);
                //放行所有请求头
                addAllowedHeader("*");
                //允许所有请求方法跨域调用
                addAllowedMethod("*");
            }
        };
    }

    /**
     * 注册跨域内容的过滤器
     * @return
     */
    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(){
            {
                registerCorsConfiguration("/**", corsConfiguration());
            }
        };
        return new CorsFilter(source);
    }
}
