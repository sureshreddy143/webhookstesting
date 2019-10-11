package com.example.multiModule.common.spring.postgres;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.multiModule.common.spring.configs.PackageConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
	basePackages = {"${packages.common.postgres.repository}"},
	entityManagerFactoryRef = "postgresEntityManagerFactory",
	transactionManagerRef = "postgresTransactionManager"
)
@EntityScan(basePackages = { "${packages.common.postgres.entity}" })
public class PostgresConfig {

	@Autowired
	PackageConfig packageConfig;

	@Bean
	@Primary
	@ConfigurationProperties("spring.datasource.postgres")
	public DataSourceProperties postgresDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean
	@Primary
	@ConfigurationProperties("spring.jpa.postgres")
	public JpaProperties postgresJpaProperties() {
		return new JpaProperties();
	}

	@Bean(name = "postgresDataSource")
	@ConfigurationProperties("spring.datasource.hikari")
	public HikariDataSource dataSource(DataSourceProperties properties) {
		return properties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
	}

	@Bean(name = "postgresEntityManagerFactory")
	@Primary
	public LocalContainerEntityManagerFactoryBean postgresEntityManagerFactory(
			final EntityManagerFactoryBuilder builder,
			@Qualifier("postgresDataSource") final DataSource dataSource) {
		return builder
				.dataSource(dataSource)
				.packages(packageConfig.getCommon().getPostgres().getEntity())
				.persistenceUnit("postgres")
				.properties(postgresJpaProperties().getProperties())
				.build();
	}

	@Bean(name = "postgresTransactionManager")
	@Primary
	public PlatformTransactionManager postgresTransactionManager(
			@Qualifier("postgresEntityManagerFactory") final EntityManagerFactory entityManagerFactory) {
		final JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}
}
