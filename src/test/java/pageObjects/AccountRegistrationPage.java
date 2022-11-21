package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountRegistrationPage {
	WebDriver driver;
	public AccountRegistrationPage(WebDriver driver) {
	

		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath = "//input[@id='input-firstname']") public WebElement txtFirstname;

	@FindBy(xpath = "//input[@id='input-lastname']") public WebElement txtLasttname;

	@FindBy(xpath = "//input[@id='input-email']")    public WebElement txtEmail;

	@FindBy(xpath = "//input[@id='input-password']") public WebElement txtPassword;

	@FindBy(xpath = "//input[@name='agree']")  public WebElement chckpolicy;

	@FindBy(xpath = "//button[normalize-space()='Continue']") public WebElement btnContinue;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']") public WebElement msgConfirmation;
	@FindBy(id="form-register") public WebElement lblRegAccount; 

	public void setFirstName(String fname) {
		txtFirstname.sendKeys(fname);
		
	}

	public void setLastName(String lname) {
		txtLasttname.sendKeys(lname);

	}

	public void setEmail(String email) {
		txtEmail.sendKeys(email);


	}

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);

	

	}

	public void setPrivacyPolicy() {
	JavascriptExecutor js=(JavascriptExecutor)driver;
    js.executeScript("arguments[0].click()", chckpolicy);
		
	}

	public void clickContinue() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
	    js.executeScript("arguments[0].click()", btnContinue);
	
	}

	public String getConfirmationMsg() {
		try {
			return (msgConfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}
		}
	
	
	
		public boolean isRegisterAccountPageDiplayed()
		{
			try
			{
				return (lblRegAccount.isDisplayed());
			}
			catch(Exception e)
			{
				return(false);
			}
		}
		
	}
	
	

