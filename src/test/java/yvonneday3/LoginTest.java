package yvonneday3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/7/5 0005.
 */
public class LoginTest {
    WebDriver driver;

    @BeforeMethod
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://mail.163.com/");
    }
    @Test
    public void loginSuccess() throws InterruptedException {
        Thread.sleep(2000);
        driver.switchTo().frame("x-URS-iframe");
        driver.findElement(By.name("email")).sendKeys("zhongzhong821221");
        driver.findElement(By.name("password")).sendKeys("518420Zy");
        driver.findElement(By.id("dologin")).click();
        //显示等待
        WebDriverWait wait = new WebDriverWait(driver,20);
        String logout = driver.findElement(By.linkText("退出")).getText();
        Assert.assertEquals(logout,"退出");
    }
   @Test
    public void loginFail() throws InterruptedException {
      // Thread.sleep(2000);
      // driver.switchTo().frame("x-URS-iframe");
      // driver.findElement(By.name("email")).sendKeys("zhongzhong821221");
      // driver.findElement(By.name("password")).sendKeys("518420zy");
      // driver.findElement(By.id("dologin")).click();
       LoginTest.login(driver,"zhongzhong821221","518420zy");
       WebDriverWait wait = new WebDriverWait(driver,10);
       wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"nerror\"]/div[2]")));
       String error = driver.findElement(By.xpath("//*[@id=\"nerror\"]/div[2]")).getText();
       Assert.assertEquals(error,"帐号或密码错误");
   }
   @Test
    public static void login(WebDriver driver,String email,String pwd){
       driver.switchTo().frame("x-URS-iframe");
       driver.findElement(By.name("email")).sendKeys("email");
       driver.findElement(By.name("password")).sendKeys("pwd");
       driver.findElement(By.id("dologin")).click();
   }

}
