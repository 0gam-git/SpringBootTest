package com.urong.boot.config;

import java.util.Properties;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@MapperScan(basePackages = {"com.urong.boot.persistence"})
public class DefalutDatabaseConfig {


	@Bean
	public DataSource getDataSource() {
		DataSource dataSource = new DataSource();
		
		dataSource.setDriverClassName("org.apache.derby.jdbc.ClientDriver");
		dataSource.setUrl("jdbc:derby://localhost:1527/SpringBootTestExample;create=true");
		dataSource.setUsername("app");
		dataSource.setPassword("1234");
		
		return dataSource;
	}
	
	@Bean
	public SqlSessionFactory getFactoryBean() throws Exception{
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		
		factoryBean.setDataSource(getDataSource());
		factoryBean.setConfigurationProperties(mybatisProperties());
		
		return factoryBean.getObject();
	}
	
	 private Properties mybatisProperties() {
	        Properties properties = new Properties();
	        properties.put("lazyLoadingEnabled", "true");

	        return properties;
	    }
	
	@Bean
	public DataSourceTransactionManager getTransactionManager() {
		DataSourceTransactionManager manager = new DataSourceTransactionManager();
		
		manager.setDataSource(getDataSource());
		
		
		return manager;
	}

	@Bean
	public SqlSessionTemplate getSqlSessionTemplate() throws Exception {
		SqlSessionTemplate template = new SqlSessionTemplate(getFactoryBean());
		
		return template;
	}
	
}
