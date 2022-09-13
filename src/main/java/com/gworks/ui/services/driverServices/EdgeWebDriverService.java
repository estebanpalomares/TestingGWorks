package com.gworks.ui.services.driverServices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class EdgeWebDriverService implements IEdgeWebDriverService {

    private WebDriver webDriver;

    @Override
    public WebDriver setEdgeWebDriver() {
        WebDriverManager.edgedriver().setup();
        this.webDriver = new EdgeDriver();
        this.webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        this.webDriver.manage().window().maximize();
        return this.webDriver;
    }

}
