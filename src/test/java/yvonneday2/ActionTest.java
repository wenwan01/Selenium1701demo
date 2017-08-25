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
public class ActionTest {
   WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void clickTest(){
        driver.get("http://www.baidu.com");
        WebElement newslink = driver.findElement(By.xpath(".//*[@id='u1']/span[2]/a"));
        newslink.click();
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url,"http://news.baidu.com/");
    }
    @Test
    public void sendkeysTest(){
        driver.get("http://www.baidu.com");
        WebElement keys = driver.findElement(By.id("kw"));
        keys.sendKeys("selenium");
        WebElement baiduButton = driver.findElement(By.id("su"));
        baiduButton.click();
        String title = driver.getTitle();
        Assert.assertEquals(title,"selenium_百度搜索");

    }
    @Test
    public void clearTest() throws InterruptedException {
        driver.get("http://www.baidu.com");
        WebElement keys = driver.findElement(By.id("kw"));
        keys.sendKeys("selenium");
        Thread.sleep(3000);
        keys.clear();
    }
    @Test
    public void getTextTest(){
        driver.get("http://www.baidu.com");
        String text1 = driver.findElement(By.xpath(".//*[@id='u1']/span[2]/a")).getText();
        Assert.assertEquals(text1,"新闻");

    }
    @Test
    public void getTagNameTest(){
        driver.get("http://www.baidu.com");
        String tagName = driver.findElement(By.id("kw")).getTagName();
        Assert.assertEquals(tagName,"input");
    }
    @Test
    public void getATest(){
        driver.get("http://www.baidu.com");
        String attributeValue = driver.findElement(By.id("su")).getAttribute("value");
        Assert.assertEquals(attributeValue,"百度一下");
    }
    @Test
    public void isDisplayedTest(){
        driver.get("http://www.baidu.com");
        Boolean b = driver.findElement(By.id("su")).isDisplayed();
        Assert.assertTrue(b);
    }
    @Test
    public void isSelectTest(){
        driver.get("file:///C:/selenium_html/selenium_html/index.html");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"radio\"]/input[1]"));
        element.click();
        Boolean b = element.isSelected();
        Assert.assertTrue(b);
    }
    @Test
    public void isEnabledTest(){
        driver.get("file:///C:/selenium_html/selenium_html/index.html");
        Boolean b = driver.findElement(By.name("buttonhtml")).isEnabled();
        Assert.assertFalse(b);
    }
    @Test
    public void shotTest(){
        driver.get("http://www.baidu.com");
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try{
            FileUtils.copyFile(file,new File("C:\\test.png"));
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    @AfterMethod
    public void closed(){
        driver.quit();
    }
}
