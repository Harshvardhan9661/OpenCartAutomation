package testpackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.Loginpage;
import utilities.Baseclass;

public class LoginTest extends Baseclass {
	WebDriver driver;
	Loginpage lp;
	
	@Parameters({"url"})
	@BeforeTest
	public void setup(String url) throws IOException   {
	
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void login() {
		lp=new Loginpage(driver);
		lp.ClickOnMyAccount();
		lp.PrformOperationOnAccount("Login");
		lp.EnterUsernameAndPassword(po.getProperty("username"), po.getProperty("password"));
		lp.ClickOnLoginButton();
	}
}
