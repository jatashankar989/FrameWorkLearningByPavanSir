package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountCreation;
import pageObjects.RegisterPage;
import testBases.BaseClass;

public class TC001_CreationOfAccount extends BaseClass{

	@Test
	public void SetAccountCreation() throws InterruptedException
	{
		RegisterPage Rp= new RegisterPage(driver);
		Rp.clickMyAccount();
		Thread.sleep(3000);
		Rp.ClickRegister();
		Thread.sleep(3000);
		
		AccountCreation Ac = new AccountCreation(driver);
		Ac.EnterFirstName(RandomString());
		Thread.sleep(3000);
		Ac.EnterLastName(RandomString());
		Thread.sleep(3000);
		Ac.EnterEmail(RandomString()+"@gmail.com");
		Thread.sleep(3000);
		Ac.EnterTelephone(RandomNum());
		Thread.sleep(3000);
		String Password= RandomString();
		Ac.EnterPassword(Password);
		Thread.sleep(3000);
		Ac.EnterConfirmPassword(Password);
		Thread.sleep(3000);
		Ac.ClickAgree();
		Thread.sleep(3000);
		Ac.clickContinue();
		Thread.sleep(3000);
		Assert.assertEquals( Ac.getMessage(),"Your Account Has Been Created!");			
	}
}
