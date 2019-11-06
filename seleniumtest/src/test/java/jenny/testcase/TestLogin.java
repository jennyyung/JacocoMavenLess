package jenny.testcase;

import jenny.page.EnterpriseApplyPage;
import jenny.page.LoginPage;
import jenny.page.MainPage;
import jenny.page.enterpriseapply.ContractForSaleInfoPage;
import org.junit.BeforeClass;
import org.junit.Test;

import java.net.MalformedURLException;

/**
 * Created by macpro on 2019/10/31.
 */
public class TestLogin {
    public static LoginPage app;
    public static MainPage main;
    public static EnterpriseApplyPage enterpriseApplyPage;

    @BeforeClass
    public static void beforeAll(){
        app=new LoginPage();
        start();
        main = new MainPage();


    }

    public static void start(){
        String name = "18706875626";
        String pwd = "123456";
        try {
            app.login(name,pwd);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
//        assertThat();
    }
    @Test
    public void testMenu(){
        main.getMenu("流水管理","发放流水");
        main.getMenu("资金服务","充值管理");
//        assertThat();
    }

    @Test
    public void testAdd(){
        main.getMenu("销售管理","企业入驻申请");
        enterpriseApplyPage = new EnterpriseApplyPage();
        enterpriseApplyPage.addContract();
        ContractForSaleInfoPage contractForSaleInfoPage = new ContractForSaleInfoPage();

        contractForSaleInfoPage.enterSaleInfo("1000","10","10","20");
        /*enterpriseApplyPage.addContract()
                .contractForSaleInfo()
                .contractForOptions("10019","电子商务")
                .contractForCompanyInfo("10")
                .contractForServiceCompany("广州攻城狮服务公司").contractForAttacth()
        .contractForEsign();*/

//        assertThat();
    }
}
