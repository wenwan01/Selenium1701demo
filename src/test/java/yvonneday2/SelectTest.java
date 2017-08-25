package yvonneday2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017/6/26 0026.
 */
public class SelectTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();



    }
    @Test
    public void selectTest() throws InterruptedException {
        driver.get("file:///C:/selenium_html/selenium_html/index.html");
        WebElement selectEl = driver.findElement(By.id("moreSelect"));
        Select select = new Select(selectEl);
        select.selectByIndex(2);
        Thread.sleep(3000);
        select.selectByValue("huawei");
        Thread.sleep(3000);
        select.selectByVisibleText("iphone");
        Thread.sleep(3000);
    }
    @AfterTest
    public void closed(){

        driver.quit();
    }
}
