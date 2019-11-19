package com.zzb.test.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger-UI的配置类
 * Created by zzb on 2019/11/18 18:14
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createApi(){
        return new Docket(DocumentationType.SPRING_WEB)
                //文档head主体
                .apiInfo(this.apiInfo())
                //生成Controller的api文档
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zzb.test.admin.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Swagger-UI演示")
                .description("shop-test")
                .version("1.0.0")
                .build();
    }
}
