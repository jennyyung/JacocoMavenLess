package jenny.page.enterpriseapply;

import jenny.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by macpro on 2019/11/9.
 */
public class EsignPage extends BasePage {
    List<WebElement> isFromOutAppRadio;
    List<WebElement> jobMatchRadio;
    List<WebElement> signFormRadio;
    List<WebElement> passportTypeRadio;
    List<WebElement> signModeRadio;

    WebElement nextBut;

    public EsignPage(){
        forceWait(1000);
        nextBut = this.findElement(By.cssSelector(".el-button.el-button--primary"),10);

        isFromOutAppRadio = this.findElements(By.cssSelector("label[for='isFromOutApp'] + div > label"));

        jobMatchRadio = this.findElements(By.cssSelector("label[for='jobMatch'] + div > div > label"));

    }


    public void enterEsign(String fromOutApp,String signForm,String passportType,String signMode,String jobMatch){
        isFromOutAppRadio.forEach(radio -> {
            if(radio.getText().equals(fromOutApp)){
                radio.click();
                if("否".equals(fromOutApp)){
                    signFormRadio = this.findElements(By.cssSelector("label[for='signForm'] + div > label"));
                    passportTypeRadio = this.findElements(By.cssSelector("label[for='passportType'] + div > label"));
                    signModeRadio = this.findElements(By.cssSelector("label[for='signMode'] + div > div > label"));
                    signFormRadio.forEach(signFormItem -> {
                        if(signFormItem.getText().contains(signForm)){
                            signFormItem.click();
                        }
                    });
                    if(passportType!=null && !passportType.trim().equals("")){
                        passportTypeRadio.forEach(passportTypeItem ->{
                            if(passportTypeItem.getText().contains(signMode)){
                                passportTypeItem.click();
                            }
                        });
                    }
                    signModeRadio.forEach(signModeItem ->{
                        if(signModeItem.getText().contains(signMode)){
                            signModeItem.click();
                        }
                    });
                }
                return;
            }
        });

        jobMatchRadio.forEach(radio -> {
            if(radio.getText().equals(jobMatch)){
                radio.click();
                return;
            }
        });
        nextBut.click();

    }


}
