package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class HomePage extends TestBase {
    @FindBy(xpath = "//div[@class='header item']")
    WebElement crmLogo;
    @FindBy(xpath="//b[text()='Xpertalk']")
    WebElement accName;
    @FindBy(xpath ="//i[@class='users icon']")
    WebElement contactPage;

    public HomePage() throws IOException {
        PageFactory.initElements(driver,this);
    }

    public String verifyHomePageTitle()
    {
        return driver.getTitle();
    }
    public Boolean verifyAccName()
    {
        return accName.isDisplayed();
    }
    public ContactsPage clickonContactsPage()
    {
         contactPage.click();
         return new ContactsPage();
    }


}
