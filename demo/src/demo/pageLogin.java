package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class pageLogin {
    private WebDriver driver;
    private WebDriverWait wait;

    
    private By emailId = By.id("email");
    private By passwordId = By.id("pass");
    private By loginButtonId = By.id("loginbutton");
    private By navigationRole = By.cssSelector("[role='navigation']");

    public pageLogin(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {
        driver.get("https://www.facebook.com");
    }

    public void setEmail(String email) {
        driver.findElement(emailId).sendKeys(email);
    }

    public void setPassword(String password) {
        driver.findElement(passwordId).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButtonId).click();
    }

    public boolean isFound() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(navigationRole));
        return driver.findElement(navigationRole).isDisplayed();
    }
}
