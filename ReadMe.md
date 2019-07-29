# 项目描述
本项目是一个企业级练手项目，会从springboot基本知识入手，在介绍的过程中我会尽量的把springboot以及springSecurity的核心思想
及其原理，尽量表达清楚，使初学者能够得心应手的使用springboot和springSecurity框架。
# 项目结构介绍
employ-mybatis 是mybaties实体类和mapper接口。是关于员工表
permission-mybatis 是mybaties实体类和mapper接口。权限相关。
restful-api 是一个restful-api的项目
security-sql sql存放目录
spring-security-app security的app端
spring-security-browser springsecurity的浏览器相关类
spring-security-core 我封装springsecurity相关实现
spring-securtiy-demo 浏览器相关的demo项目最终会实现一个后台管理系统，基于springboot
springsecurity thymeleaf,aceUI实现。
# restful-api项目准备
1.创建数据库表Employ员工表
2.创建工程项目security-demo项目
3.生成employ-mybaties实体类。我这边采用的是**MybatiesGenerator**
maven插件生成的。
4.创建restful-api模块。

# springboot基本使用
- 引入依赖
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```
- 简单的web程序
```java
@SpringBootApplication
public class SecurtiyApplication {
    public static void main(String[] args) {
        SpringApplication.run(SecurtiyApplication.class, args);
    }
}
```
```java
@RestController
public class EmployController {
    @RequestMapping("word")
    public String HelloWord(String name,Integer id) {
        return "Hello Word";
    }
}
```
配置文件
```yaml
server:
  port: 8085
```
- 启动访问 localhost:8085/word 返回Helloword
> 思考：
1.为什么简简单单的几行代码就能实现一个web程序？
2.SpringMVC框架以前需要部署到tomcat容器里，springboot为何不需要部署?
3.SpringMVC以往需要配置web.xml,配置DispachSevlet，以及一堆的过滤器，为何
Springboot不需要配置？
4.SpringBoot和SpringMVC比优势在哪些地方可以体现？

# Springboot 基本知识
