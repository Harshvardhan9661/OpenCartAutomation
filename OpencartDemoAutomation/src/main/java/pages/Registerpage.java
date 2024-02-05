package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registerpage {
	WebDriver driver;
	public Registerpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@id='input-firstname']")
	public WebElement FirstName;
	@FindBy(xpath="//input[@id='input-lastname']")
	public WebElement LastName;
	@FindBy(xpath="//input[@id='input-email']")
	public WebElement Email;
	@FindBy(xpath="//input[@id='input-telephone']")
	public WebElement Telephone;
	@FindBy(xpath="//input[@id='input-password']")
	public WebElement Password;
	@FindBy(xpath="//input[@id='input-confirm']")
	public WebElement ConfirmPassword;
	@FindBy(xpath="//div[@class='col-sm-10']/label[2]/input")
	public WebElement SubscribeOption;
	@FindBy(xpath="//input[@name='agree']")
	public WebElement Policycheck;
	@FindBy(xpath="//input[@class='btn btn-primary']")
	public WebElement Clickcontinue;
	
	
	public void Rgisteruser(String Firstname, String Lastname, String email, String Phone, String password) {
		FirstName.sendKeys(Firstname);
		LastName.sendKeys(Lastname);
		Email.sendKeys(email);
		Telephone.sendKeys(Phone);
		Password.sendKeys(password);
		ConfirmPassword.sendKeys(password);
		SubscribeOption.click();
		Policycheck.click();
		Clickcontinue.click();
	}

}
