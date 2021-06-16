package com.example.gui;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.hamcrest.CoreMatchers.*;

import static org.junit.Assert.*;


public class GuiTest {

    private WebDriver driver;
    private final String prefixURL = "http://google.com";

    @Before
    public void setup() {
        // Chrome 起動オプションを構成
        ChromeOptions options = new ChromeOptions();
        // headlessモードで起動
        options.addArguments("--headless");
        ChromeDriverService driverService = ChromeDriverService.createDefaultService();
        driver = new ChromeDriver(driverService, options);
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void validatePageTitle() {
        String requestUrl = prefixURL;
        driver.get(requestUrl);
        assertEquals("Google", driver.getTitle());
    }
}
