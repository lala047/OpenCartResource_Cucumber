package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountCreatedPage {
	WebDriver driver;
	WebDriverWait wait;

	public AccountCreatedPage(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver, this);
	wait=new  WebDriverWait(driver,Duration.ofSeconds(5));
	}
	
	@FindBy(xpath = "//a[text()='Your Account Has Been Created!']") public WebElement msgConfirmation;
	

	
	public String getConfirmationMsg() {
	wait.until(ExpectedConditions.visibilityOfElementLocated((By) msgConfirmation));
	{
		try
		{
		return (msgConfirmation.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}
}
}
