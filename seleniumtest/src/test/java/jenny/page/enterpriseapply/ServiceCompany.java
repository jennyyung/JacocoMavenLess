package jenny.page.enterpriseapply;

import jenny.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by macpro on 2019/11/7.
 */
public class ServiceCompany extends BasePage {
    WebElement addButton;
    WebElement serviceCompanySelector;
    WebElement selectButton;

    public ServiceCompany(){
        forceWait();
        addButton = this.findElement(By.cssSelector(".el-button.el-button--primary.el-button--small"));

    }

    public void enterServiceCompany(String serviceCompany){
        addButton.click();
        serviceCompanySelector = this.findElement(By.cssSelector("div.el-form-item__content > div.el-select"));
        selectButton = this.findElement(By.cssSelector("div.el-form-item__content > .el-button.el-button--primary"));
        serviceCompanySelector.click();
        selectServiceCompany(serviceCompany);
        forceWait();
        selectButton.click();

    }

    public void selectServiceCompany(String name){
        List<WebElement> serviceCompanyList = this.findElements(By.cssSelector("ul.el-scrollbar__view.el-select-dropdown__list > li"));
        serviceCompanyList.forEach(sc -> {
            if(sc.getText().equals(name)){
                sc.click();
                return;
            }
        });
    }

}
