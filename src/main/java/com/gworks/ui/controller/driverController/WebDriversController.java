package com.gworks.ui.controller.driverController;

import com.gworks.ui.services.driverServices.WebDriversServices;
import org.openqa.selenium.WebDriver;

public class WebDriversController {

    private WebDriversServices _webDriversServices = new WebDriversServices();

    public void openUrl(String url, String browser){
        _webDriversServices.openUrl(url,browser);
    }
    public void closeBrowser(WebDriver webDriver){this._webDriversServices.closeBrowser(webDriver);}
}
