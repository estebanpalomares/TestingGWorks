package com.gworks.ui.services;

import com.gworks.ui.controller.ChromeWebDriverController;
import com.gworks.ui.controller.EdgeWebDriverController;
import com.gworks.ui.controller.FirefoxWebDriverController;
import com.gworks.ui.controller.SafariWebDriverController;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class WebDriversServices implements IWebDriversServices{

    private final ChromeWebDriverController chromeWebDriverController = new ChromeWebDriverController();
    private final FirefoxWebDriverController firefoxWebDriverController = new FirefoxWebDriverController();
    private final SafariWebDriverController safariWebDriverController =  new SafariWebDriverController();
    private final EdgeWebDriverController edgeWebDriverController = new EdgeWebDriverController();
    private WebDriver webDriver;

    @Override
    public WebDriver openUrl(String url, String browser) {

        switch (browser){

            case "chrome":
                this.webDriver = this.chromeWebDriverController.openUrlOnChrome(url);
                break;

            case "firefox":
                this.webDriver = this.firefoxWebDriverController.openUrlOnFirefox(url);
                break;

            case "safari":
                this.webDriver = this.safariWebDriverController.openUrlOnSafari(url);
                break;

            case "edge":
                this.webDriver = this.edgeWebDriverController.openUrlOnEdge(url);
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
