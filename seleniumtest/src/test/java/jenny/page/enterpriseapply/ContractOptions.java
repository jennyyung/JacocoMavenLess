package jenny.page.enterpriseapply;

import jenny.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by macpro on 2019/11/7.
 */
public class ContractOptions extends BasePage {
    WebElement contractTplOption;
    WebElement contractTypeOption;
    WebElement customIndustryText;
    WebElement contractStartDateTab;
    WebElement nextBut;

    public ContractOptions(){
        forceWait();
        contractTplOption = this.findElement(By.cssSelector("label[for='contractTplId']+div>div"));
        contractTypeOption = this.findElement(By.cssSelector("label[for='contractType']+div>div"));
        customIndustryText = this.findElement(By.cssSelector("label[for='customIndustry']+div>div>input"));
        contractStartDateTab = this.findElement(By.cssSelector("label[for='contractStartDate']+div>div"));
        nextBut = this.findElement(By.cssSelector(".el-button--success"),15);
    }

    public ContractOptions enterOptions(String contractTpl, String contractType, String customIndustry){
        contractTplOption.click();
        getOptions(contractTpl);
        contractTypeOption.click();
        getOptions(contractType);
        customIndustryText.sendKeys(customIndustry);
        contractStartDateTab.click();
        selectDate();
        nextBut.click();
        return this;
    }

    public void getOptions(String value){
        List<WebElement> webElements = this.findElements(By
                .cssSelector(".el-scrollbar__view.el-select-dropdown__list"));
        List<WebElement> liEles = webElements.get(1).findElements(By.cssSelector("li>span"));
        liEles.forEach(li -> {
            if(li.getText().contains(value)) {
                li.click();
            }
        });
    }

    public void selectDate(){
        List<WebElement> dateTables = this.findElements(By.cssSelector(".el-date-table"));
        String css = "tr td:first-child";
        waitClickable(By.cssSelector(css),10);
        dateTables.forEach(dateTable -> {
            WebElement startDate = dateTable.findElement(By.cssSelector(css));
            startDate.click();
            forceWait(50);
        });
    }

}
