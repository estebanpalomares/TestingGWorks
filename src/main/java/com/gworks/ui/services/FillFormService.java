package com.gworks.ui.services;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class FillFormService implements IFillFormService{


    @Override
    public void fillLoginPage(WebDriver webDriver, String testCase) {

        WebElement emailAddressBox = webDriver.findElement(By.id("emailAddress"));
        WebElement loginPasswordBox = webDriver.findElement(By.id("loginPassword"));

        switch (testCase) {

            case "valid":
                emailAddressBox.sendKeys(System.getProperty("UserEmail"));
//                emailAddressBox.sendKeys("hola");
                loginPasswordBox.sendKeys(System.getProperty("UserPass"));
                break;

            case "Wrong eMail":
                emailAddressBox.sendKeys("wrong@email.com");
                loginPasswordBox.sendKeys(System.getProperty("UserPass"));
                break;

            case "Wrong Pass":
                emailAddressBox.sendKeys(System.getProperty("UserEmail"));
                loginPasswordBox.sendKeys("WrongPassword");
                break;

            case"Blank eMail":
                emailAddressBox.sendKeys("");
                loginPasswordBox.sendKeys(System.getProperty("UserPass"));
                break;

            case"Blank Pass":
                emailAddressBox.sendKeys(System.getProperty("UserEmail"));
                loginPasswordBox.sendKeys("");
                break;

            default:
                Assert.fail("The case "+testCase+" does not exist.");
        }
    }

    @Override
    public void selectCityInCityPage(WebDriver webDriver) {
        Select drpAgency = new Select(webDriver.findElement(By.name("citycode")));
        drpAgency.selectByVisibleText("City of Automation Test");
    }

    @Override
    public void clickLoginButton(WebDriver webDriver) {
        WebElement loginButton = webDriver.findElement(By.xpath("//*[@id='loginForm']/button"));
        loginButton.click();
    }
}
