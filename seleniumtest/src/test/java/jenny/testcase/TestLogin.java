package jenny.testcase;

import jenny.page.EnterpriseApplyPage;
import jenny.page.LoginPage;
import jenny.page.MainPage;
import org.junit.BeforeClass;
import org.junit.Test;

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
        enterpriseApplyPage = new EnterpriseApplyPage();

    }

    public static void start(){
        String name = "18706875626";
        String pwd = "123456";
        app.login(name,pwd);
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
        enterpriseApplyPage.addContract()
                .contractForSaleInfo()
                .contractForOptions("10019","电子商务")
                .contractForCompanyInfo("10")
                .contractForServiceCompany();

//        assertThat();
    }
}
