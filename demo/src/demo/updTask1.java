package demo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class updTask1 {

	 public static void main(String[] args) {

	       
	        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");

	       
	        WebDriver driver = new ChromeDriver();

	        
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	        try {
	            
	            driver.get("https://www.google.com");

	            
	            WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));

	            
	            searchBox.sendKeys("QA" + Keys.ENTER);

	            
	            wait.until(ExpectedConditions.titleContains("QA"));

	            
	            if (driver.getTitle().contains("QA")) {
	                System.out.println("PASS");
	            } else {
	                System.err.println("FAIL");
	            } 
	            Thread.sleep(25000);
	        }
	        catch (InterruptedException e) {
	                e.printStackTrace();
	        } finally {
	           
	            driver.quit();
	        }
	    }
	}