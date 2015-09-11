package com.bst;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by rekhamittal on 8/24/15.
 */
@Configuration
@PropertySource(value={"classpath:application.properties"})
public class DatabaseConfig {

    @Value("${db.url}")
    private String DB_URL;

    @Value("${db.driver}")
    private String DB_DRIVER;

    @Value("${db.password}")
    private String DB_PASSWORD;

    @Value("${db.username}")
    private String DB_USERNAME;


//    @Value("${entitymanager.packagesToScan}")
//    private String ENTITYMANAGER_PACKAGES_TO_SCAN;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(DB_DRIVER);
        dataSource.setUrl(DB_URL);
        dataSource.setUsername(DB_USERNAME);
        dataSource.setPassword(DB_PASSWORD);
        return dataSource;
    }


    @Bean
    public JdbcTemplate jdbcTemplate()
    {
        return new JdbcTemplate(dataSource());
    }


}
