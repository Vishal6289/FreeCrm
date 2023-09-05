package com.crm.qa.pages;
import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginPage extends TestBase{

    @FindBy(xpath = "//input[@name=\"email\"]")
    WebElement username;

    @FindBy(xpath="//input[@name=\"password\"]")
    WebElement password;

    @FindBy(xpath = "//div[text()=\"Login\"]")
    WebElement loginbtn;

    public LoginPage() throws IOException {
        PageFactory.initElements(driver, this);
    }
    public String validateLoginPageTitle()
    {
       return driver.getTitle();
    }
    public HomePage login(String un, String pwd) throws IOException {
      username.sendKeys(un);
      password.sendKeys(pwd);
      loginbtn.click();
      return new HomePage();
    }

}