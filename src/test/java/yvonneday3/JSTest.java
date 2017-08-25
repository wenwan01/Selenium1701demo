package yvonneday3;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017/7/5 0005.
 */
public class JSTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void exJS(){
        driver.get("http://www.baidu.com/");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("");
    }
}
