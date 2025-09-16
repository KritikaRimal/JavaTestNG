package testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoginUnitTest {
    WebDriver driver;
    WebElement navbar_login, uname_box, pwd_box, login_button;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // global implicit wait
    }

    @Test
    public void testLogin() throws InterruptedException {
        try {
            // Click login navbar
            navbar_login = driver.findElement(By.id("login2"));
            navbar_login.click();

            // Enter username
            uname_box = driver.findElement(By.id("loginusername"));
            uname_box.sendKeys("testmorning");

            // Enter password
            pwd_box = driver.findElement(By.id("loginpassword"));
            pwd_box.sendKeys("test123");

            // Click Login button
            login_button = driver.findElement(By.xpath("//*[@id='logInModal']/div/div/div[3]/button[2]"));
            login_button.click();

            // Wait for login to reflect
            Thread.sleep(5000); // simple wait (replace with WebDriverWait later)

            // Validate successful login
            String expected_result = "Welcome testmorning";
            String actual_result = driver.findElement(By.id("nameofuser")).getText();
            Assert.assertEquals(actual_result, expected_result,
                "Login test failed: username mismatch!");
        } catch (Exception e) {
            System.out.println("There is an exception: " + e);
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
