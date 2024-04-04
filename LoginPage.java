package testNGTask24Answer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//a[normalize-space()='Log in'])[1]")
	WebElement Loginbutton;
	@FindBy(id = "loginusername")
	WebElement Loginuname;
	@FindBy(id = "loginpassword")
	WebElement Loginpassword;
	@FindBy(xpath = "//button[contains(text(),'Log in')]")
	WebElement login;

	public void Loginbutton() {
		Loginbutton.click();
	}

	public void Loginuname() {
		Loginuname.sendKeys("testuser99999@gmail.com");
	}

	public void Loginpassword() {
		Loginpassword.sendKeys("Testuser@123");
	}

	public void login() {
		login.click();
	}

}
