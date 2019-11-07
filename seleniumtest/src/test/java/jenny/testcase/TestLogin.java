package jenny.testcase;

import jenny.page.EnterpriseApplyPage;
import jenny.page.LoginPage;
import jenny.page.MainPage;
import jenny.page.enterpriseapply.CompanyInfo;
import jenny.page.enterpriseapply.ContractOptions;
import jenny.page.enterpriseapply.SaleInfoPage;
import jenny.page.enterpriseapply.ServiceCompany;
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
        SaleInfoPage contractForSaleInfoPage = new SaleInfoPage();
        contractForSaleInfoPage.enterSaleInfo("1000","10","10","20",null);

        ContractOptions options = new ContractOptions();
        options.enterOptions("10019","电子商务","网商");

        CompanyInfo companyInfo = new CompanyInfo();
        companyInfo.enterCompanyInfo("非直接用工企业","测试UI自动化企业","18911223389","18911223389@qq.com","增值税专用发票",true);

        ServiceCompany serviceCompany = new ServiceCompany();
        serviceCompany.enterServiceCompany("广州攻城狮服务公司");
        serviceCompany.enterServiceCompany("接口测试服务公司");
        /*enterpriseApplyPage.addContract()
                .contractForSaleInfo()
                .contractForOptions("10019","电子商务")
                .contractForCompanyInfo("10")
                .contractForServiceCompany("广州攻城狮服务公司").contractForAttacth()
        .contractForEsign();*/

//        assertThat();
    }

    @Test
    public void testAdd2(){
        main.getMenu("销售管理","企业入驻申请");
        enterpriseApplyPage = new EnterpriseApplyPage();
        enterpriseApplyPage.addContract();
        SaleInfoPage contractForSaleInfoPage = new SaleInfoPage();
        contractForSaleInfoPage.enterSaleInfo("10000","35","20","30","jenny");

        ContractOptions options = new ContractOptions();
        options.enterOptions("10019","技术服务","录制");
        /*enterpriseApplyPage.addContract()
                .contractForSaleInfo()
                .contractForOptions("10019","电子商务")
                .contractForCompanyInfo("10")
                .contractForServiceCompany("广州攻城狮服务公司").contractForAttacth()
        .contractForEsign();*/

//        assertThat();
    }
}
