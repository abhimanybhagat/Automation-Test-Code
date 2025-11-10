package project;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class log_out {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(css = "a.logout")
    private WebElement logoutLink;

    public log_out(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void doLogout() {
        WebElement accountMenu = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.account"))
        );

        Actions actions = new Actions(driver);
        actions.moveToElement(accountMenu).perform();

        wait.until(ExpectedConditions.elementToBeClickable(logoutLink)).click();
    }
}
