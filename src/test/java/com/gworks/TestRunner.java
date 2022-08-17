package com.gworks;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features",
        glue = {"com.gworks.stepDefinitions"},
        plugin = {"pretty" ,"html:target/cucumber/events/cucumber-html-report"
                ,"html:target/cucumber/events/cucumber_pretty.html"
                ,"json:target/cucumber/events/cucumberTestReport.json"}
                ,publish = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
