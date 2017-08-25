package yvonneday2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017/6/26 0026.
 */
public class WindowSelectTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testWin() throws InterruptedException {
        driver.get("file:///C:/selenium_html/selenium_html/index.html");
        driver.findElement(new By.ByLinkText("Open new window")).click();
        Thread.sleep(3000);
        String handle1 = driver.getWindowHandle();
        for(String handles : driver.getWindowHandles()){
            if(handles.equals(handle1)){
                continue;
            }else{
                driver.switchTo().window(handles);
            }
        }

        driver.findElement(By.linkText("baidu")).click();
    }
}
