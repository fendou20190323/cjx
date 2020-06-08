package com.fendou.moudle.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class Swagger2 {
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("零时尚平台--用户系统webapi接口")
                .description("本接口为restful风格")
                .version("1.0")
                .build();
    }




}
