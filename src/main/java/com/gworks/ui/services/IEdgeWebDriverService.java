package com.gworks.ui.services;

import org.openqa.selenium.WebDriver;

public interface IEdgeWebDriverService {

    void setEdgeWebDriver();

    WebDriver openUrlOnEdge(String url);
}
