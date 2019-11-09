package jenny.page.enterpriseapply;

import jenny.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by macpro on 2019/11/9.
 */
public class AttacthPage extends BasePage {
    WebElement vciPayTypeText;
    WebElement settleDayText;
    List<WebElement> payAndInvoiceSameRadio;
    List<WebElement> customCompanyUnderTypeRadio;
    WebElement nextBut;

    public AttacthPage(){
        forceWait(1000);
        vciPayTypeText = this.findElement(By.cssSelector("label[for='vciPayType'] + div > div"));
        payAndInvoiceSameRadio = this.findElements(By.cssSelector("label[for='payAndInvoiceSame'] + div > div > div[role='radiogroup'] > label"));
        nextBut = this.findElement(By.cssSelector(".el-button--success"),10);

    }

    public AttacthPage enterAttatch(String vciPayType,String payAndInvoiceSame,String settleDay,String subCompanyType){
        //payAndInvoiceSameRadio.get(0).click();
        vciPayTypeText.click();
        selectVciPayType(vciPayType);
        if(settleDay!=null && !settleDay.trim().equals("")) {
            settleDayText = this.findElement(By.cssSelector("input[type=text]:nth-child(2)"), 10);
            settleDayText.sendKeys(settleDay);
        }

        payAndInvoiceSameRadio.forEach(item -> {
            if(item.getText().equals(payAndInvoiceSame)){
                item.click();
                if(item.getText().equals("否")){
                    customCompanyUnderTypeRadio = this.findElements(By.cssSelector("label[for='customCompanyUnderType'] + div > div > div[role='radiogroup'] > label"),10);
                    customCompanyUnderTypeRadio.forEach(subCompany ->{
                        if(subCompany.getText().equals(subCompanyType)){
                            subCompany.click();
                        }
                    });
                }
                return;
            }
        });

        nextBut.click();
        return this;
    }

    public void selectVciPayType(String name){
        List<WebElement> serviceCompanyList = this.findElements(By.cssSelector("ul.el-scrollbar__view.el-select-dropdown__list > li"));
        serviceCompanyList.forEach(sc -> {
            if(sc.getText().equals(name)){
                sc.click();
                return;
            }
        });
    }
}
