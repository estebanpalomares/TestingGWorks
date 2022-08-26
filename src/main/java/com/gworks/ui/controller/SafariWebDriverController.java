package com.gworks.ui.controller;

import com.gworks.ui.services.SafariWebDriverService;
import org.openqa.selenium.WebDriver;

public class SafariWebDriverController {

    private final SafariWebDriverService safariWebDriverService = new SafariWebDriverService();

    public WebDriver openUrlOnSafari(String url){return this.safariWebDriverService.openUrlOnSafari(url);}
}
