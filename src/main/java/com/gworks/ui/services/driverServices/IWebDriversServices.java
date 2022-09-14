package com.gworks.ui.services.driverServices;

import org.openqa.selenium.WebDriver;

public interface IWebDriversServices{

    void openUrl(String url, String browser);
    void closeBrowser(WebDriver webDriver);
}
