package com.gworks.ui.services.driverServices;

import org.openqa.selenium.WebDriver;

public class WebDriversServices implements IWebDriversServices {


    @Override
    public void openUrl(String url, String browser) {
        DriverFactory.getDriver(browser).get(url);
    }

    @Override
    public void closeBrowser(WebDriver webDriver) {
        DriverFactory.closeDriver();
    }
}
