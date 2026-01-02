package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginSteps {

    WebDriver driver;
    WebDriverWait wait;

    @Given("I am in the login page of the Para Bank Application")
    public void i_am_in_the_login_page_of_the_para_bank_application() {
        // Selenium 4+ handles the driver automatically!
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }

    @When("I enter valid credentials")
    public void i_enter_valid_credentials() {
        driver.findElement(By.name("username")).sendKeys("snehaa");
        driver.findElement(By.name("password")).sendKeys("password");
        // Clicking the login button directly
        driver.findElement(By.xpath("//input[@value='Log In']")).click();
    }

    @Then("I should be taken to Overview page")
    public void i_should_be_taken_to_overview_page() {
        // Wait for the element to appear instead of sleeping
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log out")));

        driver.findElement(By.linkText("Log out")).click();
        driver.quit();
    }
}