package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import locators.Locate;

public class SignInPage {
	WebDriver driver;
	public SignInPage(WebDriver driver) {
		this.driver = driver;
}

	public void signin(String username, String password) {
		driver.findElement(By.xpath(Locate.LOGIN_LINK_XPATH)).click();
		try {
			Thread.sleep(5000); //optional wait
			
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.id(Locate.EMAIL_ID)).sendKeys("swekshyas@gmail.com");
		driver.findElement(By.id(Locate.PWD_ID)).sendKeys("shop123");
		driver.findElement(By.id(Locate.LOGIN_BUTTON_XPATH)).click();
	}
		
		

}
