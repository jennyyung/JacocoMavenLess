package jenny.page.enterpriseapply;

import jenny.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by macpro on 2019/11/6.
 */
public class SaleInfoPage extends BasePage {
    WebElement expectedMonthlyFlowText;
    WebElement expectedProportionText;
    WebElement contractPerson;
    WebElement contractEmail;
    WebElement contractTel;
    WebElement contractAddr;
    List<WebElement> originalTypeRadio;
    List<WebElement> originalRadio;
    WebElement agentCompanyText;
    WebElement nextBut;

    public SaleInfoPage(){
        forceWait();
        expectedMonthlyFlowText = this.findElement(By.cssSelector("label[for=expectedMonthlyFlow] + div > div > input"));
        expectedProportionText = this.findElement(By.cssSelector("label[for=expectedProportion] + div > div > input"));
        originalTypeRadio = this.findElements(By.cssSelector("label[for=originalType] + div > label"));
        originalRadio = this.findElements(By.cssSelector("label[for=original] + div > label"));
        nextBut = this.findElement(By.cssSelector(".el-button--success"));
    }

    public SaleInfoPage enterSaleInfo(String expectedMonthlyFlow, String expectedProportion, String originalType, String original, String agent){
        expectedMonthlyFlowText.sendKeys(expectedMonthlyFlow);
        expectedProportionText.sendKeys(expectedProportion);
        originalTypeRadio.forEach(item -> {
            WebElement radio = item.findElement(By.tagName("input"));
            if(radio.getAttribute("value").equals(originalType)){
                item.click();
            }
        });
        originalRadio.forEach(item -> {
            WebElement radio = item.findElement(By.tagName("input"));
            if(radio.getAttribute("value").equals(original)){
                item.click();
            }
        });

        if(agent!=null && !"".equals(agent.trim())){
            agentCompanyText = this.findElement(By.cssSelector("label[for=agentCompanyId] + div > div > div"));
            agentCompanyText.click();
            getAgents(agent);
        }

        nextBut.click();
        return this;
    }

    public void getAgents(String value){
        List<WebElement> webElements = this.findElements(By
                .cssSelector(".el-scrollbar__view.el-select-dropdown__list > li "));
        webElements.forEach(li -> {
            if(li.getText().contains(value)) {
                li.click();
            }
        });
    }

}
