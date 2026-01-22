package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.RegisterPage;
import testBases.BaseClass;

public class TC002_LoginModule extends BaseClass{
	
	@Test
	public void TestLoginModule() throws InterruptedException
	{
		log.info("************** Test Case TC002 is Satrting By Creating the Object for the RegisterPage************");
		RegisterPage Rp = new RegisterPage(driver);
		log.info("***********Clicking on the My Account Link present in the Application***********");
		Rp.clickMyAccount();
		Thread.sleep(3000);
		log.info("***********Clicking on the Login Link present in the Application***********");
		Rp.ClickLogin();
		Thread.sleep(3000);
		
		LoginPage Lp = new LoginPage(driver);
		log.info("***********Entering UserName in the Application for the Login***********");
		 Lp.SetuserName("jatashankardewangan7@abc.com");
		   Thread.sleep(3000);
		   log.info("***********Entering Password For Logging in into the Application***********");
		     Lp.SetPassword("test@123");	
		       Thread.sleep(3000);
		       log.info("**********Clicking on the Login Button**********");
		          Lp.clickLogin();
		             Thread.sleep(3000);
		               // Assert.assertEquals(Lp.getMessage(), "My Account");
	}

}
