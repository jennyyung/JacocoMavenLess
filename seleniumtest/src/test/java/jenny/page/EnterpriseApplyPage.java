package jenny.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by macpro on 2019/11/2.
 */
public class EnterpriseApplyPage extends BasePage{

    public EnterpriseApplyPage addContract(){
        forceWait();
        List<WebElement> buttons = this.findElements(By.tagName("button"),10);
        System.out.println("buttons size:"+buttons.size());
        for(WebElement button : buttons){
            if("创建合同".equals(button.getText())){
                button.click();
                break;
            }
        }
        return this;
    }

    public void supplementContract(){

    }

    public void changeContract(){

    }

    public EnterpriseApplyPage contractForSaleInfo(){
        System.out.println("销售信息:");
        this.forceWait(1500);
        List<WebElement> allInputs = this.findElements(By.tagName("input"),10);
        System.out.println("inputs size:"+allInputs.size());
        for(WebElement inputEle : allInputs){
            if (inputEle.getAttribute("type").equals("text")){
                if(inputEle.getText().trim().equals("")){
                    inputEle.sendKeys("10");
                }
            }
        }

        List<WebElement> radioInputs = this.findElements(By.cssSelector(".el-radio__input"),10);
        for(WebElement radioInput : radioInputs){
            System.out.println(radioInput.findElement(By.tagName("input")));
            WebElement radio = radioInput.findElement(By.tagName("input"));
            if(radio.getAttribute("value").equals("10")){
                radioInput.click();
            }
        }

        WebElement nextBut = this.findElement(By.cssSelector(".el-button--success"));
        nextBut.click();
        return this;
    }

    public EnterpriseApplyPage contractForOptions(String contractTpl,String contractType){
        System.out.println("合同选项:");
        forceWait();
        List<WebElement> formItems = this.findElements(By.cssSelector(".el-form-item"));
        for(WebElement formItem : formItems){
            WebElement content = formItem.findElement(By.cssSelector(".el-form-item__content"));

            WebElement label = formItem.findElement(By.tagName("label"));
            if(label.getAttribute("for").equals("contractTplId")){ //contractTplId   contractType
                System.out.println("contractTplId");
                formItem.click();

                List<WebElement> webElements = this.findElements(By
                        .cssSelector(".el-scrollbar__view.el-select-dropdown__list"));
                List<WebElement> liEles = webElements.get(1).findElements(By.cssSelector("li>span"));
                System.out.println(liEles.size());
                liEles.forEach(li -> {
                    System.out.println(li.getText());
                    if(li.getText().contains(contractTpl)) {
                        li.click();
                    }
                });

            } else if(label.getAttribute("for").equals("contractType")){ //contractTplId   contractType
                System.out.println("contractTypecontractTypecontractTypecontractType");
                formItem.click();
                List<WebElement> webElements2 = this.findElements(By
                        .cssSelector(".el-scrollbar__view.el-select-dropdown__list"));
                List<WebElement> liEles = webElements2.get(1).findElements(By.cssSelector("li>span"));
                System.out.println(liEles.size());
                liEles.forEach(li -> {
                    System.out.println(li.getText());
                    if(li.getText().contains(contractType)) {
                        li.click();
                    }
                });
            }else if(label.getAttribute("for").equals("customIndustry")){
                WebElement input = formItem.findElement(By.tagName("input"));
                input.sendKeys("网商");
            } else{
                formItem.click();
                List<WebElement> dateTables = this.findElements(By.cssSelector(".el-date-table"));
                String css = "tr td:first-child";
                System.out.println("clicking");
                waitClickable(By.cssSelector(css),10);
                dateTables.forEach(dateTable -> {
                    WebElement startDate = dateTable.findElement(By.cssSelector(css));
                    startDate.click();
                    //startDate.click();
                    forceWait(50);
                });
            }
        }
        WebElement nextBut = this.findElement(By.cssSelector(".el-button--success"));
        nextBut.click();
        return this;
    }

