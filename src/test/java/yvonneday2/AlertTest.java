package yvonneday2;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2017/6/6 0006.
 */
public class AlertTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();
    }
   @Test
    public void alertTest() throws InterruptedException {
        driver.get("file:///C:/selenium_html/selenium_html/index.html");
        driver.findElement(By.className("alert")).click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        alert.accept();
        Assert.assertEquals(text,"请点击确定");
    }
    @Test
    public void confirmTest() throws InterruptedException {
        driver.get("file:///C:/selenium_html/selenium_html/index.html");
        driver.findElement(By.className("confirm")).click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        Thread.sleep(3000);
        alert.accept();
    }
    @Test
    public void promptTest() throws InterruptedException {
        driver.get("file:///C:/selenium_html/selenium_html/index.html");
        driver.findElement(By.className("prompt")).click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("这个是prompt");
        alert.accept();
        Thread.sleep(3000);
        alert.accept();
    }





    @AfterMethod
    public void closed(){
        driver.quit();
    }
}