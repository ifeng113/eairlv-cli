# eairlv-cli
基于spring  boot快速开发的脚手架


## 功能：

mybatis-plus

swagger2

log4j2

lombok

mysql



## 环境：

java 8 

gradle 4.4+(spring boot 2.1.1.RELEASE要求)

idea 2018.1

spring boot 2.1.1.RELEASE

spring cloud Finchley.SR2

###idea2018.1与gradle 5.0不兼容

java 11 

gradle 5.X

idea 2018.3

spring boot 2.1.x（spring boot 2.0.x 实际引入的spring-boot-starter为2.1.0）

spring cloud Greenwich



## 依赖包:

spring-boot-starter-web

spring-boot-starter-test(testCompile)



mysql-connector-java

druid

mybatis-plus-boot-starter



swagger2（extends WebMvcConfigurationSupport改为implements WebMvcConfigurer）

log4j2（异步日志的两种配置方式）

lombok(compileOnly)

#引入本地包compile fileTree(dir:'libs',include:['*.jar'])
