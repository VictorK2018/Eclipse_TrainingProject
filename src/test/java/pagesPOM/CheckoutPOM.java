package pagesPOM;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.DriverFactory;

public class CheckoutPOM  extends DriverFactory {
	
	@FindBy(id = "billing_first_name")
	private WebElement firstname;
	
	@FindBy(id ="billing_last_name")
	private WebElement lastname;
	
	@FindBy(id = "billing_address_1")
	private WebElement addressone;
	
	@FindBy(id ="billing_address_2")
	private WebElement addresstwo;
	
	@FindBy(id = "billing_city")
	private WebElement billcity;
	
	@FindBy(id = "billing_postcode")
	private WebElement postcode;
	
	@FindBy(id = "billing_phone")
	private WebElement billphone;
	
	@FindBy(id = "billing_email")
	private WebElement email;
	
	@FindBy(id = "terms")
	private WebElement checkterms;
	
	@FindBy(id = "place_order")
	private WebElement placeorder;
	
	@FindBy(xpath = "//p[text() = 'Thank you. Your order has been received.']")
	private WebElement orderdone;
	
	public void enterFirstName(String name) {
		//firstname.clear();
		firstname.sendKeys(name);
	}
	
	public void enterLastName(String name) {
		//lastname.clear();
		lastname.sendKeys(name);
	}
	
	public void enterAddressone(String address) {
		addressone.clear();
		addressone.sendKeys(address);
	}
	
	public void enterAddresstwo(String address) {
		addresstwo.clear();
		addresstwo.sendKeys(address);
	}
	
	public void enterCity(String city) {
		billcity.clear();
		billcity.sendKeys(city);
	}
	
	public void enterCode(String code) {
		postcode.clear();
		postcode.sendKeys(code);
	}
	
	public void enterPhone(String phone) {
		billphone.clear();
		billphone.sendKeys(phone);
	}
	
	public void checkboxterms() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.ignoring(NoSuchElementException.class)
		.pollingEvery(Duration.ofSeconds(1))
		.until(ExpectedConditions.visibilityOf(checkterms));		
		checkterms.click();
	}
	
	public void submitOrder() {
		placeorder.click();
	}
	
	public void orderHasdone() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(orderdone));
		System.out.println("Order completed!");
	}
	
	
	public CheckoutPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);		
	}

}
