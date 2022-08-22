package com.gworks.ui.controller;

import com.gworks.ui.services.WebDriversServices;
import org.openqa.selenium.WebDriver;

public class WebDriversController {

    private WebDriversServices webDriversServices = new WebDriversServices();

    public WebDriver openUrl(String url, String browser){return this.webDriversServices.openUrl(url, browser);}
    public void closeBrowser(WebDriver webDriver){this.webDriversServices.closeBrowser(webDriver);}
}
