package yvonneday2;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

/**
 * Created by Administrator on 2017/6/27 0027.
 */
public class ActionTest2 {
    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void rightClick(){
        driver.get("http://www.baidu.com");

        WebElement buttonBaidu = driver.findElement(By.id("su"));
        Actions actions = new Actions(driver);
        actions.contextClick(buttonBaidu).perform();
    }
    @Test
    public void doubleClick(){
        driver.get("http://baidu.com");
        WebElement buttonBaidu = driver.findElement(By.id("su"));
        Actions actions = new Actions(driver);
        actions.doubleClick(buttonBaidu).perform();


    }
    @Test
    public void move() throws InterruptedException {
        driver.get("file:///C:/selenium_html/selenium_html/index.html");
        WebElement element = driver.findElement(By.xpath(".//*[@id=\"action\"]/input"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
       Thread.sleep(3000);
       String hello = driver.findElement(By.xpath("//*[text()='Hello World!']")).getText();
        Assert.assertEquals(hello,"Hello World!");
    }

    @Test
    public void dragTest(){
        driver.get("file:///C:/selenium_html/selenium_html/dragAndDrop.html");
        WebElement element = driver.findElement(By.id("drag"));
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(element,500,500).perform();
    }
    @Test
    public void dropTest(){
        driver.get("file:///C:/selenium_html/selenium_html/dragAndDrop.html");

        WebElement el1 = driver.findElement(By.id("drag"));
        WebElement el2 = driver.findElement(By.xpath("/html/body/h1"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(el1).moveToElement(el2).release(el1).perform();
    }
    @Test
    public void moreSelectTest(){
        driver.get("file:///C:/selenium_html/selenium_html/index.html");
        WebElement element = driver.findElement(By.id("selectWithMultipleEqualsMultiple"));
        List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"selectWithMultipleEqualsMultiple\"]/option"));
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).click(list.get(2)).keyUp(Keys.CONTROL).perform();
    }
    @Test
    public void saveHtml () throws AWTException {
        driver.get("http://www.baidu.com");
       Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_S);
        robot.keyPress(KeyEvent.VK_ENTER);
    }
    @Test
    public void uploadTest(){
        driver.get("file:///C:/selenium_html/selenium_html/index.html");
        driver.findElement(By.id("load")).sendKeys("C:\\201610201852567567");

    }
}