    public EnterpriseApplyPage contractForCompanyInfo(String customNatureType){
        System.out.println("企业合同:");
        forceWait();

        List<WebElement> customNatureLabels =  this.findElements(By.cssSelector("label[for=customNature] + div > label"),10);
        // WebElement customNature =  this.findElement(By.cssSelector("label[for=customNature] + div input[value='20']")); 可以直接定位到元素,但不可点击
//        WebElement label = customNatureLabels.get(0).findElement(By.cssSelector("input[value='20']"));
        customNatureLabels.get(0).click();
        customNatureLabels.forEach(label -> {
            System.out.println("in");
            if("10".equals(customNatureType)){
                try {
                    label.findElement(By.cssSelector("input[value='10']"));
                    label.click();
                }catch (Exception e){

                }

            }else  if("20".equals(customNatureType)){
                try {
                    label.findElement(By.cssSelector("input[value='20']"));
                    label.click();
                }catch (Exception e){

                }
            }
        });

        List<WebElement> textList = this.findElements(By.cssSelector("input[type=text]"));
        textList.forEach(text -> {
            text.sendKeys("123");
        });

        WebElement customCollectorPhone =  this.findElement(By.cssSelector("label[for=customCollectorPhone] + div input[type=text]"),10);
        customCollectorPhone.sendKeys("18912345689");

        WebElement customMail1 =  this.findElement(By.cssSelector("label[for=customMail1] + div input[type=text]"),10);
        customMail1.sendKeys("18912345689@qq.com");

        WebElement customTaxIdcd =  this.findElement(By.cssSelector("label[for=customTaxIdcd] + div input[type=text]"),10);
        customTaxIdcd.sendKeys("45678910007777575");

        WebElement invoiceType =  this.findElement(By.cssSelector("label[for=invoiceType] + div div[class=el-select]"),10);
        invoiceType.click();

       // WebElement  invoiceTypeSelector = this.findElement(By.cssSelector("ul > li:nth-child(1)"));
        WebElement  invoiceTypeSelector = this.findElement(By.cssSelector("ul.el-scrollbar__view.el-select-dropdown__list > li:nth-child(3)"));
       // WebElement  invoiceTypeSelector = this.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/ul/li[2]"));
        invoiceTypeSelector.click();
        //WebElement companyNameSelector = this.findElement(By.cssSelector("input[placeholder='请选择']"));
       // companyNameSelector.click();

        WebElement nextBut = this.findElement(By.cssSelector(".el-button--success"));
        nextBut.click();
        return this;
    }

    public EnterpriseApplyPage contractForServiceCompany(String serviceCompany){
        System.out.println("选择落地:");
        forceWait();
        WebElement addBut = this.findElement(By.cssSelector(".el-button.el-button--primary.el-button--small"));
        addBut.click();

        WebElement serviceCompanySelector = this.findElement(By.cssSelector("div.el-form-item__content > div.el-select"));
        serviceCompanySelector.click();

       // WebElement input = this.findElement(By.cssSelector("div.el-form-item__content > div.el-select input"));
       // input.sendKeys("攻城狮");

        //WebElement  serviceCompany = this.findElement(By.cssSelector("ul.el-scrollbar__view.el-select-dropdown__list > li:nth-child(1)"));
        //serviceCompany.click();
        List<WebElement> serviceCompanyList = this.findElements(By.cssSelector("ul.el-scrollbar__view.el-select-dropdown__list > li"));
        serviceCompanyList.forEach(sc -> {
            if(sc.getText().equals(serviceCompany)){
                sc.click();
                return;
            }
        });
        forceWait();
        WebElement selectBut = this.findElement(By.cssSelector("div.el-form-item__content > .el-button.el-button--primary"));
        selectBut.click();

        forceWait(2000);
        WebElement contracts0goodsId =  this.findElement(By.cssSelector("label[for='contracts.0.goodsId'] + div > div"));
        contracts0goodsId.click();

        WebElement contracts0settleType =  this.findElement(By.cssSelector("label[for='contracts.0.settleType'] + div > div"));
        contracts0settleType.click();

        List<WebElement> contracts0goodsIdList = this.findElements(By.cssSelector("ul.el-scrollbar__view.el-select-dropdown__list > li"));
        contracts0goodsIdList.forEach(gid -> {
            if(gid.getText().equals("方案一")) {
                gid.click();
                return;
            }
        });

        contracts0goodsIdList.forEach(gid -> {
            if(gid.getText().equals("日结")) {
                gid.click();
                return;
            }
        });

        //WebElement nextBut = this.findElement(By.cssSelector(".el-button--success"));
        //nextBut.click();
        return this;
    }


}
