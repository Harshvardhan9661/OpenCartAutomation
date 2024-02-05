package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeClass;

public class Baseclass {
	public Properties po;
	@BeforeClass
	public void setup() throws IOException {
		po=new Properties();
		String dirpath=System.getProperty("user.dir");
		FileInputStream fi=new FileInputStream(dirpath+"/opencart.properties");
		po.load(fi);
	}

}
