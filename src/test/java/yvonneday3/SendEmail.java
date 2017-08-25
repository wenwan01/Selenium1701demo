package yvonneday3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/7/6 0006.
 */
public class SendEmail {
    WebDriver driver;

    @BeforeMethod
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://mail.163.com/");
    }
    @Test
    public void sendemail() throws InterruptedException {
        Thread.sleep(2000);
        driver.switchTo().frame("x-URS-iframe");
        driver.findElement(By.name("email")).sendKeys("zhongzhong821221");
        driver.findElement(By.name("password")).sendKeys("518420Zy");
        driver.findElement(By.id("dologin")).click();


       driver.findElement(By.xpath(".//*[@id='dvNavTop']/ul/li[2]/span[2]")).click();
        driver.findElement(By.className("nui-editableAddr-ipt")).sendKeys("235434473@qq.com");
        //driver.findElement(By.xpath("//*[@title=\"一次可发送2000张照片，600首MP3，一部高清电影\"]input")).sendKeys("C:\\201610201852567567");
        WebElement frame = driver.findElement(By.className("APP-editor-iframe"));
        driver.switchTo().frame(frame);
        driver.findElement(By.xpath("/html/body")).sendKeys("hello");
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath(".//*[text()='发送']"));
     Boolean bl = driver.findElement(By.xpath(".//*[text()='发送成功'")).isDisplayed();
        Assert.assertTrue(bl);

    }
}
