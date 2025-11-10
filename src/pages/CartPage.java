package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import locators.Locate;

public class CartPage {
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}

	public void updateCartItem(String productName, int newQuantity) {
		 driver.findElement(By.xpath(Locate.CART_LINK_XPATH)).click();
		 try {
	            Thread.sleep(3000); // optional wait for cart page to load
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		 String productRowXPath = String.format("//tr[td[contains(text(),'%s')]]", productName);

	        // Locate the quantity input within that row and update it
	        driver.findElement(By.xpath(productRowXPath + Locate.QUANTITY_INPUT_SUFFIX_XPATH))
	              .clear();
	        driver.findElement(By.xpath(productRowXPath + Locate.QUANTITY_INPUT_SUFFIX_XPATH))
	              .sendKeys(String.valueOf(newQuantity));

	        // Click the update button within the same row (if present)
	        driver.findElement(By.xpath(productRowXPath + Locate.UPDATE_BUTTON_SUFFIX_XPATH))
	              .click();

	        System.out.println("Cart item '" + productName + "' updated to quantity: " + newQuantity);
	    }

	

}
