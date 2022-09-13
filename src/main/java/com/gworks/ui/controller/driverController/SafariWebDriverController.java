package com.gworks.ui.controller.driverController;

import com.gworks.ui.services.driverServices.SafariWebDriverService;
import org.openqa.selenium.WebDriver;

public class SafariWebDriverController {

    private final SafariWebDriverService _safariWebDriverService = new SafariWebDriverService();

    public WebDriver setSafariWebDriver(){
        return this._safariWebDriverService.setSafariWebDriver();
    }
}
