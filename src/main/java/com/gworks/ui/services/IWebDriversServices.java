package com.gworks.ui.services;

import org.openqa.selenium.WebDriver;

public interface IWebDriversServices{

    WebDriver openUrl(String url, String browser);
    void closeBrowser(WebDriver webDriver);
}
