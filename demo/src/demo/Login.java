package demo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;

public class Login {
	 private WebDriver driver;
	 private WebDriverWait wait;
	 
	 
	 @BeforeClass
	 public void setUp() {
		 System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");
			
		 driver = new ChromeDriver();
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 driver.get("https://www.facebook.com");
	 }
	 @Test
	    public void successfulLoginTest() {
	        driver.findElement(By.id("email")).sendKeys("doaawaqas16.2001@gmail.com");;
	        driver.findElement(By.id("pass")).sendKeys("password12345");;
	        driver.findElement(By.id("loginbutton")).click();
	        
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[role='navigation']")));

	        Assert.assertTrue(driver.findElement(By.cssSelector("[role='navigation']")).isDisplayed(), "Login Failed");
	    }

	    @Test
	    public void failedLoginTest() {
	    	 driver.findElement(By.id("email")).sendKeys("doaawaqas16.2001@gmail.com");;
		        driver.findElement(By.id("pass")).sendKeys("12116175");;
		        driver.findElement(By.id("loginbutton")).click();


	        // Check for error message
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[role='navigation']")));
	        Assert.assertTrue(driver.findElement(By.cssSelector("[role='navigation']")).isDisplayed(), "Login operates wrong");
	    }

	    @AfterClass
	    public void tearDown() {
	        driver.quit();
	    }
	}

}
