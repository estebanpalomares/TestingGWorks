package com.gworks.ui.services;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class SafariWebDriverService implements ISafariWebDriverService{

    private WebDriver webDriver;

    @Override
    public void setSafariWebDriver() {
        WebDriverManager.safaridriver().setup();
        SafariOptions options = new SafariOptions();
        options.setBrowserVersion("5.1.7");
        this.webDriver = new SafariDriver(options);
    }

    @Override
    public WebDriver openUrlOnSafari(String url) {
        setSafariWebDriver();
        this.webDriver.get(url);

        return this.webDriver;
    }
}
