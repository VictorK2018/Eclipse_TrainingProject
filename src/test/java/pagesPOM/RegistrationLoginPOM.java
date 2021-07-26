package pagesPOM;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import core.DriverFactory;



public class RegistrationLoginPOM extends DriverFactory{
	
	@FindBy(id="reg_username")
	private WebElement username;
	
	@FindBy(id="reg_email")
	private WebElement registEmail;
	
	@FindBy(id="reg_password")
	private WebElement registPass;
	
	@FindBy(xpath ="//button[contains(text(),'Register')]")
	private WebElement registButton;
	
	//USERNAME OR EMAIL ADDRESS
	@FindBy(id="username")
	private WebElement loginUser;
	
	@FindBy(id= "password")
	private WebElement loginPass;
	
	@FindBy(xpath ="//button[contains(text(),'Log in')]")
	private WebElement loginButton;
	
	@FindBy(xpath="//p[contains(text(),'Your session has expired because it has been over ')]")
	private WebElement sessionExpired;
	
	@FindBy(xpath = "//a[contains(text(),'Log out')]")
	private WebElement log_outLink;
	
	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	private WebElement logoutLink;
	
	
	@FindBy(xpath = "(//*[@class='icon_search'])[1]")
	private WebElement searchicon;
	
	@FindBy(xpath = "//input[@type=\"search\"]")
	private WebElement searchfield;

	@FindBy(xpath = "//h1[@class='product_title entry-title']")
	private WebElement productTitle;
	
	@FindBy(id = "pa_size")
	private WebElement productSize;
	
	@FindBy(id = "pa_color")
	private WebElement productColor;
	
	@FindBy(xpath = "//button[contains(text(),'Add to cart')]")
	private WebElement buttaddcart;
	
	@FindBy(xpath = "//a[contains(text(),'View cart')]")
	private WebElement buttviewcart;
	
	@FindBy(xpath = "//li[strong]")
	private WebElement errorMessage;
	
	
	public void registerUser(String name) {
		username.sendKeys(name);
	}
	
	public void registerEmail(String email) {
		registEmail.sendKeys(email);
	}
	
	public void registerPass(String pass) {
		registPass.sendKeys(pass);
	}
	
	public void submitRegist() {		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout
				(java.time.Duration.ofSeconds(5)).pollingEvery(java.time.Duration.ofSeconds(1));
		//wait.until(ExpectedConditions.elementToBeClickable(registButton));
		wait.until(ExpectedConditions.visibilityOf(registButton));	
				
		registButton.click();
	}
	
	public boolean messageLogin() {
		return sessionExpired.isDisplayed();
	}
	
	public void loginUser(String usernameemail) {
		loginUser.sendKeys(usernameemail);
	}
	
	public void loginPass(String pass) {
		loginPass.sendKeys(pass);
	}
	
	public void submitLogin() {
		loginButton.click();
	}
	
	public void log_outClick() {
		log_outLink.click();
	}
	
	public void logoutClick() {	
		logoutLink.click();
	}
	
	public boolean enteredLogin() {
		return log_outLink.isDisplayed() && logoutLink.isDisplayed();
	}
	
	public void search() {
		searchicon.click();
	}
	
	public void searchEnter(String product) {
		searchfield.sendKeys(product + Keys.ENTER);
	}
	
	public String getProducttext() {
		return productTitle.getText();
	}
	
	public void getsize(String size) {
		// ...before have to choose from drop-down
		Select sel = new Select(productSize);
		// sel1.selectByVisibleText(size);
		sel.selectByValue(size);
	}
	
	public void getcolor(String color) { 
		  Select sel = new Select(productColor);
		  sel.selectByValue(color); 
	}
		
	public void addcart() {
		buttaddcart.click();
	}
	
	public void viewcart() {
		buttviewcart.click();
	}
	
	public String errorGettext() {
		return errorMessage.getText();
	}
	
	public RegistrationLoginPOM(WebDriver driver) {
		//super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);		
	}

	

}
