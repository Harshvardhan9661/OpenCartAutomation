package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Loginpage {
	
	WebDriver driver;
	public Loginpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myaccount;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//li")
	private List<WebElement> myaccountoption;
	
	@FindBy(id="input-email")
	private WebElement email;
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement clickonsubmmit;
	
	
	public void ClickOnMyAccount() {
		myaccount.click();
	}
	
	public void PrformOperationOnAccount(String opertaion) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfAllElements(myaccountoption));
		for(int i=0;i<myaccountoption.size();i++) {
			if(myaccountoption.get(i).getText().equalsIgnoreCase(opertaion))
			{
				myaccountoption.get(i).click();
				break;
			}
		}
	}
	
	public void EnterUsernameAndPassword(String name, String Password)
	{
		email.sendKeys(name);
		password.sendKeys(Password);
	}
	
	public void ClickOnLoginButton() {
		clickonsubmmit.click();
	}
	
}
