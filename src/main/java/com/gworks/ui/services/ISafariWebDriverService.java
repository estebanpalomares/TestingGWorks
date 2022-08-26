package com.gworks.ui.services;

import org.openqa.selenium.WebDriver;

public interface ISafariWebDriverService {

    void setSafariWebDriver();
    WebDriver openUrlOnSafari(String url);
}
