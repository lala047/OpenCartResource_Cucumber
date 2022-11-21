package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
	WebDriver driver;
	public MyAccountPage(WebDriver driver) {
	

		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
		@FindBy(xpath = "//a[text()='Account']") public WebElement msgHeading;// MyAccount Page heading
		
		public boolean isMyAccountPageExists()   // MyAccount Page heading display status
		{
			try {
				return (msgHeading.isDisplayed());
			} catch (Exception e) {
				return (false);
			}
		}


}
