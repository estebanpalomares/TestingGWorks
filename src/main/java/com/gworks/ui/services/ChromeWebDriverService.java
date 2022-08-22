package com.gworks.ui.services;

import com.gworks.utils.AppProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@NoArgsConstructor
@AllArgsConstructor
public class ChromeWebDriverService {
    private WebDriver webDriver;

    private void setChromeWebDriver(){
        WebDriverManager.chromedriver().setup();
        this.webDriver = new ChromeDriver();
    }

    public WebDriver openUrlOnChrome(String url){
        setChromeWebDriver();
        this.webDriver.get(url);

        return this.webDriver;
    }

    public void closeChrome(){
        this.webDriver.close();
    }
}
