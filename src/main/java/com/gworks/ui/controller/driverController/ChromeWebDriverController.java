package com.gworks.ui.controller.driverController;

import com.gworks.ui.services.driverServices.ChromeWebDriverService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;

@AllArgsConstructor
@NoArgsConstructor
public class ChromeWebDriverController {

    private ChromeWebDriverService _chromeService = new ChromeWebDriverService();

    public WebDriver setChromeDriver(){
        return this._chromeService.setChromeWebDriver();
    }

}
