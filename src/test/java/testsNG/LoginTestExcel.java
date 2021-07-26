package testsNG;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import core.DriverFactory;
import core.ExcelData;
import pagesPOM.RegistrationLoginPOM;

public class LoginTestExcel {
  @Test
  public void scenarioExcelLogin() throws IOException {
	    DriverFactory df = new DriverFactory();
		WebDriver driver = df.getDriver("chrome");		

		// System.out.println("Running test method");
		
	    RegistrationLoginPOM loginpom = new RegistrationLoginPOM(driver);
		
		// Open login/registration page
		driver.get("http://shop.demoqa.com/my-account/");
		
		ExcelData exceldata = new ExcelData();
		
		// print test#
		System.out.println( exceldata.ExcelDataProvider(0, 0, 0) +" is " +exceldata.ExcelDataProvider(0, 1, 0) );
		
		// iterate the row to get the data present in cells
			  
		for(int i=1; i<=8; i++) { 
		// enter data
		  loginpom.loginUser(exceldata.ExcelDataProvider(0, i, 1));
		  loginpom.loginPass(exceldata.ExcelDataProvider(0, i, 2));
		  loginpom.submitLogin();
		
		//System.out.println(exceldata.ExcelDataProvider(0, i, 1));
		  
		// Assert 
		//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(2));
		Assert.assertTrue(loginpom.enteredLogin());
		  
		// check for all users: 
		if ( loginpom.enteredLogin()) {
			//loginpom.log_outClick(); 
			  loginpom.logoutClick(); } 
		 
		//break; 
		}
		
		driver.close();

	  
  }
  
}
