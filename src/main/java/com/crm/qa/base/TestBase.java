package com.crm.qa.base;

import com.crm.qa.util.util;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


//Parent class
public class TestBase {
    public static Properties prop;
     public static WebDriver driver;

    public TestBase() throws IOException {
         prop=new Properties();
        FileInputStream inputStream=new FileInputStream("D:\\Testing\\FreeCRM\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
        prop.load(inputStream);
    }
    public void initialization()
    {
        String browserName=prop.getProperty("browser");
        if(browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options=new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver=new ChromeDriver(options);
        } else if (browserName.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(util.page_Load_Timeout));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(util.implicit_wait));
        driver.get(prop.getProperty("url"));
    }
}
