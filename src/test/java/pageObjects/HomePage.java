package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	public HomePage(WebDriver driver) {
	
	

		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
		@FindBy(xpath = "//span[text()='My Account']") public WebElement lnkMyaccount;
		@FindBy(linkText = "Register") public WebElement lnkRegister;
		@FindBy(linkText = "Login") public WebElement lnklogin;
		
		 public void clickMyAccount() {
		        lnkMyaccount.click();
		 }
		
		/*public void clickRegisterlnk() {    //i used thisbecause it is meant to be a mousehover
			lnkMyaccount.click();
			 Actions action= new Actions(driver);
			 action.moveToElement(lnkMyaccount).perform();
			 Registerbtn.click();*/
		 
		 public void clickRegister() {
		        lnkRegister.click();
		        
		}
		/*public void clickLogin() {
			lnkMyaccount.click();
			 Actions action= new Actions(driver);
			 action.moveToElement(lnkMyaccount).perform();
			btnlogin.click();*/
		
		public void clickLogin() {
	        lnklogin.click();

		}
}