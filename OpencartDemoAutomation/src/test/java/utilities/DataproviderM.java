package utilities;

import org.testng.annotations.DataProvider;

public class DataproviderM {
	@DataProvider(name="Registerdata")
	public Object[][] dataprovider() {
		Object[][] obj=new Object[2][5];
		obj[0][0]="Harsh";
		obj[0][1]="vardhan";
		obj[0][2]="ha9sh@gmail.com";
		obj[0][3]="9896646825";
		obj[0][4]="Harsh@9334";
		
		obj[1][0]="Harsh";
		obj[1][1]="vardhan";
		obj[1][2]="ha8sh@gmail.com";
		obj[1][3]="9896646825";
		obj[1][4]="Harsh@93341";
		return obj;		
	}

}
