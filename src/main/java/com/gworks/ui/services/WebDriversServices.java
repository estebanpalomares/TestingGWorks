package com.gworks.ui.services;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class WebDriversServices implements IWebDriversServices{

    private final ChromeWebDriverService chromeWebDriverService = new ChromeWebDriverService();
    private WebDriver webDriver;

    @Override
    public WebDriver openUrl(String url, String browser) {

        switch (browser){

            case"chrome":
                this.webDriver = this.chromeWebDriverService.openUrlOnChrome(url);
                break;

            case"firefox":
                break;

            default:
                Assert.fail("The Browser: "+browser+" does not exist.");
        }

        return this.webDriver;
    }

    @Override
    public void closeBrowser(WebDriver webDriver) {
                webDriver.close();
    }
}
