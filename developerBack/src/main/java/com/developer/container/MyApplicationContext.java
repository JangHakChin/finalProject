package com.developer.container;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


@Configuration
public class MyApplicationContext {
	
	@Bean
	public HikariConfig hikariConfig() {
		HikariConfig config = new HikariConfig();
		config.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
		config.setJdbcUrl("jdbc:log4jdbc:oracle:thin:@tlaqerkcca7j08fz_high?TNS_ADMIN=/Users/moonone/Wallet_TLAQERKCCA7J08FZ");
		config.setUsername("admin");
		config.setPassword("Koo04071104@");
		config.setMinimumIdle(3);
		return config;	
	}
	
	@Bean
	public HikariDataSource dataSourceHikari() {
		return new HikariDataSource(hikariConfig());
	}
	
	@Bean
	public SqlSessionFactoryBean sqlSessionFactory() {
		SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
		ssfb.setDataSource(dataSourceHikari());
		Resource resource = new ClassPathResource("config.xml");
		ssfb.setConfigLocation(resource); //리소스를 요구해서 등록해서 넘겨줌
		return ssfb;
	}
}
