package com.edu.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MybatisPlus配置
 *
 * @author ham
 */
@Configuration
@MapperScan("com.edu.mapper")
@EnableTransactionManagement
public class MybatisPlusConfig {

    /**
     * 分页插件配置
     *
     * @return PaginationInterceptor对象
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
