package com.gworks.ui.services.driverServices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class FireFoxWebDriverService implements IFireFoxWebDriverService {

    private WebDriver webDriver;

    @Override
    public WebDriver setFireFoxWebDriver() {
        WebDriverManager.firefoxdriver().setup();
        this.webDriver = new FirefoxDriver();
        this.webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        this.webDriver.manage().window().maximize();
        return this.webDriver;
    }

}
