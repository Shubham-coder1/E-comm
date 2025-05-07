package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	private WebElement btn_myacc;

	@FindBy(xpath="//a[normalize-space()='Register']")
	private WebElement btn_register;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	private WebElement btn_login;
	
	public void clickmyacc()
	{
		btn_myacc.click();
	}
	
	public void clickRegister()
	{
		btn_register.click();
	}
	
	public void clickLogin()
	{
		btn_login.click();
	}
}
