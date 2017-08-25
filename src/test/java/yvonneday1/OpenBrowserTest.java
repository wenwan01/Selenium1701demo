package yvonneday1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017/6/4 0004.
 */
public class OpenBrowserTest {
    @Test
    public void openFF(){
//火狐必须默认安装C:\Program Files (x86)
        WebDriver webDriver = new FirefoxDriver();
    }

    @Test
    public void openFF2(){
        System.setProperty("webdriver.firefox.bin","C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        WebDriver webDriver = new FirefoxDriver();
    }
   @Test
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\Desktop\\chromedriver.exe");
       WebDriver webDriver = new ChromeDriver();
   }

    @Test
    public void openIE(){
        System.setProperty("webdriver.ie.driver","C:\\Users\\Administrator\\Desktop\\IEDriverServer.exe");
        WebDriver webDriver = new InternetExplorerDriver();
    }
}
