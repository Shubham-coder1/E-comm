package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DatePicker
{
	public static int monthnum(String currentmonth)
	{
		String mon[] = { "", "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };

		for (int i = 1; i < mon.length; i++) {
			if (currentmonth.equalsIgnoreCase(mon[i])) {
				return i;
			}
		}

		return -1;
	}

	//DatePicker Utility
	public static void Datepick(WebDriver driver, String day, String month, String year)
	{
		while (!driver.findElement(By.cssSelector(".ui-datepicker-year")).getText().equals(year)) {
			int currentyear = Integer.parseInt(driver.findElement(By.className("ui-datepicker-year")).getText());

			if (currentyear > Integer.parseInt(year)) {
				driver.findElement(By.xpath("//*[@data-handler='prev']")).click();
			} else {
				driver.findElement(By.xpath("//*[@data-handler='next']")).click();
			}
		}

		while (!driver.findElement(By.cssSelector(".ui-datepicker-month")).getText().equals(month)) {
			int currentmonthnum = monthnum(driver.findElement(By.cssSelector(".ui-datepicker-month")).getText());
			int expmonthnum = monthnum(month);

			if (currentmonthnum > expmonthnum) {
				driver.findElement(By.xpath("//*[@data-handler='prev']")).click();
			} else {
				driver.findElement(By.xpath("//*[@data-handler='next']")).click();
			}

		}
		driver.findElement(By.xpath("//td[@data-handler='selectDay']/a[text()='" + day + "']")).click();
	}
}
