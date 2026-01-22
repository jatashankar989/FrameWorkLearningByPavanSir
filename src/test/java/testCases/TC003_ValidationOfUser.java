package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.RegisterPage;
import testBases.BaseClass;
import utilities.ExcelDataProvider;

public class TC003_ValidationOfUser extends BaseClass{
	
	@Test(dataProvider="loginDetail",dataProviderClass=ExcelDataProvider.class)
	public void TestLoginModule(String UserName, String Password, String Status) throws InterruptedException
	{
		log.info("************** Test Case TC003_ValidationOfUser is Starting By Creating the Object for the RegisterPage************");
		RegisterPage Rp = new RegisterPage(driver);
		log.info("***********Clicking on the My Account Link present in the Application***********");
		Rp.clickMyAccount();
		Thread.sleep(3000);
		log.info("***********Clicking on the Login Link present in the Application***********");
		Rp.ClickLogin();
		Thread.sleep(3000);
		
		LoginPage Lp = new LoginPage(driver);
		log.info("***********Entering UserName in the Application for the Login***********");
		 Lp.SetuserName(UserName);
		   Thread.sleep(3000);
		     log.info("***********Entering Password For Logging in into the Application***********");
		       Lp.SetPassword(Password);	
		         Thread.sleep(3000);
		            log.info("**********Clicking on the Login Button**********");
		               Lp.clickLogin();
		                 Thread.sleep(3000);
		                    boolean status = Lp.getMessage();
		                    if(Status.equalsIgnoreCase("Passed"))
		                    {
		                    	if(status==true)
		                    	{
		                    		System.out.println("Login Happened Successfully and Test Passed");
		                    		Lp.clickLogout();
		                    	}
		                    	
		                    	else
		                    	{
		                    		System.out.println("Login Not Happened");
		                    	}
		                    }
		                    
		                 if(Status.equalsIgnoreCase("Failed"))
		                    {
		                    	if(status==true)
		                    	{
		                    		System.out.println("Login Happened But test Failed");
		                    		Lp.clickLogout();
		                    	}
		                    	else
		                    	{
		                    		System.out.println("For Failed Status, Login Not Happened so Test Passed");
		                    	}
		                    }
	}

}
