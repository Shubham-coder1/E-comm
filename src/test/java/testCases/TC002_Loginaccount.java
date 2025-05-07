package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyaccountPage;
import PageObjects.RegistractionPage;
import testClasses.BaseClass;
import utilities.Dataprovider1;

public class TC002_Loginaccount extends BaseClass
{
	@Test(dataProvider = "dp1", dataProviderClass = Dataprovider1.class)
	public void Loginaccount(String email, String pass, String exp)
	{
		HomePage hp = new HomePage(driver);
		RegistractionPage re = new RegistractionPage(driver);
		LoginPage lp = new LoginPage(driver);
		MyaccountPage ma = new MyaccountPage(driver);
		
		hp.clickmyacc();
		hp.clickLogin();
		lp.emailinput(email);
		lp.passinput(pass);
		lp.loginbtn();
		
		boolean target = ma.myaccountexist();
		
		if(exp.equalsIgnoreCase("valid"))
		{
			if(target==true)
			{
				re.logout();
				re.success();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("invalid"))
		{
			if(target==true)
			{
				re.logout();
				re.success();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		
		
	}
}
