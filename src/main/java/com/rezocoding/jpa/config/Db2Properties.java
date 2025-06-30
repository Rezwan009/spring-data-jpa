package com.rezocoding.jpa.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app.db2")
@Getter
@Setter
public class Db2Properties {
    private String url;
    private String username;
    private String password;
}
