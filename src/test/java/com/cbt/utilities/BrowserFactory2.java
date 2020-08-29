package com.cbt.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory2 {

    public static WebDriver getDriver (String str){
        WebDriver driver = null;
        if(System.getProperty("os.name").contains("Mac") && str.equalsIgnoreCase("edge")){
            return null;
        }
        if(System.getProperty("os.name").contains("Windows") && str.equalsIgnoreCase("safari")){
            return null;
        }
        switch (str){
            case "chrome": driver= new ChromeDriver(); break;
            case "firefox": driver= new FirefoxDriver(); break;
            case "safari": driver= new SafariDriver(); break;
            case "edge": driver= new EdgeDriver(); break;
        }
        return driver;
    }

}
