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

public class Physical_Device_Calculator {
    public AndroidDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("platformVersion","14");
        capabilities.setCapability("deviceName", "1377835077000GG");
        capabilities.setCapability("appPackage","com.vivo.calculator");
        capabilities.setCapability("appActivity","com.vivo.calculator.Calculator");
        URL url= new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(url,capabilities);

//        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        Thread.sleep(2000);
    }

    @Test
    public void testCal() throws InterruptedException  {
        //locate the Text on the calculator by using By.name()
        WebElement one=driver.findElement(By.id("com.vivo.calculator:id/digit_1"));
        one.click();
        WebElement zero=driver.findElement(By.id("com.vivo.calculator:id/digit_0"));
        zero.click();
        WebElement plus=driver.findElement(By.id("com.vivo.calculator:id/op_add"));
        plus.click();
        WebElement five=driver.findElement(By.id("com.vivo.calculator:id/digit_5"));
        five.click();
        WebElement equalTo=driver.findElement(By.id("com.vivo.calculator:id/eq"));
        equalTo.click();
        //locate the edit box of the calculator by using By.tagName()
        WebElement results=driver.findElement(By.id("com.vivo.calculator2:id/result"));
        //Check the calculated value on the edit box
        assert results.getText().equals("6"):"Actual value is : "+results.getText()+" did not match with expected value: 6";
    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

}
