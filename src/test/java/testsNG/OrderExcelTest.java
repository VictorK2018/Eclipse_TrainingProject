package testsNG;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import core.DriverFactory;
import core.ExcelData;
import pagesPOM.CheckoutPOM;
import pagesPOM.OrderCartPOM;
import pagesPOM.RegistrationLoginPOM;

public class OrderExcelTest {
	
	@Test 
	  public void ScenarioDressesSelection() throws IOException {

		  
		  DriverFactory df = new DriverFactory();
		  WebDriver driver = df.getDriver("chrome");	
			
		    RegistrationLoginPOM loginpom = new RegistrationLoginPOM(driver);
			
			// Open login/registration page
			driver.get("http://shop.demoqa.com/my-account/");
			
			ExcelData exceldata = new ExcelData();
			
			// enter data
			  loginpom.loginUser(exceldata.ExcelDataProvider(0, 3, 1));
			  loginpom.loginPass(exceldata.ExcelDataProvider(0, 3, 2));
			  loginpom.submitLogin();
			  
			// print Login name
			//System.out.println("username is: " +exceldata.ExcelDataProvider(0, 2, 1));
			Reporter.log("Login name for this test: " +exceldata.ExcelDataProvider(0, 2, 1), true);
			  
			// Assert 
			//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(2));
			Assert.assertTrue(loginpom.enteredLogin());
			
			// print test number
			System.out.println( exceldata.ExcelDataProvider(1, 0, 0) +" is " +exceldata.ExcelDataProvider(1, 1, 0) );
		
			
			// add to cart dresses
			
			// all dresses from Excel: 
			//for (int i=0; i<exceldata.ExcelDataProvider(1, i, 1).length(); i++) { ...
			
			// dress chosen ( these dress orders have to return errors!: i=6 and i=7 ):
			int i=1;
			int j=1;
			// search&enter dresses
			loginpom.search();
			loginpom.searchEnter(exceldata.ExcelDataProvider(1, i, j));
			String product = exceldata.ExcelDataProvider(1, i, j);
			
			// zoom browser:...
			driver.manage().window().fullscreen();
			//  .until(ExpectedConditions.elementToBeClickable(ele));
			
			// get size:
			loginpom.getsize(exceldata.ExcelDataProvider(1, i, j+1));
			String size = exceldata.ExcelDataProvider(1, i, j+1);
			
			// get color:
			loginpom.getcolor(exceldata.ExcelDataProvider(1, i, j+2));
			String color = exceldata.ExcelDataProvider(1, i, j+2);
			
			Reporter.log("Order selection was done", true);
			
			// verifies that search results has these product and size ?				
			//Assert.assertEquals( (exceldata.ExcelDataProvider(i, j)), loginpom.getProducttext());
			//loginpom.assertSize(size);
			
			// click "add to cart" 
			loginpom.addcart();
			
			// view cart
			loginpom.viewcart();		
			OrderCartPOM cartpom = new OrderCartPOM(driver);
			
			// assert page and order ( actual, expected )
		       
			//System.out.println(product +" - " +color.toUpperCase());
	        Assert.assertEquals(driver.getCurrentUrl(), "http://shop.demoqa.com/cart/", "Cart page was not opened: "); 
	        Assert.assertEquals(product +" - " +color.toUpperCase(), cartpom.getprodName(), "Name of product and/or color is wrong in the cart: ");        
	        Assert.assertEquals(size.toUpperCase(), cartpom.getprodSize(), "Size of product is wrong in the cart: ");
	        Reporter.log("Validating Cart details was done", true);
	        
	        // go to checkout
	        cartpom.tocheckout();	      
	        
	        CheckoutPOM checkpom = new CheckoutPOM(driver);
	        
	        // on Checkout page email is auto-completed!
	        // assert order & enter personal data from Sheet#2( actual, expected ) ?
	        
	        // enter user's data
	        int row = 3;
	        checkpom.enterFirstName(exceldata.ExcelDataProvider(2, row, 1));
	        checkpom.enterLastName(exceldata.ExcelDataProvider(2, row, 2));
	        checkpom.enterAddressone(exceldata.ExcelDataProvider(2, row, 3));
	        checkpom.enterAddresstwo(exceldata.ExcelDataProvider(2, row, 4));
	        checkpom.enterCity(exceldata.ExcelDataProvider(2, row, 5));
	        checkpom.enterCode(exceldata.ExcelDataProvider(2, row, 6));
	        checkpom.enterPhone(exceldata.ExcelDataProvider(2, row, 7));
	        
	        // place order
			// scroll and mark check-box
			((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-200)");
	        checkpom.checkboxterms();
	        
	        checkpom.submitOrder();
	        
	        // assert
	        checkpom.orderHasdone();
	        
			// logout from account
	      	driver.get("http://shop.demoqa.com/my-account/");
	      	RegistrationLoginPOM loginpom2 = new RegistrationLoginPOM(driver);
	      	loginpom2.log_outClick();
			//loginpom.logoutClick();  
	      	Reporter.log("Logout from account was done", true);

		  
			driver.close();
		  
	  }
	  
	  @BeforeTest
	  public void beforeTest() {
			 
		System.out.println("Test started");	
	  }

	  @AfterTest
	  public void afterTest() {
		System.out.println("Test finished");
	  }
  
  
  
  
  
}
