package com.gworks.ui.services.driverServices;

import com.gworks.ui.services.driverServices.ISafariWebDriverService;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.util.concurrent.TimeUnit;

public class SafariWebDriverService implements ISafariWebDriverService {

    private WebDriver webDriver;

    @Override
    public WebDriver setSafariWebDriver() {
        WebDriverManager.safaridriver().setup();
        SafariOptions options = new SafariOptions();
        options.setBrowserVersion("5.1.7");
        this.webDriver = new SafariDriver(options);
        this.webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        this.webDriver.manage().window().maximize();
        return this.webDriver;
    }

}
