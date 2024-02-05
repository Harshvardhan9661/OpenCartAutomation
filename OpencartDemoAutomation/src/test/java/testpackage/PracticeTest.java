package testpackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import javax.print.DocFlavor.STRING;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.common.io.Files;
import com.microsoft.schemas.office.visio.x2012.main.CellType;

public class PracticeTest {
	WebDriver driver;
	@Test(priority =1,enabled=false)
	public void test1() {
		driver=new EdgeDriver();
		driver.get("https://www.opencart.com/index.php?route=account/login");
		driver.manage().window().maximize();
		driver.navigate().refresh();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//input[@id='input-username']")).sendKeys("harsh");
		driver.findElement(By.xpath("//input[@id='input-firstname'] ")).sendKeys("harsh1");
		driver.findElement(By.xpath("//input[@id='input-lastname'] ")).sendKeys("harsh11");
		driver.findElement(By.xpath("//input[@id='input-email'] ")).sendKeys("harsh@gmail.com");
		WebElement we =driver.findElement(By.xpath("//select[@id='input-country']"));
		
		Select se=new Select(we);
		List<WebElement> we1=se.getOptions();
		for(WebElement we3: we1) {	
			if(we3.getText().equalsIgnoreCase("india")) {
				we3.click();
			}  }
		driver.findElement(By.xpath("//input[@id=\"input-password\"] ")).sendKeys("Harsh@9334");
		driver.findElement(By.xpath("//div[@id=\"captcha-message\"]//child::div")).click();
	}
	
