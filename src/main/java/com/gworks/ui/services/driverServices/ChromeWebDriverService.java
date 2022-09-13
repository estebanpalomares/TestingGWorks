package com.gworks.ui.services.driverServices;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

@NoArgsConstructor
@AllArgsConstructor
public class ChromeWebDriverService implements IChromeWebDriverService {
    private WebDriver webDriver;
    @Override
    public WebDriver setChromeWebDriver(){
        WebDriverManager.chromedriver().setup();
        this.webDriver = new ChromeDriver();
        this.webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        this.webDriver.manage().window().maximize();
        return this.webDriver;
    }

}
