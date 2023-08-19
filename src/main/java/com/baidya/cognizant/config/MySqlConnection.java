package com.baidya.cognizant.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix = "spring.db")
@Getter@Setter
public class MySqlConnection {
    private String url;
    private String username;
    private String password;
    private String driver;
}
