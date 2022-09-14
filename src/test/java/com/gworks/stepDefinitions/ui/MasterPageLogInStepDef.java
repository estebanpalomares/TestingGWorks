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

public class MasterPageLogInStepDef{

    private final WebDriversController _webDriversController = new WebDriversController();
    private final FillFormController _fillFormController = new FillFormController();
    private final Properties _properties = new AppProperties().getAppProperties();
    private WebDriver webDriver;

    @Given("A user has the Master Log In page open in {string} browser")
    public void aUserHasTheMasterLogInPageOpen(String browser) {
        this.webDriver = DriverFactory.getDriver(browser);
        this._webDriversController.openUrl(this._properties.getProperty("MasterLogInUrl"),browser);
    }

    @When("The user uses a {string} credentials in Master page")
    public void theUserUsesACredentials(String testCase) throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        this._fillFormController.fillLoginPage(this.webDriver,testCase);
        this._fillFormController.clickLoginButton(this.webDriver);
    }

    @Then("The user is logged in")
    public void theUserIsLoggedIn() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
        Assert.assertEquals(this.webDriver.getTitle(),"Client List - FrontDesk");
    }

    @Then("The user is not logged in")
    public void theUserIsNotLoggedIn() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        Assert.assertTrue(this.webDriver.getTitle().contains("gWorks Master Console - FrontDesk"));
    }

    @After(value = "@MASTER_LOGIN")
    public void closeBrowser() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        this._webDriversController.closeBrowser(this.webDriver);
    }
}
