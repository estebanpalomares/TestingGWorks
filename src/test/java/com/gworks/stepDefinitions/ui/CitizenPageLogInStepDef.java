package com.gworks.stepDefinitions.ui;

import com.gworks.ui.controller.FillFormController;
import com.gworks.ui.controller.driverController.WebDriversController;
import com.gworks.ui.services.driverServices.DriverFactory;
import com.gworks.utils.AppProperties;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class CitizenPageLogInStepDef{

    private final WebDriversController _webDriversController = new WebDriversController();
    private final FillFormController _fillFormController = new FillFormController();
    private final Properties _properties = new AppProperties().getAppProperties();
    private WebDriver webDriver;

    @Given("The user has the Citizen Log In page open in {string} browser")
    public void iHaveTheCitizenLogInPageOpen(String browser) {
        this.webDriver = DriverFactory.getDriver(browser);
        this._webDriversController.openUrl(this._properties.getProperty("CitizenLogInUrl"),browser);
    }

    @When("The user uses a {string} credentials in Citizen page")
    public void theUserUsesACredentialsInCitizenPage(String testCase) throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
        this._fillFormController.fillLoginPage(this.webDriver,testCase);
        this._fillFormController.clickLoginButton(this.webDriver);
    }

    @Then("The user is logged in Citizen")
    public void theUserIsLoggedInCitizen() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
        Assert.assertEquals(this.webDriver.getTitle(),"Pay Bills - FrontDesk");
    }

    @Then("The user is not logged in Citizen")
    public void theUserIsNotLoggedInCitizen() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
        Assert.assertTrue(this.webDriver.getTitle().contains("Home | gWorks - FrontDesk"));
    }

    @After(value = "@CITIZEN_LOGIN")
    public void closeBrowser() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        this._webDriversController.closeBrowser(this.webDriver);
    }
}
