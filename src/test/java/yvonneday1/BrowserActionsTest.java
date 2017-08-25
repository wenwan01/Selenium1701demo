package yvonneday1;


import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



/**
 * Created by Administrator on 2017/6/4 0004.
 */
public class BrowserActionsTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void getTest() throws InterruptedException {
        driver.get("http://www.baidu.com");
        Thread.sleep(3000);

    }
    @Test
    public void backTest() throws InterruptedException {

        driver.get("http://www.baidu.com");
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);


    }
    @Test
    public void fordTest() throws InterruptedException {

        driver.get("http://www.baidu.com");
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().forward();
        Thread.sleep(3000);


    }

    @Test
    public void refreshTest() throws InterruptedException {

        driver.get("https://www.google.com.hk");
        Thread.sleep(3000);
        driver.navigate().refresh();


    }
    @Test
    public void winTest() throws InterruptedException {

        Dimension dimension = new Dimension(500, 500);
        driver.manage().window().setSize(dimension);
        Thread.sleep(3000);
        driver.manage().window().maximize();
        Thread.sleep(3000);

    }
    @Test
    public void getURLTest(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.baidu.com");
        String url = driver.getCurrentUrl();
        System.out.println("获取到的URL是："+ url);
        Assert.assertEquals(url,"http://www.baidu.com/");

    }
@AfterMethod
    public void closedBrowser(){
    driver.quit();
}
}
