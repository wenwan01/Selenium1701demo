package yvonneday1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017/6/4 0004.
 */
public class ClosedBrowsertest {
    @Test
    public void closedChrome() throws InterruptedException {
       //设置谷歌驱动路径
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\Desktop\\chromedriver.exe");
        //实例化谷歌驱动
        WebDriver driver = new ChromeDriver();
       Thread.sleep(3000);
        driver.quit();

    }
}
