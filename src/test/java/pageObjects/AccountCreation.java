package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountCreation extends basePage {

	public AccountCreation(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="input-firstname")
	WebElement FirstName;
	
	@FindBy(id="input-lastname")
	WebElement lastName;
	
	@FindBy(id="input-email")
	WebElement email;
	
	@FindBy(id="input-telephone")
	WebElement telephone;
	
	@FindBy(id="input-password")
	WebElement password;
	
	@FindBy(id="input-confirm")
	WebElement confirmPassword;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement CheckboxClick;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement Continue;
	
	@FindBy(xpath="//h1[contains(text(),'Your')]")
	WebElement MessageConfirmation;
	
	public void EnterFirstName(String firstName)
	{
		FirstName.sendKeys(firstName);
	}
	
	public void EnterLastName(String lastname)
	{
		lastName.sendKeys(lastname);
	}
	
	public void EnterEmail(String Email)
	{
		email.sendKeys(Email);
	}
	
	public void EnterTelephone(String Num)
	{
		telephone.sendKeys(Num);
	}
	
	public void EnterPassword(String Password)
	{
		password.sendKeys(Password);
	}
	
	public void EnterConfirmPassword(String cnfpwd)
	{
		confirmPassword.sendKeys(cnfpwd);
	}
	
	public void ClickAgree()
	{
		CheckboxClick.click();
	}
	
	public void clickContinue()
	{
           Continue.click();
	}
	
	public String getMessage()
	{
		try
		{
			if(MessageConfirmation.isDisplayed())
			{
				return MessageConfirmation.getText();
			}
			else
			{
				String message = "No Output";
				return message;
			}
		}
		
		catch(Exception e)
		{
			return e.getMessage();
		}		
	}
}
