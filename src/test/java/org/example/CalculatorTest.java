package org.example;


import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class CalculatorTest{
    public AndroidDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("platformVersion","9");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("appPackage","com.android.calculator2");
        capabilities.setCapability("appActivity","com.android.calculator2.Calculator");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        Thread.sleep(2000);

    }
    @Test
    public void testCal() throws Exception {
        //locate the Text on the calculator by using By.name()
        WebElement one=driver.findElement(By.id("com.android.calculator2:id/digit_1"));
        one.click();
        WebElement zero=driver.findElement(By.id("com.android.calculator2:id/digit_0"));
        zero.click();

        WebElement plus=driver.findElement(By.id("com.android.calculator2:id/op_add"));
        plus.click();
        WebElement five=driver.findElement(By.id("com.android.calculator2:id/digit_5"));
        five.click();

        WebElement equalTo=driver.findElement(By.id("com.android.calculator2:id/eq"));
        equalTo.click();
        //locate the edit box of the calculator by using By.tagName()
        WebElement results=driver.findElement(By.id("com.android.calculator2:id/result"));
        //Check the calculated value on the edit box
        assert results.getText().equals("6"):"Actual value is : "+results.getText()+" did not match with expected value: 6";
    }


    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

}
