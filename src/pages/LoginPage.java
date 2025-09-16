package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import locators.Locate;

public class LoginPage {
	WebDriver driver;
	
	 public LoginPage(WebDriver driver) {  //web driver ko value aaunay
		 this.driver = driver; // 	no6. WebDriverdriver =  no7. (WebDriver driver)
	  //from class     from variable
	 }
	
	 public void login(String username, String password) {
		 	driver.findElement(By.id(Locate.NAV_BAR_LOGIN_ID)).click();
		 	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 	driver.findElement(By.id(Locate.UNAME_ID)).sendKeys(username);
		 	driver.findElement(By.id(Locate.PWD_ID)).sendKeys(password);
		 	driver.findElement(By.xpath(Locate.LOGIN_BUTTON_XPATH)).click();
		 	} 		 	
	 }
	 
	 
	 
