package jenny.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by macpro on 2019/10/31.
 */
public class MainPage extends BasePage {

    public MainPage getMenu(String mainMenu,String subMenu){
        List<WebElement> menus = this.findElements(By.xpath("//*[@id=\"test\"]/div"));
        for(WebElement webElement : menus){
            System.out.println("menu............."+ webElement.getText());
            //webElement.click();
            if(mainMenu.equals(webElement.getText())){
                System.out.println(mainMenu+ " menu click.............");
                webElement.click();
                break;
            }
        }

       /* List<WebElement> subMenus = this.findElements(By.xpath("/html/body/div[2]/ul/li"));*/

        List<WebElement> subMenus = this.findElements(By.cssSelector("li[role=menuitem]"));
        for(WebElement lb : subMenus){
            System.out.println("submenu............."+ lb.getText());
            if (lb.getText().equals(subMenu)){
                System.out.println(subMenu+ " enter.............");
                lb.click();
                break;
            }
        }
        return this;

    }


}
