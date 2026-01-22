package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends basePage{
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(id="input-email")
	WebElement UserName;
	
	@FindBy(id="input-password")
	WebElement Password;
	
	@FindBy(xpath="//*[@value='Login']")
	WebElement Login;
	
	@FindBy(xpath="//*[@id='content']//h2[contains(text(),'My Account')]")
	WebElement cnfMsg;
	
	@FindBy(xpath="//div[@class='list-group']//a[contains(text(),'Logout')]")
	WebElement Logout;
	
	public void SetuserName(String User)
	{
		UserName.sendKeys(User);
	}
	
	public void SetPassword(String pass)
	{
		Password.sendKeys(pass);
	}
	
	public void clickLogin()
	{
		Login.click();
	}
	
	public void clickLogout()
	{
		Logout.click();
	}
		
	public boolean getMessage()
	{
		try
		{
			return cnfMsg.isDisplayed();
		 
		}
		
		catch(Exception e)
		{
			
			
			return false;
		}           
			
	}
}
