package pagesPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.DriverFactory;

public class OrderCartPOM extends DriverFactory {
	
	
	@FindBy(xpath = "//a[contains(text(),'Proceed to checkout')]")
	private WebElement buttcheckout;
	
	@FindBy(xpath = "//td[@class=\"product-name\"]/a")
	private WebElement prodName;
	
	@FindBy(xpath = "//dd[@class=\"variation-Size\"]")
	private WebElement prodSize;
	
	@FindBy(xpath = "//a[@ class=\"empty-cart\"]")
	private WebElement clearButton;
	
	@FindBy(xpath = "//a[contains(text(),'continue shopping')]")
	private WebElement buttbackShop;
	
	public void tocheckout() {
		buttcheckout.click();
	}
	
	public String getprodName() {
		return prodName.getText();
	}
	
	public String getprodSize() {
		return prodSize.getText();
	}
	
	public void goBackshop() {
		buttbackShop.click();
	}
	
	// Check if Cart not empty and clear
	public void clearCart( ) {
		if(clearButton.isDisplayed()) {
			clearButton.click();
		}
	}
	
	
	public OrderCartPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);		
	}
	

}
