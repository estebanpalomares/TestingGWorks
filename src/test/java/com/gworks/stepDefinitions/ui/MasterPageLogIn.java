package com.gworks.stepDefinitions.ui;

import com.gworks.ui.controller.ChromeWebDriverController;
import com.gworks.utils.AppProperties;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class MasterPageLogIn {

    private final ChromeWebDriverController chromeController = new ChromeWebDriverController();
    private final Properties properties = new AppProperties().getAppProperties();
    private WebDriver chromeWebDriver;

    @Given("I have the Master Log In page open")
    public void iHaveTheMasterLogInPageOpen() {
        this.chromeWebDriver = this.chromeController.openUrlOnChrome(this.properties.getProperty("MasterLogInUrl"));
    }

    @When("I use a valid credentials")
    public void iUseAValidCredentials() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        WebElement emailAddressBox = this.chromeWebDriver.findElement(By.id("emailAddress"));
        emailAddressBox.sendKeys(System.getProperty("MasterUserEmail"));
        WebElement loginPasswordBox = this.chromeWebDriver.findElement(By.id("loginPassword"));
        loginPasswordBox.sendKeys(System.getProperty("MasterUserPass"));
        WebElement loginButton = this.chromeWebDriver.findElement(By.xpath("/html/body/article/div/form/button"));
        loginButton.click();
    }

    @Then("I am logged in")
    public void iAmLoggedIn() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
        Assert.assertEquals("Client List - FrontDesk",this.chromeWebDriver.getTitle());
        this.chromeController.closeChrome();
    }
}
