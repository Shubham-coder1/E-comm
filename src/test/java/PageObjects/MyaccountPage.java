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
	
	@FindBy(xpath="//h2[text()='My Account']")
	private WebElement dis_myacc;
	
	public boolean myaccountexist()
	{
		try {
			return (dis_myacc.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
}
