import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginPageTest extends TestBase{
    HomePage homePage;
    LoginPage loginPage;
    public LoginPageTest() throws IOException {
        super();
    }
    @BeforeMethod
    public void setup() throws IOException {
        initialization();
        loginPage=new LoginPage();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void LoginPageTitleTest()
    {
    String title= loginPage.validateLoginPageTitle();
        Assert.assertEquals(title,"Cogmento CRM");
    }
    @Test
    public void LoginTest() throws IOException {
        homePage= loginPage.login(prop.getProperty("user"), prop.getProperty("password"));
    }
}
