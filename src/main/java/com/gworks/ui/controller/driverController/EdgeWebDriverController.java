package com.gworks.ui.controller.driverController;

import com.gworks.ui.services.driverServices.EdgeWebDriverService;
import org.openqa.selenium.WebDriver;

public class EdgeWebDriverController {

    private final EdgeWebDriverService _edgeWebDriverService = new EdgeWebDriverService();

    public WebDriver setEdgeWebDriver(){
        return this._edgeWebDriverService.setEdgeWebDriver();
    }

}
