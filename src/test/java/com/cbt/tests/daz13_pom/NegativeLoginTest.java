package com.cbt.tests.daz13_pom;

import com.cbt.pages.LoginPage;
import com.cbt.tests.TestBase;
import com.cbt.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {

    @Test
    public void wrongPasswordTest(){
        String username = ConfigurationReader.get("driver_username");
        driver.findElement(By.id("prependedInput")).sendKeys(username);
        driver.findElement(By.id("prependedInput2")).sendKeys("somepasswor"+ Keys.ENTER);

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");


    }

    @Test
    public void weongpass(){

            LoginPage loginpage = new LoginPage();
            String username = ConfigurationReader.get("driver_username");
            String password = "some";

            loginpage.userNameInput.sendKeys(username);
            loginpage.passwordInput.sendKeys(password);
            loginpage.loginButton.click();
            Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");

        }

    @Test
    public void wrongUserNameTest(){
        LoginPage loginPage = new LoginPage();

        String username = "fsfsfsf";
        String password = ConfigurationReader.get("driver_password");

        loginPage.userNameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.loginButton.click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");
    }


}
