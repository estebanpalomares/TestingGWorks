package com.gworks.ui.services;

import org.openqa.selenium.WebDriver;

public interface IFireFoxWebDriverService {

    void setFireFoxWebDriver();
    WebDriver openUrlOnFirefox(String url);
}
