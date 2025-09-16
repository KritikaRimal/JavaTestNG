package seleniumCodes;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment_2 {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://demoblaze.com/");

        try {
            // Open login modal
            driver.findElement(By.id("login2")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));

            // Enter correct credentials
            driver.findElement(By.id("loginusername")).clear();
            driver.findElement(By.id("loginusername")).sendKeys("hello"); // your username
            driver.findElement(By.id("loginpassword")).clear();
            driver.findElement(By.id("loginpassword")).sendKeys("hi123"); // your password

            // Click login button (specific to login modal)
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@onclick='logIn()']"))).click();

            // Handle possible alert (wrong password, invalid user, etc.)
            try {
                wait.until(ExpectedConditions.alertIsPresent());
                Alert alert = driver.switchTo().alert();
                System.out.println("⚠️ Alert: " + alert.getText());
                alert.accept();
            } catch (Exception ex) {
                System.out.println("✅ No alert shown, checking login status...");
            }

            // Wait until username appears on top (login successful)
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("nameofuser"), "kritika"));
            WebElement userLoggedIn = driver.findElement(By.id("nameofuser"));
            System.out.println("✅ Login Successful: " + userLoggedIn.getText());

        } catch (Exception e) {
            System.out.println("❌ Login Failed with correct credentials.");
        } finally {
            // Close browser
            driver.quit();
        }
    }
}
