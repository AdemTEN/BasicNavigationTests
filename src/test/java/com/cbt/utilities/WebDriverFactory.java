package com.cbt.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverFactory {

    public static WebDriver getDriver(String browserType) {

        WebDriver driver = null;

        switch (browserType.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "safari":
                if(System.getProperty("os.name").toLowerCase().contains("win")){
                    driver = null;
                }else if(System.getProperty("os.name").toLowerCase().contains("mac")){
                     driver = new SafariDriver();
                }
            case "edge":
               if(System.getProperty("os.name").toLowerCase().contains("mac")){
                   driver = null;
               }else if(System.getProperty("os.name").toLowerCase().contains("win")){
                   WebDriverManager.edgedriver().setup();
                   driver = new EdgeDriver();
               }




        }
        return driver;

    }
}
