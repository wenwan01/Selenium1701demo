package yvonneday1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Administrator on 2017/6/5 0005.
 */
public class FindElementsTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void byIDTest(){
        driver.get("http://www.baidu.com");
        WebElement keyField = driver.findElement(By.id("kw"));
    }
    @Test
    public void byNameTest(){
        driver.get("http://www.baidu.com");
        WebElement keyField = driver.findElement(By.name("wd"));
    }
    @Test
    public void byClassTest(){
        driver.get("http://www.baidu.com");
        WebElement keyField = driver.findElement(By.className("bri"));
    }
    @Test
    public void byLinkTextTest(){
        driver.get("http://www.baidu.com");
        WebElement keyField = driver.findElement(By.linkText("糯米"));
    }
    @Test
    public void bypartialLinkTextTest(){
        driver.get("http://www.baidu.com");
        WebElement keyField = driver.findElement(By.partialLinkText("糯"));
    }
    @Test
    public void byTagName(){
        driver.get("http://www.baidu.com");
        List<WebElement> list =  driver.findElements(By.tagName("input"));
        System.out.println(list.size());
    }
    @Test
    public void byXpath(){
        driver.get("http://www.baidu.com");
        WebElement keyField = driver.findElement(By.xpath(".//*[@id='su']"));

    }
    @Test
    public void byCSS(){
        driver.get("http://www.baidu.com");
        WebElement keyField = driver.findElement(By.cssSelector("#lg>span>img"));

    }
    @AfterMethod
    public void closedBrowser(){
        driver.quit();
    }
}
