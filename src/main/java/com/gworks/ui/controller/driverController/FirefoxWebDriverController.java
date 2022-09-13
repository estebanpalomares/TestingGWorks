package com.gworks.ui.controller.driverController;

import com.gworks.ui.services.driverServices.FireFoxWebDriverService;
import org.openqa.selenium.WebDriver;

public class FirefoxWebDriverController {

    private FireFoxWebDriverService _fireFoxWebDriverService = new FireFoxWebDriverService();

    public WebDriver setFireFoxWebDriver(){
        return this._fireFoxWebDriverService.setFireFoxWebDriver();
    }
}
