package com.eairlv.cli.config;

import com.google.common.base.Predicate;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Predicates.and;
import static springfox.documentation.builders.PathSelectors.ant;

/**
 * @author lv
 * @create 2018-04-27 18:51
 * @desc Swagger 配置
 **/

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createDocket(){
        Predicate<String> path = and(ant("/cli/**"));
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("eairlv-cli")
                .useDefaultResponseMessages(false)
                .forCodeGeneration(false)
                .apiInfo(innerInfo())
                .select()
                .paths(path)
                .build()
                .globalOperationParameters(globalOperationParameters());
    }

    public List<Parameter> globalOperationParameters() {
        List<Parameter> pars = new ArrayList<>();
        ParameterBuilder tokenPar = new ParameterBuilder();
        tokenPar.name("Authorization")
                .description("JWT 令牌")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false).build();
        pars.add(tokenPar.build());
        return pars;
    }

    /**
     * 接口描述
     */
    private ApiInfo innerInfo(){
        return apiInfo("eairlv-cli", "eairlv-cli 脚手架工具swagger2接口文档");
    }


    private ApiInfo apiInfo(String title, String des){
        return new ApiInfoBuilder()
                .title(title)
                .description(des)
                .termsOfServiceUrl("http://springfox.io")
                .license("Apache License Version 1.0")
                .licenseUrl("https://github.com/springfox/springfox/blob/master/LICENSE")
                .version("1.0")
                .build();
    }
}
