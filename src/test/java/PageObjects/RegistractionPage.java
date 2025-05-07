package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistractionPage extends BasePage
{
	public RegistractionPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath="//input[@id='input-firstname']")
	private WebElement txt_firstname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	private WebElement txt_lastname;

	@FindBy(xpath="//input[@id='input-email']")
	private WebElement email;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	private WebElement telephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement pass;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	private WebElement confirmpass;
	
	@FindBy(xpath="//input[@name='agree']")
	private WebElement btn_agree;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement btn_continue;
	
	@FindBy(xpath="//a[normalize-space()='Continue']")
	private WebElement btn_success;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	private WebElement btn_logout;
	
	

	public void inputfirstname(String fname)
	{
		txt_firstname.sendKeys(fname);
	}
	
	public void inputlastname(String lname)
	{
		txt_lastname.sendKeys(lname);
	}
	
	public void email(String emailID)
	{
		email.sendKeys(emailID);
	}
	
	public void telephone(String tele)
	{
		telephone.sendKeys(tele);
	}
	
	public void pass(String password)
	{
		pass.sendKeys(password);
	}
	
	public void confirmpass(String password)
	{
		confirmpass.sendKeys(password);
	}
	
	public void continueclick()
	{
		btn_continue.click();
	}
	
	public void agreeclick()
	{
		btn_agree.click();
	}
	
	public void success()
	{
		btn_success.click();
	}
	
	public void logout()
	{
		btn_logout.click();
	}
}
