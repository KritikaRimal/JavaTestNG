package seleniumCodes;

import java.util.Scanner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Assignment_1 {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) { // Scanner will auto-close here
            System.out.println("Enter 1 for Chrome, 2 for Edge, 3 for Firefox:");
            int choice = sc.nextInt();
            WebDriver driver = null;

            switch (choice) {
                case 1:
                    driver = new ChromeDriver();
                    break;
                case 2:
                    driver = new EdgeDriver();
                    break;
                case 3:
                    driver = new FirefoxDriver();
                    break;
                default:
                    System.out.println("Invalid choice!");
                    System.exit(0);
            }

            // Open Demoblaze website
            driver.get("https://www.demoblaze.com");
        }
    }
}
