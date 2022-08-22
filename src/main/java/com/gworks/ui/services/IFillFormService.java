package com.gworks.ui.services;

import org.openqa.selenium.WebDriver;

public interface IFillFormService {

    void fillLoginPage(WebDriver webDriver, String testCase);
    void selectCityInCityPage(WebDriver webDriver);
    void clickLoginButton(WebDriver webDriver);
}
