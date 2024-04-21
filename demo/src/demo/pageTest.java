package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;

public class pageTest {
    private WebDriver driver;
    private pageLogin login;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        login = new pageLogin(driver);
        login.open();
    }

    @Test
    public void successfulLoginTest() {
        login.setEmail("doaawaqas16.2001@gmail.com");
        login.setPassword("password12345");
        login.clickLogin();
        Assert.assertTrue(facebookLoginPage.isFound(), "Login Failed");
    }

    @Test
    public void failedLoginTest() {
    	login.setEmail("doaawaqas16.2001@gmail.com");
    	login.setPassword("12116175");
    	login.clickLogin();
        Assert.assertTrue(facebookLoginPage.isFound(), "Login operates wrong");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
