package com.baidya.cognizant.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DBConfiguration {

    @Bean
    public DataSource dataSource(MySqlConnection mySqlConnection){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(mySqlConnection.getDriver());
        driverManagerDataSource.setUrl(mySqlConnection.getUrl());
        driverManagerDataSource.setUsername(mySqlConnection.getUsername());
        driverManagerDataSource.setPassword(mySqlConnection.getPassword());
        return  driverManagerDataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
