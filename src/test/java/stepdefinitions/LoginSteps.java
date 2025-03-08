package stepdefinitions;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pom.LoginPage;

public class LoginSteps {

	public WebDriver driver;
	LoginPage l;

	@Given("user is on login page")
	public void user_is_on_login_page() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://106.51.87.42:9007/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		l = new LoginPage(driver);

	}

	@When("user enter {string} and {string}")
	public void user_enter_and(String username, String password) {
		l.enterUsername(username);
		l.enterPassword(password);

	}

	@And("click on login button")
	public void click_on_login_button() {
		l.clickLogin();
	}

	@Then("the {string} should be displayed")
	public void the_should_be_displayed(String expectedtitle) 
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleContains(expectedtitle));

		String actualtitle = driver.getTitle();
		System.out.println("Page Title: " + actualtitle);
		assertEquals(actualtitle, expectedtitle);

	}

	@After
	public void tearDown()  {
		
		driver.quit();
	}

}
