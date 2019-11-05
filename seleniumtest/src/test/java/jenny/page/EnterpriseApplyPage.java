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
        List<WebElement> contracts0goodsIdList = this.findElements(By.cssSelector("ul.el-scrollbar__view.el-select-dropdown__list > li"));
        contracts0goodsIdList.forEach(gid -> {
            if(gid.getText().equals("test2")) {
                System.out.println("业务方案");
                gid.click();
                return;
            }
        });
        WebElement contracts0settleType =  this.findElement(By.cssSelector("label[for='contracts.0.settleType'] + div > div"));
        contracts0settleType.click();

        List<WebElement> contracts0settleTypeList = this.findElements(By.cssSelector("ul.el-scrollbar__view.el-select-dropdown__list > li"));

        contracts0settleTypeList.forEach(gid -> {
            if(gid.getText().equals("日结")) {
                gid.click();
                return;
            }
        });


        List<WebElement> contracts0channelTypeList =  this.findElements(By.cssSelector("label[for='contracts.0.channelTypeList'] + div > div > label"));
        contracts0channelTypeList.forEach((type -> {
            if("银行".equals(type.getText())){
                System.out.println("选择银行卡");
                type.click();
                return;
            }
        }));

        List<WebElement> feeList = this.findElements(By.cssSelector("label[for='contracts[0].serviceFeeContent.fixFee'] + div > div"));

        feeList.forEach(fee -> {
            WebElement feeType = fee.findElement(By.cssSelector("div > div"));
            if(feeType.getText().contains("固定比例收费")){
                System.out.println("选择实发金额");
                fee.findElement(By.cssSelector("input[type='text']")).sendKeys("10");
            }

        });


        List<WebElement> contracts0serviceTypeList =  this.findElements(By.cssSelector("label[for='contracts.0.serviceTypeList'] + div > div > label"));
        for(WebElement ele : contracts0serviceTypeList){
            if(ele.getText().equals("旅游服务") || ele.getText().equals("咨询")){
                ele.click();
            }
        }


        List<WebElement> servicePosList = this.findElements(By.cssSelector("table.post-table > tr > td > button")); //label[for='contracts[0].servicePosList'] + div > div > table.post-table > tr > td > button
        servicePosList.forEach( servicePos -> {
            if(servicePos.getText().equals("添加岗位")){
                System.out.print("添加岗位");
                servicePos.click();
                WebElement posName = this.findElement(By.cssSelector("label[for='posName'] + div > div > input"));
                posName.sendKeys("旅游,岗位名称");
                WebElement description = this.findElement(By.cssSelector("label[for='description'] + div > div > textarea"));
                description.sendKeys("岗位描述");
                WebElement performance = this.findElement(By.cssSelector("label[for='performance'] + div > div > textarea"));
                performance.sendKeys("绩效规则");
                WebElement saveButton = this.findElement(By.cssSelector("div.el-dialog__footer > div > button.el-button.el-button--primary.el-button--small"));
                saveButton.click();
                forceWait(1000);
            }
        });

        WebElement nextBut = this.findElement(By.cssSelector(".el-button--success"));
        nextBut.click();
        return this;
    }

    public EnterpriseApplyPage contractForAttacth() {
        System.out.println("选择合同附加条款:");
        forceWait(1000);
        List<WebElement> payAndInvoiceSameList = this.findElements(By.cssSelector("label[for='payAndInvoiceSame'] + div > div > div[role='radiogroup'] > label"));
        payAndInvoiceSameList.get(0).click();
        WebElement nextBut = this.findElement(By.cssSelector(".el-button--success"));
        nextBut.click();
        return this;
    }


}
