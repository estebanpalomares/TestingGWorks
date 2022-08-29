package com.gworks.ui.controller;

import com.gworks.ui.services.FireFoxWebDriverService;
import org.openqa.selenium.WebDriver;

public class FirefoxWebDriverController {

    private FireFoxWebDriverService fireFoxWebDriverService = new FireFoxWebDriverService();

    public WebDriver openUrlOnFirefox(String url){return this.fireFoxWebDriverService.openUrlOnFirefox(url);}
}
