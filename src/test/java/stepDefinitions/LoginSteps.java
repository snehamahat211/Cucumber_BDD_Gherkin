package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException; // Added this import
import java.time.Duration;

public class LoginSteps {

    WebDriver driver;
    WebDriverWait wait;

    @Given("I am in the login page of the para Bank Application")
    public void i_am_in_the_login_page_of_the_para_bank_application() {
        driver = new ChromeDriver();
        // INITIALIZE WAIT HERE:
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }

    @When("I enter valid credential")
    public void i_enter_valid_credential() {
        driver.findElement(By.name("username")).sendKeys("snehaa");
        driver.findElement(By.name("password")).sendKeys("confirm"); // Use your real password
        driver.findElement(By.xpath("//input[@value='Log In']")).click();
    }

    @Then("I should be taken to the Overview page")
    public void i_should_be_taken_to_the_overview_page() {
        try {
            // This will now work because 'wait' is no longer null
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log Out")));
            System.out.println("Login Successful!");
            driver.findElement(By.linkText("Log Out")).click();
        } catch (TimeoutException e) {
            // This captures the error message from the website UI if login fails
            String errorMsg = driver.findElement(By.className("error")).getText();
            System.out.println("Login Failed! Site says: " + errorMsg);
            throw e;
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}