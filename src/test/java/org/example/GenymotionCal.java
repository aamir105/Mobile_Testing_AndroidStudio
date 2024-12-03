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
import java.time.Duration;

public class GenymotionCal {
    public AndroidDriver driver;

    @BeforeTest
    public void stUp() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities =new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("platformVersion","9");
        capabilities.setCapability("deviceName","192.168.35.101:5555");
        capabilities.setCapability("appPackage","com.android.calculator2");
        capabilities.setCapability("appPackage","com.android.calculator2.Calculator");

        driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        Thread.sleep(2000);

    }
    @Test
    public void addition() throws InterruptedException {
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

    @Test
    public void subtraction() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement eight =driver.findElement(By.id("com.android.calculator2:id/digit_8"));
        eight.click();

        WebElement minus =driver.findElement(By.id("com.android.calculator2:id/op_sub"));
        minus.click();

        WebElement five =driver.findElement(By.id("com.android.calculator2:id/digit_5"));
        five.click();

        WebElement equals =driver.findElement(By.id("com.android.calculator2:id/eq"));
        equals.click();

        WebElement results=driver.findElement(By.id("com.android.calculator2:id/result"));
        assert results.getText().equals("3"):"Actual value is : "+results.getText()+" matched with expected value: 3";

    }



    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
