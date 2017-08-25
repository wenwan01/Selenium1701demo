package yvonneday3;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017/7/5 0005.
 */
public class PhantomjsTest {
    @Test
    public void pjsTest() throws InterruptedException {
        System.setProperty("phantomjs.binary.path", "C:\\Users\\Administrator\\Desktop\\phantom.exe");
        WebDriver driver = new PhantomJSDriver();
        driver.get("http://www.baidu.com/");
        driver.findElement(By.id("kw")).sendKeys("phantomJS");
        Thread.sleep(3000);
        String a = driver.getTitle();
        System.out.println(a);
        Thread.sleep(5000);
        driver.quit();
    }
}