	@Test(priority=1 ,enabled=false)
	public void test2() {
		driver=new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(1));
		String link=driver.findElement(By.xpath("//li[@class='dropdown']//child::a[@class='dropdown-toggle' ][text()='Desktops']")).getAttribute("href");
		System.out.println(link);
	}
	@Test(priority=1,enabled=false)
	public void setup4() {
		driver=new ChromeDriver();
		driver.get("https://omayo.blogspot.com/");
		driver.findElement(By.xpath("//a[text()='Open a popup window']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Set<String> a=driver.getWindowHandles();
		System.out.println(a.size());
		for(String url: a) {
			if(driver.switchTo().window(url).getTitle().equalsIgnoreCase("New Window")) {
				System.out.println(driver.getTitle());
				System.out.println("hrash");
				driver.close();
			}
			else if(driver.switchTo().window(url).getTitle().equalsIgnoreCase("omayo (QAFox.com)")){
				System.out.println("hrash2");
				break;
			}
		}
	   /*String mainurl=driver.getWindowHandle();
	   driver.switchTo().window("https://omayo.blogspot.com/");*/
	   driver.findElement(By.xpath("//a[text()='Posts (Atom)']")).click();
	   Set<String> listurl=driver.getWindowHandles();
	   for(String lst: listurl) {
		   if(driver.switchTo().window(lst).getCurrentUrl().equalsIgnoreCase("https://omayo.blogspot.com/feeds/posts/default")) {
			   break;
		   }
	   }
	   String h=driver.findElement(By.xpath("//pre[@style='word-wrap: break-word; white-space: pre-wrap;']")).getText();
	   System.out.println(h);
	}
	@Test(enabled=false)
   public void authpopoup() {
	   driver=new ChromeDriver();
	   driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
	
}
	@Test(enabled=false)
	   public void pushnotification() {
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disabled-notifications");
		
		   driver=new ChromeDriver(opt);
		   driver.get("https://www.redbus.in/");
		
	}
	
	@Test(enabled=false)
	public void alert() throws InterruptedException {
		driver=new ChromeDriver();
		driver.get("https://omayo.blogspot.com/");
		driver.findElement(By.xpath("//input[@id='prompt']")).click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert prompt=driver.switchTo().alert();
		Thread.sleep(1000);
		prompt.sendKeys("Harshvardhan");
		Thread.sleep(10000);
		System.out.println(prompt.getText());
		//prompt.accept();
		
	}
	
	@Test(enabled=false)
	public void dropdown() {
		driver=new ChromeDriver();
		driver.get("https://omayo.blogspot.com/");
		driver.manage().window().maximize();
		WebElement we=driver.findElement(By.xpath("//select[@id='drop1']"));
		Select se=new Select(we);
		List<WebElement> we1=se.getOptions();
	    for(WebElement we2: we1) {
	    	System.out.println(we2.getText());
	    	if(we2.getText().equalsIgnoreCase("doc 3")) {
	    		we2.click();
	    	}
	    }
	}
	@Test(enabled=false)
	public void autosuggestivedropdown() throws InterruptedException, IOException {
		driver=new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		driver.findElement(By.xpath("//span[text()='From']")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("A");
		WebElement we2=driver.findElement(By.xpath("//div[@id='react-autowhatever-1']"));
		Thread.sleep(1000);
		Actions ac=new Actions(driver);
		for(int i=0;i<3;i++) {
		ac.sendKeys(Keys.ARROW_DOWN);
	}
		ac.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(100);
		File s=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(s, new File("C:\\Users\\harshavardhan\\Desktop\\New folder\\sel.png"));
		}
	@Test(enabled=false)
	public void table() {
		driver=new ChromeDriver();
		driver.get("https://omayo.blogspot.com/");
		driver.manage().window().maximize();
		WebElement we=driver.findElement(By.xpath("//table[@id='table1']"));
		List<WebElement> element =we.findElements(By.tagName("tr"));
		int i=0;
		for(WebElement welement: element) {
			List<WebElement> tht;
			if(i==0) {
				 tht=welement.findElements(By.tagName("th"));
				
			}
			else {
				 tht=welement.findElements(By.tagName("td"));
			}
			for(WebElement ha:tht) {
				System.out.print(ha.getText()+"  ");
				
			}
			System.out.println();
			i=1;
		}
	}
	
	
	@Test()
	public void details() throws IOException {
		File fe=new File("C:\\Users\\harshavardhan\\Desktop\\New folder\\Tableselenium.xlsx");
		System.out.println("harsh");
		FileInputStream fi=new FileInputStream(fe);
		System.out.println("harsh1");
		
		XSSFWorkbook book=new XSSFWorkbook(fi);
		System.out.println("harsh2");
		XSSFSheet sheet=book.getSheet("Profile");
		System.out.println("harsh3");
		int rowcount=sheet.getLastRowNum();
		int columncount=sheet.getRow(1).getLastCellNum();
		for(int i=0;i<rowcount;i++) {
			XSSFRow row=sheet.getRow(i);
			for(int j=0;j<columncount;j++) {
				XSSFCell cel=row.getCell(j);
				org.apache.poi.ss.usermodel.CellType type=cel.getCellType();
			   switch(type) {
			   case STRING:
				   System.out.print(cel.getStringCellValue());
				   break;
			   case NUMERIC:
				   System.out.print(cel.getNumericCellValue());
				   break;
			   }
			   System.out.print("  ");
			}
			System.out.println();
		}
		
		Object[][] a= {{"Harsh",27},{"priti",20},{"Kundan",23}};
		XSSFSheet sheet1=book.createSheet("update3");
		for(int i=0;i<a.length;i++) {
			XSSFRow row=sheet1.createRow(i);
			for(int j=0;j<a[i].length;j++) {
				Object o=a[i][j];
				XSSFCell cell=row.createCell(j);
				if(o instanceof String) {
					cell.setCellValue((String)o);
				}
				else if(o instanceof Integer) {
					cell.setCellValue((Integer) o);
				}
			}
		}
		File fe1 =new File("C:\\Users\\harshavardhan\\Desktop\\New folder\\Tableselenium.xlsx");
		FileOutputStream fo=new FileOutputStream(fe1);
		book.write(fo);
		
	}
	

}
