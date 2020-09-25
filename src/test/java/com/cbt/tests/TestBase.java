package com.cbt.tests;

import com.cbt.pages.LoginPage;
import com.cbt.utilities.ConfigurationReader;
import com.cbt.utilities.Driver;
import com.cbt.utilities.ConfigurationReader;
import com.cbt.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;
    protected JavascriptExecutor jse;


    @BeforeMethod
    public void setUp(){
        driver = Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver,30);
        jse = (JavascriptExecutor) driver;
        driver.get(ConfigurationReader.get("url"));
        LoginPage.loginPerson("salesmanager");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
       // Driver.closeDriver();
    }

}