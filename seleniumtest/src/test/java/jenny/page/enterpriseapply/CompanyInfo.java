package jenny.page.enterpriseapply;

import jenny.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by macpro on 2019/11/7.
 */
public class CompanyInfo extends BasePage {
    List<WebElement> customNatureRadio;
    WebElement customerNameText;
    WebElement customCollectorPhoneText;
    WebElement customMail1Text;
    WebElement customTaxIdcdText;
    WebElement invoiceTypeSelect;
    WebElement displayInvoiceTypeCheckbox;
    WebElement nextBut;

    public CompanyInfo(){
        forceWait();
        customNatureRadio = this.findElements(By.cssSelector("label[for=customNature] + div > label"));
        customerNameText = this.findElement(By.cssSelector("label[for=customerName] + div input"));
        customCollectorPhoneText = this.findElement(By.cssSelector("label[for=customCollectorPhone] + div input[type=text]"));
        customMail1Text = this.findElement(By.cssSelector("label[for=customMail1] + div input[type=text]"));
        customTaxIdcdText = this.findElement(By.cssSelector("label[for=customTaxIdcd] + div input[type=text]"));
        invoiceTypeSelect = this.findElement(By.cssSelector("label[for=invoiceType] + div input[type=text]"));
        displayInvoiceTypeCheckbox = this.findElement(By.cssSelector("label[for=invoiceType] + div label[role=checkbox]"));
        nextBut = this.findElement(By.cssSelector(".el-button--success"),10);
    }

    public CompanyInfo enterCompanyInfo(String customNature,String customerName,String customCollectorPhone,String customMail,String invoiceType,boolean isDisplayInvoiceType){
        customNatureRadio.forEach(item -> {
            if(item.getText().equals("直接用工企业")){
                item.click();
            }else if(item.getText().equals("非直接用工企业")){
                item.click();
            }
        });

        List<WebElement> textList = this.findElements(By.cssSelector("input[type=text]"));
        textList.forEach(text -> {
            text.sendKeys("123");
        });

        customerNameText.clear();
        customerNameText.sendKeys(customerName);
        customCollectorPhoneText.sendKeys(customCollectorPhone);
        customMail1Text.sendKeys(customMail);
        customTaxIdcdText.sendKeys("456789101123");

        invoiceTypeSelect.click();
        selectInvoiceType(invoiceType);
        if(isDisplayInvoiceType){
            displayInvoiceTypeCheckbox.click();
        }

        nextBut.click();
        return this;
    }


    public void selectInvoiceType(String invoiceType){
        List<WebElement> invoiceTypeList = this.findElements(By.cssSelector("ul.el-scrollbar__view.el-select-dropdown__list > li"));
        invoiceTypeList.forEach(item -> {
            if(item.getText().equals(invoiceType)){
                item.click();
            }
        });
    }
}
