package automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignInTest {
	WebDriver driver;
	WebElement email_box, pwd_box, signin_button, navbar_signin;
	
	@BeforeMethod
	 public void beforeMethod() {
		  
		  driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://test.bishalkarki.com");
		  } 
	@Test
	 public void testlogin() {
		 try {
			navbar_signin = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a"));
			navbar_signin.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 	email_box = driver.findElement(By.id("email"));
		 	email_box.sendKeys("swekshyas@gmail.com");
			pwd_box = driver.findElement(By.id("passwd"));
			pwd_box.sendKeys("shop123");
			signin_button = driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span"));
			signin_button.click();
			Thread.sleep(5000);
		 }
	 
		 catch(Exception E){
			 System.out.println("There is an exception" + E);
		 }
	 }

	@AfterMethod
	  public void afterMethod() {
		 // driver.quit();	
	  }
		
	}


