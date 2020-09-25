package com.cbt.tests.RadioButton_TypeOfElements;

import com.cbt.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class RadioButtons {

    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        driver.manage().window().maximize();

        WebElement blueRadioBtn = driver.findElement(By.id("blue"));
        WebElement redRadioBtn = driver.findElement(By.id("red"));
        WebElement yellowRadioBtn = driver.findElement(By.id("yellow"));
        WebElement blackRadioBtn = driver.findElement(By.id("black"));
        WebElement greenRadioBtn  = driver.findElement(By.id("green"));
        greenRadioBtn.click();



        Assert.assertTrue(blueRadioBtn.isSelected(),"verify that blue button is selected");
        Assert.assertFalse(redRadioBtn.isSelected(),"verify that red button is  NOT selected");
        Assert.assertFalse(yellowRadioBtn.isSelected(),"verify that yellow button is  NOT selected");
        Assert.assertFalse(blackRadioBtn.isSelected(),"verify that yellow button is  NOT selected");

        Assert.assertFalse(greenRadioBtn.isSelected(),"verify that green button is  NOT selected");



        System.out.println("greenRadioBtn.isEnabled() = " + greenRadioBtn.isEnabled());
        Assert.assertFalse(greenRadioBtn.isEnabled(), "verify that green button is Not enabled");

        Assert.assertTrue(blackRadioBtn.isDisplayed(),"verify that black button is  displayed");
        Assert.assertTrue(greenRadioBtn.isDisplayed(),"verify that green button is  displayed");

        yellowRadioBtn.click();
        Assert.assertTrue(yellowRadioBtn.isSelected(),"verify that yellow button is selected");
        driver.quit();

    }
    @Test
    public void test2() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        WebElement userNameBox = driver.findElement(By.cssSelector("[type='username']"));
        System.out.println("userNameBox.isDisplayed() = " + userNameBox.isDisplayed());

        Assert.assertFalse(userNameBox.isDisplayed(),"verify username box is NOT displayed");

        driver.findElement(By.cssSelector("#start>button")).click();
        Thread.sleep(7000);

        System.out.println("userNameBox.isDisplayed() = " + userNameBox.isDisplayed());
        Assert.assertTrue(userNameBox.isDisplayed(),"verify username box is  displayed");

        userNameBox.sendKeys("adem");

        driver.quit();

    }

    @Test
    public void test3(){

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes");
        driver.manage().window().maximize();

        WebElement box1 = driver.findElement(By.xpath("(//form[@id='checkboxes']/input)[1]"));
        WebElement box2 = driver.findElement(By.xpath("(//form[@id='checkboxes']/input)[2]"));

        Assert.assertFalse(box1.isSelected(),"verffg");

        Assert.assertTrue(box2.isSelected(),"vfdddf");

        box1.click();

        Assert.assertTrue(box1.isSelected());
        Assert.assertTrue(box2.isSelected());

        driver.quit();


    }
    @Test
    public void test4() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        driver.manage().window().maximize();

        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));

        Assert.assertFalse(inputBox.isEnabled(),"verify that input Box is not enabled");

        driver.findElement(By.cssSelector("#input-example>button")).click();
        Thread.sleep(5000);

        Assert.assertTrue(inputBox.isEnabled()," verify that input Box is enabled");

        WebElement checkbox = driver.findElement(By.cssSelector("#checkbox>input"));
        checkbox.click();


      driver.findElement(By.cssSelector("#checkbox-example>button")).click();
       Thread.sleep(5000);

        WebElement addButton = driver.findElement(By.xpath("//button[contains(text(),'Add')]"));
        System.out.println("addButton = " + addButton.getText());

        System.out.println("addButton.getAttribute= " + addButton.getAttribute("autocomplete"));


        String HTML = addButton.getAttribute("outerHTML");
        System.out.println(addButton.getAttribute("outerHTML"));
        System.out.println(addButton.getAttribute("innerHTML"));

        Assert.assertTrue(HTML.contains("Add"));

        addButton.click();
        Thread.sleep(3000);

        WebElement checkbox2 = driver.findElement(By.cssSelector("input#checkbox"));

        Assert.assertTrue(checkbox2.isDisplayed());
        Assert.assertTrue(checkbox2.isEnabled());
        checkbox2.click();
        Assert.assertTrue(checkbox2.isSelected());
        



    }










}
