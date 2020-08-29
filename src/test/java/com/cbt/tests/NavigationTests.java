package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;

public class NavigationTests {

    public static void main(String[] args) {

      //  runBrowser("edge");
      //  runBrowser("chrome");
      //  runBrowser("firefox");

        String browsers = "Edge Chrome Firefox";

        String [] arr  =  browsers.split(" ");

      /*
        for(String val : arr){
           runBrowser(val);
       }
      */

       for(int i= 0;i< arr.length;i++){
           System.out.println("Browser Test: " + arr[i] );
           runBrowser(arr[i]);

       }


    }
    public static void runBrowser(String browserType){
        WebDriver driver = BrowserFactory.getDriver(browserType);
        driver.get("https://google.com");
        String expectedGoogleTitle = driver.getTitle();
        driver.get("https://etsy.com");
        String expectedEtsyTitle = driver.getTitle();
        driver.navigate().back();
        String actuallGoogleTitle = driver.getTitle();
        System.out.println("Verification 1");
        StringUtility.verifyEquals(expectedGoogleTitle, actuallGoogleTitle );
        driver.navigate().forward();
        String actuallEtsyTitle = driver.getTitle();
        System.out.println("Verification 2");
        StringUtility.verifyEquals(expectedEtsyTitle, actuallEtsyTitle);

        driver.quit();

    }
}
