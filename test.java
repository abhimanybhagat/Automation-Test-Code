package project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            driver.get("https://test.bishalkarki.com/index.php?controller=authentication&back=my-account");

            log_in loginPage = new log_in(driver);
            log_out logoutPage = new log_out(driver);

            loginPage.doLogin("rimalkritika26@gmail.com", "kritika");

            logoutPage.doLogout();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
