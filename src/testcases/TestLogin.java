package testcases;

import org.testng.annotations.Test;

import pages.LoginPage;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class TestLogin {
	WebDriver driver;
	LoginPage lp;
	
	
@BeforeMethod
  public void beforeMethod() {
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.demoblaze.com");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	lp =new LoginPage(driver);
	
  }

  
@Test
  public void atest_login() {
	lp.login("testmorning","test123");
	try {
		Thread.sleep(Duration.ofSeconds(10));
	}
	catch(Exception E) {
		System.out.print(E);
	}
  }

  @Test
  public void bnegative_login(){
	  lp.login("testmorning","test12");
		try {
			Thread.sleep(Duration.ofSeconds(10));
		}
		catch(Exception E) {
			System.out.print(E);
		}  
  }
  
@AfterMethod
  public void afterMethod() {
	driver.quit();
  }

}





