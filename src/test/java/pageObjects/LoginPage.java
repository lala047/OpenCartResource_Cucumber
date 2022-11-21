package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
public LoginPage(WebDriver driver) {
		

	this.driver=driver;
	PageFactory.initElements(driver, this);
		}
			
	@FindBy(xpath = "//input[@id='input-email']") public WebElement txtemail;
	@FindBy(xpath = "//input[@id='input-password']") public WebElement txtpwd;
	@FindBy(xpath = "//button[normalize-space()='Login']") public WebElement  btnlogin;

	
	public void SetEmail(String email) {
		txtemail.sendKeys(email);
		
	}
	public void SetPwd(String pwd) {
		txtpwd.sendKeys(pwd);
	}
	public void clickLogin() {
		btnlogin.click();
		
		
		
	}
	
}