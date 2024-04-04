package testNGTask24Answer;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


public class TestNG {
	
	WebDriver driver =new ChromeDriver	();
	SignupPage sg =new SignupPage(driver);
	LoginPage lg =new LoginPage(driver);

	@BeforeTest
	public void start() {
	driver.get("https://www.demoblaze.com");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();}
	
	
	@Test(dependsOnMethods= {"signup"})
	public void login () throws InterruptedException {
		
   
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
	wait.until(ExpectedConditions.visibilityOf(lg.Loginbutton));
	lg.Loginbutton();
	lg.Loginuname();
	lg.Loginpassword();
	wait.until(ExpectedConditions.elementToBeClickable(lg.login)); 
	Thread.sleep(3000);
	lg.login();
	
}
	
	@Test()
	public void signup() throws Exception{

	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf(sg.Signinbutton));
	sg.Signinbutton();
	sg.Signinuname();
	sg.SigninPassword();
	sg.Signin();
	Thread.sleep(5000);
	Alert alert =driver.switchTo().alert();
    String text=alert.getText();
    System.out.println(text);
    alert.accept();

	}
	@AfterTest
	public void close() {
		driver.close();
	}
	
	
	

}