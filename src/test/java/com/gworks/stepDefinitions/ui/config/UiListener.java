package com.gworks.stepDefinitions.ui.config;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

public class UiListener implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {
//
//        Object testClass = result.getInstance();
//        WebDriver driver = ((BaseTest) testClass).getDriver();
//        if(driver instanceof WebDriver) {
//            takeScreenshot(driver);}
    }

    private void takeScreenshot(WebDriver driver) {
        Allure.addAttachment("Screenshot of failed step", new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES))); }

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] saveScreenshot(WebDriver driver) {
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        return screenshot; }

}
