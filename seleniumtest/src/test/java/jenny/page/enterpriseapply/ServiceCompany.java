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

    WebElement contractForm;

    public ServiceCompany(){
        //"form.contractForm div.widget-box:nth-child(2) label[for='contracts.0.goodsId'] + div > div"
        //nth-child
    }

    public void enterServiceCompany(List<String> serviceCompanyList){
        //TODO
        int index = 0;
        serviceCompanyList.forEach(serviceCompany ->{
            forceWait();
            addButton = this.findElement(By.cssSelector(".el-button.el-button--primary.el-button--small"));
            addButton.click();
            forceWait();
            serviceCompanySelector = this.findElement(By.cssSelector("div.el-form-item__content > div.el-select"));

            serviceCompanySelector.click();
            selectServiceCompany(serviceCompany);

            selectButton = this.findElement(By.cssSelector("div.el-form-item__content > .el-button.el-button--primary"),10);
            selectButton.click();
            forceWait(2000);
            String formSelector = "form.contractForm div.widget-box:nth-child("+ (index+2) +")";
            contractForm = this.findElement(By.cssSelector(formSelector));

            String goodsIdSelector = formSelector+" label[for='contracts."+index+".goodsId'] + div > div";
            WebElement goodsId = this.findElement(By.cssSelector(goodsIdSelector));
            goodsId.click();
            List<WebElement> contracts0goodsIdList = this.findElements(By.cssSelector("ul.el-scrollbar__view.el-select-dropdown__list > li"));
            contracts0goodsIdList.forEach(gid -> {
                if(gid.getText().equals("test2")) {
                    gid.click();
                    return;
                }
            });

            WebElement settleType = this.findElement(By.cssSelector(formSelector+" label[for='contracts."+index+".settleType'] + div > div"));
            settleType.click();
            List<WebElement> contracts0settleTypeList = this.findElements(By.cssSelector("ul.el-scrollbar__view.el-select-dropdown__list > li"));
            contracts0settleTypeList.forEach(gid -> {
                if(gid.getText().equals("日结")) {
                    System.out.println("日结");
                    gid.click();
                    return;
                }
            });


            List<WebElement> contracts0channelTypeList =  this.findElements(By.cssSelector(formSelector+" label[for='contracts."+index+".channelTypeList'] + div > div > label"));
            contracts0channelTypeList.forEach((type -> {
                if("银行".equals(type.getText())){
                    System.out.println("选择银行卡");
                    type.click();
                    return;
                }
            }));

            List<WebElement> feeList = this.findElements(By.cssSelector(formSelector+" label[for='contracts["+index+"].serviceFeeContent.fixFee'] + div > div"));

            feeList.forEach(fee -> {
                WebElement feeType = fee.findElement(By.cssSelector("div > div"));
                if(feeType.getText().contains("固定比例收费")){
                    System.out.println("选择实发金额");
                    fee.findElement(By.cssSelector("input[type='text']")).sendKeys("10");
                }

            });


            List<WebElement> contracts0serviceTypeList =  this.findElements(By.cssSelector(formSelector+" label[for='contracts."+index+".serviceTypeList'] + div > div > label"));
            for(WebElement ele : contracts0serviceTypeList){
                if(ele.getText().equals("旅游服务") || ele.getText().equals("咨询")){
                    ele.click();
                }
            }

        });

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
