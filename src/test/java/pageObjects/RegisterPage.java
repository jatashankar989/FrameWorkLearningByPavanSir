package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends basePage{
	
	
	public RegisterPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//*[@class='dropdown']//a//span[text()='My Account']")
	WebElement MyAccount;
	
	@FindBy(xpath="//a[contains(@href,'register')]")
	WebElement RegisterLink;
	
	@FindBy(xpath="//a[text()='Login']")
	WebElement Login;
	
	public void clickMyAccount()
	{
		MyAccount.click();
	}
	
	public void ClickRegister()
	{
		RegisterLink.click();
	}
	
	public void ClickLogin()
	{
		Login.click();
	}
}
