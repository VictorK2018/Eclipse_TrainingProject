package testsNG;

import org.testng.annotations.Test;
//import org.junit.;

import core.DriverFactory;
import pagesPOM.RegistrationLoginPOM;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class RegistrationTests {
	
  @Test (dataProvider = "dp1")
  public void scenarioRegistration(String username, String email, String pass) {
		  
			DriverFactory df = new DriverFactory();
			WebDriver driver = df.getDriver("edge");		
			
		    RegistrationLoginPOM registerpom = new RegistrationLoginPOM(driver);
			
			// Open registration page
			driver.get("http://shop.demoqa.com/my-account/");
			
			driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(3));
			
			// fill registration
			registerpom.registerUser(username);
			registerpom.registerEmail(email);
			registerpom.registerPass(pass);
			
			
			// zoom browser:...
			driver.manage().window().fullscreen();
			registerpom.submitRegist();
			
			// Assert registration -positive test:
			//Assert.assertTrue(registerpom.messageLogin());
			
			// Assert already registered user:
		    Assert.assertEquals( registerpom.errorGettext(), 
		    "Error: An account is already registered with your email address. Please log in." );
			 
			driver.close();
  }
  
  @DataProvider
  public Object[][] dp1() {		
		// ...the data can come from a @DataProvider in TestNG.
	  return new Object[][] {
		  
		  // USERNAME * 		EMAIL ADDRESS * 				PASSWORD *
		  // already registered users:
		  { "myName", 	"inyteti-9518@yopmail.com", 		"123456789TesT!?$%^&" },    	  
		  { "myName2", 	"paproifrokiru-3477@yopmail.com", 	"123456789TesT!?$%^&" },  		  
		  { "myName3", 	"ruraumozetrei-9064@yopmail.com", 	"123456789TesT!?$%^&" }, 	  
		  { "myName4", 	"poumirabukeu-8665@yopmail.com", 	"123456789TesT!?$%^&" },
		  // register new user before positive test!
	  };    
  }
  
  
  @BeforeTest
  public void beforeTest() {
	  System.out.println ("Test started");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println ("Test finished");
  }

}
