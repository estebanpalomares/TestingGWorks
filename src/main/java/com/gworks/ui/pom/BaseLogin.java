package com.gworks.ui.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BaseLogin {

    WebDriver webDriver;

    protected WebElement emailAddressBox = webDriver.findElement(By.id("emailAddress"));
    protected WebElement loginPasswordBox = webDriver.findElement(By.id("loginPassword"));
    protected Select drpAgency = new Select(webDriver.findElement(By.name("citycode")));
    protected WebElement loginButton = webDriver.findElement(By.xpath("//*[@id='loginForm']/button"));

}
