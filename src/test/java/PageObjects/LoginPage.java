package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage
{
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy (xpath="//input[@id='input-email']")
	private WebElement txt_email;
	
	@FindBy (xpath="//input[@id='input-password']")
	private WebElement txt_pass;
	
	@FindBy (xpath="//input[@value='Login']")
	private WebElement btn_login;
	
	@FindBy (xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement error_msg;
	
	
	public void emailinput(String email)
	{
		txt_email.sendKeys(email);
	}
	
	public void passinput(String password)
	{
		txt_pass.sendKeys(password);
	}
	
	public void loginbtn()
	{
		btn_login.click();;
	}
	
	public boolean errormsg()
	{
		boolean error = error_msg.isDisplayed();
		return error;
	}
	
}
