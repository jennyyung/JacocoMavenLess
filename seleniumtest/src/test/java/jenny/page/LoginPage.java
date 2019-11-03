package jenny.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by macpro on 2019/11/3.
 */
public class LoginPage extends BasePage {

    public LoginPage login(String name, String pwd){
        String url="https://openadmintest92.aiyuangong.com/";
        //安装chromedriver:https://github.com/SeleniumHQ/selenium/wiki/ChromeDriver
        //  System.setProperty ("webdriver.chrome.driver", "");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().maximize();
        WebElement nameEle = this.findElement(By.xpath("//*[@id=\"container\"]/div[1]/div[2]/form/div[2]/div/div/input"));
        WebElement pwdEle = this.findElement(By.xpath("//*[@id=\"container\"]/div[1]/div[2]/form/div[3]/div/div/input"));
        nameEle.sendKeys(name);
        pwdEle.sendKeys(pwd);
        WebElement loginEle = this.findElement(By.xpath("//*[@id=\"container\"]/div[1]/div[2]/form/div[4]/div/button"));
        loginEle.click();
        return this;
    }
}
