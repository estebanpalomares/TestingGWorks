package com.gworks.stepDefinitions.ui;


import com.gworks.ui.controller.FillFormController;
import com.gworks.ui.controller.WebDriversController;
import com.gworks.utils.AppProperties;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class CityPageLogInStepDef{

    private final WebDriversController webDriversController = new WebDriversController();
    private final FillFormController fillFormController = new FillFormController();
    private WebDriver webDriver;
    private final Properties properties = new AppProperties().getAppProperties();

    @Given("A user has the FrontDesk Log In page open in {string} browser")
    public void iHaveTheFrontDeskLogInPageOpen(String browser) {
        this.webDriver = this.webDriversController.openUrl(this.properties.getProperty("CityLogInUrl"),browser);
    }

    @When("The user uses a {string} credentials in FrontDesk page")
    public void theUserUsesACredentialsInFrontDeskPage(String testCase) throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
        this.fillFormController.fillLoginPage(this.webDriver,testCase);
        this.fillFormController.clickLoginButton(this.webDriver);
        TimeUnit.SECONDS.sleep(4);
        this.fillFormController.selectCityInCityPage(this.webDriver,testCase);
        this.fillFormController.clickLoginButton(this.webDriver);
    }

    @Then("The user is logged in FrontDesk")
    public void theUserIsLoggedInFrontDesk() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
        Assert.assertEquals(this.webDriver.getTitle(),"FrontDesk - FrontDesk");
    }

    @When("The user uses a fail {string} credentials in FrontDesk page")
    public void theUserUsesAFailCredentialsInFrontDeskPage(String testCase) throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
        this.fillFormController.fillLoginPage(this.webDriver,testCase);
        this.fillFormController.clickLoginButton(this.webDriver);
    }

    @Then("The user is not logged in FrontDesk")
    public void theUserIsNotLoggedInFrontDesk() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
        Assert.assertTrue(this.webDriver.getTitle().contains("Agency Login - FrontDesk"));
    }

    @After(value = "@CITY_LOGIN")
    public void closeBrowser() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        this.webDriversController.closeBrowser(this.webDriver);
    }
}
