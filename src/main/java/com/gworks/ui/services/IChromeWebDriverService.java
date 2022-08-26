package com.gworks.ui.services;

import org.openqa.selenium.WebDriver;

public interface IChromeWebDriverService {

    void setChromeWebDriver();

    WebDriver openUrlOnChrome(String url);

}
