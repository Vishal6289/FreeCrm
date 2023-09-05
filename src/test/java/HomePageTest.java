import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageTest extends TestBase {
    public LoginPage loginPage;
    public HomePage homePage;
    public ContactsPage contactsPage;
    public HomePageTest() throws IOException {
    }
    @BeforeMethod
    public void setup() throws IOException {
       initialization();
       loginPage=new LoginPage();
       homePage=loginPage.login(prop.getProperty("user"), prop.getProperty("password"));
    }
    @AfterMethod
    public void tearDown()
    {
     driver.quit();
    }
    @Test
    public void verifyHomePageTitleTest() {
    String homepagetitle=driver.getTitle();
    Assert.assertEquals(homepagetitle,"Cogmento CRM","Home page title did not match");
    }
    @Test
    public void verifyAccNameTest()
    {
        Assert.assertTrue(homePage.verifyAccName());
    }
    @Test
    public void clickOnContactsPageTest()
    {
        contactsPage=homePage.clickonContactsPage();
    }
}
