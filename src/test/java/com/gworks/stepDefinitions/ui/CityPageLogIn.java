package com.gworks.stepDefinitions.ui;


import com.gworks.ui.controller.ChromeWebDriverController;
import com.gworks.utils.AppProperties;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class CityPageLogIn {
    private final ChromeWebDriverController chromeController = new ChromeWebDriverController();
    private final Properties properties = new AppProperties().getAppProperties();
    private WebDriver chromeWebDriver;

    @Given("I have the FrontDesk Log In page open")
    public void iHaveTheFrontDeskLogInPageOpen() {
        this.chromeWebDriver = this.chromeController.openUrlOnChrome(this.properties.getProperty("CityLogInUrl"));
    }

    @When("I use a {string} credentials in FrontDesk")
    public void iUseACredentialsInFrontDesk(String testCase) throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        WebElement emailAddressBox = this.chromeWebDriver.findElement(By.id("emailAddress"));
        WebElement loginPasswordBox = this.chromeWebDriver.findElement(By.id("loginPassword"));
        Select drpAgency = new Select(this.chromeWebDriver.findElement(By.name("citycode")));
        WebElement loginButton = this.chromeWebDriver.findElement(By.xpath("//*[@id='loginForm']/button"));

        switch (testCase) {

            case "valid":
                emailAddressBox.sendKeys(System.getProperty("MasterUserEmail"));
                loginPasswordBox.sendKeys(System.getProperty("MasterUserPass"));
                loginButton.click();
                TimeUnit.SECONDS.sleep(4);
                drpAgency.selectByVisibleText("City of Automation Test");
                break;

            case "Wrong eMail":
                emailAddressBox.sendKeys("wrong@email.com");
                loginPasswordBox.sendKeys(System.getProperty("MasterUserPass"));
                break;

            case "Wrong Pass":
                emailAddressBox.sendKeys(System.getProperty("MasterUserEmail"));
                loginPasswordBox.sendKeys("WrongPassword");
                break;

            case"Blank eMail":
                emailAddressBox.sendKeys("");
                loginPasswordBox.sendKeys(System.getProperty("MasterUserPass"));
                break;

            case"Blank Pass":
                emailAddressBox.sendKeys(System.getProperty("MasterUserEmail"));
                loginPasswordBox.sendKeys("");
                break;

            default:
                Assert.fail("The case "+testCase+" does not exist.");
        }

        loginButton.click();
    }

    @Then("I am logged in FrontDesk")
    public void iAmLoggedInFrontDesk() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
        Assert.assertEquals("FrontDesk - FrontDesk",this.chromeWebDriver.getTitle());
        this.chromeController.closeChrome();
    }

    @Then("I am not logged in FrontDesk")
    public void iAmNotLoggedInFrontDesk() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
        Assert.assertTrue(this.chromeWebDriver.getTitle().contains("Agency Login - FrontDesk"));
        this.chromeController.closeChrome();
    }

}
