package com.gworks.ui.services;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxWebDriverService implements IFireFoxWebDriverService{

    private WebDriver webDriver;

    @Override
    public void setFireFoxWebDriver() {
        WebDriverManager.firefoxdriver().setup();
        this.webDriver = new FirefoxDriver();
    }

    @Override
    public WebDriver openUrlOnFirefox(String url) {
        setFireFoxWebDriver();
        this.webDriver.get(url);

        return this.webDriver;
    }
}
