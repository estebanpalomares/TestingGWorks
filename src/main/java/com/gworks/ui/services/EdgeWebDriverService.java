package com.gworks.ui.services;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeWebDriverService implements IEdgeWebDriverService{

    private WebDriver webDriver;

    @Override
    public void setEdgeWebDriver() {
        WebDriverManager.edgedriver().setup();
        this.webDriver = new EdgeDriver();
    }

    @Override
    public WebDriver openUrlOnEdge(String url) {
        setEdgeWebDriver();
        this.webDriver.get(url);

        return this.webDriver;
    }
}
