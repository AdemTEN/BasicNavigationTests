package com.cbt.tests.daz13_pom;

import com.cbt.pages.LoginPage;
import com.cbt.tests.TestBase;
import com.cbt.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestBase {

    @Test
    public void loginAsDriver(){
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("driver_username");
        String pasword = ConfigurationReader.get("driver_password");

        loginPage.userNameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(pasword);
        loginPage.loginButton.click();
    }
    @Test
    public void loginAsDriver2(){

        LoginPage.loginAsDriver();
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/");
    }

    @Test
    public void loginAsStroreManger(){
        LoginPage.loginAsStoreManager();
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/");
    }
    @Test
    public void loginAsSalesManager(){
        LoginPage.loginAsSalesManager();
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/");

    }

    @Test
    public void loginPersonTest(){

        LoginPage.loginPerson("salesmanager");
    }
    @Test
    public void TestDashboard(){

    }




}
