package com.mageddo.config;

import com.zaxxer.hikari.HikariDataSource;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.EachBean;
import io.micronaut.context.annotation.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.inject.Singleton;
import javax.sql.DataSource;

@Factory
public class JdbcTemplateFactory {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Bean
	@Singleton
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean
	@Singleton
	public NamedParameterJdbcTemplate namedJdbcTemplate(DataSource dataSource) {
		logger.info("datasource={}", dataSource);
		return new NamedParameterJdbcTemplate(dataSource);
	}

	@Bean
	@Singleton
	public DataSourceTransactionManager DataSourceTransactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@EachBean(DatasourceConfiguration.class)
	public DataSource dataSource(DatasourceConfiguration config){
		final HikariDataSource dc = new HikariDataSource();
		dc.setDriverClassName(config.getDriverClassName());
		dc.setMinimumIdle(config.getMinimumIdle());
		dc.setMaximumPoolSize(config.getMaximumPoolSize());
//		dc.setTransactionIsolation();
//		dc.setAutoCommit();
		dc.setConnectionTestQuery(config.getConnectionTestQuery());
//		dc.setHealthCheckRegistry();
//		dc.setLoginTimeout();
//		dc.setConnectionTimeout();
		dc.setInitializationFailTimeout(config.getInitializationFailTimeout());
		dc.setJdbcUrl(config.getJdbcUrl());
//		dc.setConnectionInitSql();
//		dc.setIdleTimeout();
		dc.setPassword(config.getPassword());
		dc.setUsername(config.getUsername());
//		dc.setSchema();
		return dc;
	}
}
