package jenny.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by macpro on 2019/10/31.
 */
public class BasePage {
    public static WebDriver driver;

    public WebElement findElement(By by){
        return findElement(by,0);
    }

    public List<WebElement> findElements(By by){
        System.out.println(by);
        return driver.findElements(by);
    }

    public void implicitlyWait(int timeout){
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }

    public List<WebElement>  findElements(By by, int timeout){
        System.out.println(by);
        if(timeout>0) {
            waitClickable(by, timeout);
            System.out.println("clickable");
        }
        return driver.findElements(by);
    }

    public WebElement findElement(By by, int timeout){
        System.out.println(by);
        if(timeout>0) {
            waitClickable(by, timeout);
            System.out.println("clickable");
        }
        return driver.findElement(by);
    }

    public void waitClickable(By by, int timeout){
        new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(by));
    }

    public void waitClickable(By by){
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(by));
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(by));

    }

    public void quit() throws InterruptedException {
        Thread.sleep(20000);
        driver.quit();
    }

    public void forceWait(){
        forceWait(1000);
    }

    public void forceWait(int timeout){
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
