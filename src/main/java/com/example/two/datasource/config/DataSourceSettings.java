package com.example.two.datasource.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DataSourceSettings {
	
	//config postgres
	@Bean(name = "ds-postgres")
	@ConfigurationProperties(prefix = "ds.postgres.datasource")
	public DataSource dataSourcePostgres() {
		DataSource datasource = DataSourceBuilder.create().build();
		return datasource;
	}
	
	@Bean(name = "jdbcTemplatePostgres")
	public JdbcTemplate getJdbcTemplatePostgres(@Qualifier("ds-postgres") DataSource ds) {
		return new JdbcTemplate(ds);
	}
		
	
	
	//config mysql
	@Bean(name = "ds-mysql")
	@ConfigurationProperties(prefix = "ds.mysql.datasource")
	public DataSource dataSourceMySQL() {
		DataSource datasource = DataSourceBuilder.create().build();
		return datasource;
	}

	@Bean(name = "jdbcTemplateMysql")
	public JdbcTemplate getJdbcTemplateMysql(@Qualifier("ds-mysql") DataSource ds) {
		return new JdbcTemplate(ds);
	}
	

}
