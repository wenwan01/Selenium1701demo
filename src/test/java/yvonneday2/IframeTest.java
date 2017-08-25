package yvonneday2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017/6/21 0021.
 */
public class IframeTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void iframeTest() throws InterruptedException {
        driver.get("C:\\selenium_html\\selenium_html\\index.html");
        //通过name或ID转交控制权
        driver.switchTo().frame("aa");

        driver.findElement(By.linkText("baidu")).click();
        Thread.sleep(3000);
        driver.switchTo().defaultContent();
        driver.findElement(By.linkText("登录界面")).click();
    }
}
