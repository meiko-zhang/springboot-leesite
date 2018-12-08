package com.meiko.leesite.demo.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @描述 mybatis-plus 配置类
 * @创建人 meiko-zhang
 * @创建时间 2018/12/8
 */
@Configuration
//@MapperScan("com.meiko.leesite.demo.mapper")
public class MybatisPlusConfig {
    /**
     * mybatis-plus 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor page = new PaginationInterceptor();
        page.setDialectType("mysql");
        return page;
    }

}
