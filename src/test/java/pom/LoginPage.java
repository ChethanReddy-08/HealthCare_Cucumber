package pom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	@FindBy(id = "email")
	private WebElement un;

	@FindBy(id = "password")
	private WebElement pwd;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement lgn;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterUsername(String username) {
        un.sendKeys(username);
    }

    // Method to enter password
    public void enterPassword(String password) {
       pwd.sendKeys(password);
    }

    // Method to click login button
    public void clickLogin() {
        lgn.click();
    }

	
    }

