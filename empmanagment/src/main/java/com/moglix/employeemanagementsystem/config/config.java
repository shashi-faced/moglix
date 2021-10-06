package com.moglix.employeemanagementsystem.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@ComponentScan("com.moglix.employeemanagementsystem")
@Configuration//  Yaha pe Configuration Details dene ka hai..
@PropertySource("classpath:application.properties")
public class config {

	@Autowired
	Environment environment;
	
	@Bean
	public DataSource getMySQLDataSource() {
		// do we need some one who will help us to read the properties from file.
		
		
		BasicDataSource dataSource  = new BasicDataSource();
		dataSource.setDriverClassName(environment.getProperty("db.classname"));
		dataSource.setUsername(environment.getProperty("db.username"));
		dataSource.setPassword(environment.getProperty("db.password"));
		dataSource.setUrl(environment.getProperty("db.url"));
	    return dataSource;
	}
}
