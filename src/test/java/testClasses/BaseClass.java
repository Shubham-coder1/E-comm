package testClasses;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass
{
	public static WebDriver driver;
	public Properties p;
	
	@Parameters({"browser"})
	@BeforeClass
	public void setup(String br) throws IOException
	{
		switch (br)
		{
		case "chrome" : ChromeOptions options = new ChromeOptions();
						options.addArguments("--start-maximized");
						options.addArguments("--incognito");
						driver = new ChromeDriver(options); break;
		case "edge" : 	EdgeOptions options1 = new EdgeOptions();
						options1.addArguments("--start-maximized");
						options1.addArguments("--incognito");
						driver = new EdgeDriver(options1); break;
		default 	:   System.out.println("Invalid Browser"); return;					
		}
		
		
		String path = "C:\\MobileAutomationWorkspace\\Interview\\config";
		FileReader f = new FileReader(path);
		p=new Properties();
		p.load(f);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("URL"));
	}
	
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
	
	public String Randomnum()
	{
		String tele = RandomStringUtils.randomNumeric(10);
		return tele;
	}
	
	public String Randomemail()
	{
		String fir = RandomStringUtils.randomAlphabetic(5);
		String randomemail = fir+ "@gmail.com";
		return randomemail;
	}
	
	public String Randomname()
	{
		String name = RandomStringUtils.randomAlphabetic(5);
		return name;
	}
	
	public String password()
	{
		String password = "Test1234";
		return password;
	}
	
	public static String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}

}