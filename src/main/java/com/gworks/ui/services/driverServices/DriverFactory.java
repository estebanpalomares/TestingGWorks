package com.gworks.ui.services.driverServices;

import com.gworks.ui.controller.driverController.ChromeWebDriverController;
import com.gworks.ui.controller.driverController.EdgeWebDriverController;
import com.gworks.ui.controller.driverController.FirefoxWebDriverController;
import com.gworks.ui.controller.driverController.SafariWebDriverController;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DriverFactory {

    private static final ChromeWebDriverController _chromeWebDriverController = new ChromeWebDriverController();
    private static final FirefoxWebDriverController _firefoxWebDriverController = new FirefoxWebDriverController();
    private static final SafariWebDriverController _safariWebDriverController =  new SafariWebDriverController();
    private static final EdgeWebDriverController _edgeWebDriverController = new EdgeWebDriverController();
    private static ThreadLocal<WebDriver> localDriver = new ThreadLocal<>();

    private DriverFactory() {

    }

    public static WebDriver getDriver(String browser){
       if (localDriver.get() == null) {
            switch (browser) {
                case "chrome":
                    //driver = _chromeWebDriverController.setChromeDriver ();
                    localDriver.set(_chromeWebDriverController.setChromeDriver());
                    break;
                case "firefox":
                    //driver = _firefoxWebDriverController.setFireFoxWebDriver();
                    localDriver.set(_firefoxWebDriverController.setFireFoxWebDriver());
                    break;
                case "safari":
                    //driver = _safariWebDriverController.setSafariWebDriver();
                    localDriver.set(_safariWebDriverController.setSafariWebDriver());
                    break;
                case "edge":
                    //driver = _edgeWebDriverController.setEdgeWebDriver();
                    localDriver.set(_edgeWebDriverController.setEdgeWebDriver());
                    break;
                default:
                    Assert.fail("The Browser: " + browser + " does not exist.");
            }
        }
        return localDriver.get();
    }

    public static void closeDriver() {
        localDriver.get().close();
        localDriver.remove();
    }

}
