package com.gworks.utils;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.io.InputStream;
import java.util.Properties;

@AllArgsConstructor
@NoArgsConstructor
public class AppProperties {

    private Properties properties = new Properties();

    @SneakyThrows
    public Properties getAppProperties() {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("application.properties");
        this.properties.load(inputStream);

        return this.properties;
    }
}
