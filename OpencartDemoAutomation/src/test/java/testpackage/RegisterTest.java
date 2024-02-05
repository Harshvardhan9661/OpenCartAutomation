package testpackage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.Registerpage;

public class RegisterTest {
	WebDriver driver;
    Registerpage rp;
    
    @BeforeMethod
    public void RegisterUserSetup() {
    	rp=new Registerpage(driver);
    	System.out.println("Harsh");
    }
    
    
	@Test(dataProvider="Registerdata")
	public void RegisterUser(String Firstname, String Lastname, String email, String Phone, String password) {
		
		rp.Rgisteruser(Firstname, Lastname, email, Phone, password);
	}

}
