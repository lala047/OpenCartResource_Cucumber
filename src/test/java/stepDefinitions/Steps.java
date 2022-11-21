package stepDefinitions;

import java.time.Duration;
import java.util.ResourceBundle;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.core.logging.Logger;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.AccountCreatedPage;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class Steps {
	  WebDriver driver;
	  Logger logger;//for logging
	    ResourceBundle rb; // for reading properties file
	    String br;
	    HomePage hp;
	    LoginPage lp;
	    AccountRegistrationPage apg;
	    MyAccountPage map;
	    AccountCreatedPage acp;
	    
	    
	    public String randomeString()
		{
			String generatedString=RandomStringUtils.randomAlphabetic(5);
			return generatedString;
		}
		
		
	    
	    
	    
	    @Before
	    public void setup()
	    {
	       // logger= LogManager.getLogger(this.getClass()); //for logging

	        rb=ResourceBundle.getBundle("config");
	        br=rb.getString("browser");
	    }

	    @After
	    public void tearDown(Scenario scenario) {
	        if(scenario.isFailed()) {
	            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	            scenario.attach(screenshot, "image/png",scenario.getName());
	            driver.quit();
	        }
	       
	    }

	
	
	
	
//Login Steps
@Given("User Launch browser")
public void user_launch_browser() {
	if(br.equals("chrome"))
    {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
    }
    else if (br.equals("firefox")) {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }
    else if (br.equals("edge")) {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
    }
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
}

@Given("opens URL {string}")
public void opens_url(String url) {  // it was String String but he changed the other to url
	 driver.get(url);
     driver.manage().window().maximize();
}

@When("User navigate to MyAccount menu")
public void user_navigate_to_my_account_menu() {
	hp= new HomePage(driver);
	hp.clickMyAccount();
	//logger.info("clicked on Login");
}

@When("click on Login")
public void click_on_login() throws InterruptedException {
	hp.clickLogin();
}

@When("User enters Email as {string} and Password as {string}")
public void user_enters_email_as_and_password_as(String email, String pwd) {  // it was String String. String String  but he changed the other to email and password
	 lp=new LoginPage(driver);
	lp.SetEmail(email);      //The "email" and "password" is stored in config.properties in the resources 
	lp.SetPwd(pwd);
	
	
}

@When("Click on Login button")
public void click_on_login_button() throws InterruptedException {
	lp.clickLogin();
	Thread.sleep(3000);
}

@Then("User navigates to MyAccount Page")
public void user_navigates_to_my_account_page() {
	//To verify that we landed on the acct page after log in
			/*MyAccountPage acct=new MyAccountPage(driver);
			boolean targetpage=acct.isMyAccountPageExists();
			
			try {
				Assert.assertEquals(targetpage,true);
			}
			
			catch(Exception e)
			{
				Assert.fail();*/
			
			
			/*if
			(driver.getTitle().equals("My Account")) {
				 Assert.assertTrue(true); 
			}else {
					  Assert.assertTrue(false);  */
			
			boolean res=driver.getPageSource().contains("My Account");//just  copy the text(which is any message on the page of interest)and put here
			
			if(res==true)
			{
			Assert.assertTrue(true);
				
			}else{
			Assert.assertTrue(false);
			}
			
			
			}		

@Then("Close Browser")
public void close_browser() {
}


//Account Registration

@When("click on Register")
public void click_on_register() throws InterruptedException {
	hp.clickRegister();
	Thread.sleep(3000);
	
	/*public void clickRegisterlnk() {    //i used thisbecause it is meant to be a mousehover
	lnkMyaccount.click();
	 Actions action= new Actions(driver);
	 action.moveToElement(lnkMyaccount).perform();
	 Registerbtn.click();*/
}

@Then("user navigates to Register Account page")
public void user_navigates_to_register_account_page() {
 apg= new AccountRegistrationPage(driver);


    if(apg.isRegisterAccountPageDiplayed())
    {
      //  logger.info("Register Account page displayed ");
        Assert.assertTrue(true);
    }

    else {
       // logger.info("Register Account page Not displayed ");
        Assert.assertTrue(false);
    }
}

@When("user provide valid details")
public void user_provide_valid_details() {
			apg.setFirstName(randomeString().toUpperCase()); // This will generate random  first name
			//logger.info("Provided first name");
			apg.setLastName(randomeString().toUpperCase()); // This will generate random last name
			//logger.info("Provided last name");
			apg.setEmail(randomeString() + "@gmail.com");// randomly generated the email
			//logger.info("Provided last name");
			apg.setPassword("slyman01");
			//logger.info("Provided password");
}

@When("Check the Privacy Policy")
public void check_the_privacy_policy() {
apg.setPrivacyPolicy();
}
@When("Click on continue")
public void click_on_continue() throws InterruptedException {
	apg.clickContinue();
	Thread.sleep(3000);
}


@Then("User should see {string} message")
public void user_should_see_message(String espmsg) throws InterruptedException {  // it was String String. String String  but he changed the other to espmsg
	acp= new AccountCreatedPage (driver);
	
	/*String confmsg=acp.getConfirmationMsg();
    driver.close();
    if(confmsg.equals(espmsg)) {   //espmsg is the String value
      //  logger.info("Account Registration Success ");
        Assert.assertTrue(true);
    }
     else {
      //  logger.error("Account Registration Failed ");
        Assert.assertTrue(false);*/
        
      /*  boolean res=driver.getPageSource().contains("Your Account Has Been Created!");//just  copy the text(which is any message on the page of interest)and put here
			
			if(res==true)
			{
			Assert.assertTrue(true);
				
			}else{
			Assert.assertTrue(false);*/
		

		
}
	
			
}
