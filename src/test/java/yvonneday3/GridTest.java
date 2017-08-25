package yvonneday3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2017/7/9 0009.
 */
public class GridTest {
    @Test
    public void gridTest() throws InterruptedException, MalformedURLException {
        //创建一个DesiredCapabilities类型
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        //实例化一个Driver
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.107:4444/wd/hub"),dc);
        driver.get("http://www.baidu.com");
        Thread.sleep(3000);
        driver.quit();
    }
    @DataProvider(name = "data4")
    public Object[][] test1(){
        return new Object[][]{
                {"firefox"},
                {"chrome"} };

    }
    @Test(dataProvider = "data4")
    public void testGrid2(String browser) throws MalformedURLException, InterruptedException {
      DesiredCapabilities dc = null;
    if(browser.equals("firefox")){
        dc = DesiredCapabilities.firefox();
    }else if (browser.equals("chrome")){
        dc = DesiredCapabilities.chrome();
    }else{
        System.out.println("error");
    }
    WebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.107:4444/wd/hub"),dc);
    driver.get("http://www.baidu.com");
    Thread.sleep(3000);
    driver.quit();
    }
}
