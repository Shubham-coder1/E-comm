package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyaccountPage extends BasePage
{
	public MyaccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	private WebElement dis_myacc;
	
	public boolean myaccountexist()
	{
		if(dis_myacc.isDisplayed())
		return true;
		else
			return false;
	}
}
