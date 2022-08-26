package com.gworks.ui.services;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@NoArgsConstructor
@AllArgsConstructor
public class ChromeWebDriverService implements IChromeWebDriverService{
    private WebDriver webDriver;
    @Override
    public void setChromeWebDriver(){
        WebDriverManager.chromedriver().setup();
        this.webDriver = new ChromeDriver();
    }

    @Override
    public WebDriver openUrlOnChrome(String url){
        setChromeWebDriver();
        this.webDriver.get(url);

        return this.webDriver;
    }
}
