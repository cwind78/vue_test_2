package com.org.app;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//@SpringBootApplication
@ComponentScan
@Configuration
@EnableAutoConfiguration
@MapperScan(value = {"com.org.app.mapper"})
public class VueTestV2Application {

	public static void main(String[] args) {
		SpringApplication.run(VueTestV2Application.class, args);
	}
	
	@Bean
	public InternalResourceViewResolver setResolver() throws Exception {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/");
		resolver.setSuffix(".html");
		return resolver;
	}
	
	/**
     * SqlSessionFactory 설정
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource)throws Exception{
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
            sessionFactory.setDataSource(dataSource);
            Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml");
            
            sessionFactory.setMapperLocations(res);
            return sessionFactory.getObject();
    }
}
