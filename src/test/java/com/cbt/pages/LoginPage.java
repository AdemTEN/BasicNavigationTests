package com.cbt.pages;

import com.cbt.utilities.ConfigurationReader;
import com.cbt.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    /*

    @FindAll({
            @FindBy(id="prependedInput"),
            @FindBy(name = "_username")

    })
    public WebElement userNameInputBox;

    @FindBys({
            @FindBy(id="prependedInput"),
            @FindBy(name="_username")
    })
    public WebElement userNameInput;

     */

    //driver.findElement(By.id("prependedInput"));
    @FindBy(id="prependedInput")
    public WebElement userNameInput;

    @FindBy(id= "prependedInput2")
    public WebElement passwordInput;

    @FindBy(name="_submit")
    public WebElement loginButton;

    public static void loginAsDriver(){

        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        loginPage.userNameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.loginButton.click();

    }

    public static void loginAsStoreManager(){

        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");

        loginPage.userNameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.loginButton.click();

    }

    public static void loginAsSalesManager(){

        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.get("salesmanager_username");
        String password = ConfigurationReader.get("salesmanager_password");

        loginPage.userNameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.loginButton.click();
    }

    public static void loginPerson (String person){

        LoginPage loginPage = new LoginPage();

        String password ="";
        String username ="";


        switch (person){
            case "driver":
                username = ConfigurationReader.get("driver_username");
                password = ConfigurationReader.get("salesmanager_password");
                break;
            case "storemanager":
                username = ConfigurationReader.get("storemanager_username");
                 password = ConfigurationReader.get("storemanager_password");
                 break;
            case "salesmanager":
                username = ConfigurationReader.get("salesmanager_username");
                password = ConfigurationReader.get("salesmanager_password");
                break;
        }

        loginPage.userNameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.loginButton.click();






    }






}
