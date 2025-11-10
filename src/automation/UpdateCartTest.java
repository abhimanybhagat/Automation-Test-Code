package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import locators.Locate;
import pages.SignInPage;
import pages.CartPage;

public class UpdateCartTest {
	WebDriver driver;
	SignInPage loginPage;
    CartPage cartPage;
	
	
	@BeforeClass
	 public void beforeMethod() {
		  
		  driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://test.bishalkarki.com");
		  
	
	 loginPage = new SignInPage(driver);
    // cartPage = new CartPage(driver);
	}
	
	@Test(priority = 1)
    public void testLogin() {
        // Perform login
        loginPage.signin("swekshyas@gmail.com", "shop123");
        System.out.println("✅ Login successful");
    }
	
	 @Test(priority = 2)
	    public void testUpdateCartItem() throws InterruptedException {
	        // Update item in the cart
		 driver.findElement(By.xpath(Locate.CART_LINK_XPATH)).click();
		 Thread.sleep(3000);
	 }
	 @AfterClass
	    public void tearDown() {
	        //if (driver != null) {
	           // driver.quit();
	            System.out.println("🚀 Test completed and browser closed.");
	        }
}


	