package testsNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
//import org.junit.;

import core.DriverFactory;
import pagesPOM.RegistrationLoginPOM;

public class LoginTestDataProv {
	
  @Test(dataProvider = "dp2")
  public void scenarioLogin(String usernameemail, String pass) {
	  
	    DriverFactory df = new DriverFactory();
		WebDriver driver = df.getDriver("firefox");		

		System.out.println("Running test method");
		
	    RegistrationLoginPOM loginpom = new RegistrationLoginPOM(driver);
		
		// Open login/registration page
		driver.get("http://shop.demoqa.com/my-account/");
		
		// enter data
		loginpom.loginUser(usernameemail);
		loginpom.loginPass(pass);
		loginpom.submitLogin();
		
		// Assert
		//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(2));
		
		Assert.assertTrue(loginpom.enteredLogin());	
		
		// check for all users:
		if ( (loginpom.enteredLogin())) {
			loginpom.log_outClick();
		}
		
		// check if logout done ?
		
		driver.close();
			  
  	}

	
	  @DataProvider public Object[][] dp2() { return new Object[][] { 
		//  USERNAME/EMAIL ADDRESS * 			PASSWORD * 
		{ "myName", 							"123456789TesT!?$%^&" }, 
		{ "inyteti-9518@yopmail.com", 			"123456789TesT!?$%^&" }, 
		
		{ "myName2",							"123456789TesT!?$%^&" }, 
		{ "paproifrokiru-3477@yopmail.com", 	"123456789TesT!?$%^&" }, 
		
		{ "myName3", 							"123456789TesT!?$%^&" },
		{ "ruraumozetrei-9064@yopmail.com", 	"123456789TesT!?$%^&" },
		
		{ "myName4", 	 						"123456789TesT!?$%^&" },
		{ "poumirabukeu-8665@yopmail.com", 		"123456789TesT!?$%^&" },
	  
	  	};
	}
  
  
}
