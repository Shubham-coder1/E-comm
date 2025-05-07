package testCases;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.RegistractionPage;
import testClasses.BaseClass;

public class TC001_Registeraccount extends BaseClass
{
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	int rowNum = 0;
	@BeforeClass
	public void excelwrite() throws FileNotFoundException
	{
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet("New Sheet");
		
		XSSFRow header = sheet.createRow(rowNum++);
		header.createCell(0).setCellValue("Email");
		header.createCell(1).setCellValue("Password");
	}
	
	
	@Test(invocationCount = 5)
	public void Register()
	{
	HomePage hp = new HomePage(driver);
	RegistractionPage re = new RegistractionPage(driver);
	
	
	hp.clickmyacc();
	hp.clickRegister();
	
	String email1 = Randomemail();
	re.inputfirstname(Randomname());
	re.inputlastname(Randomname());
	re.email(email1);
	re.telephone(Randomnum());
	re.pass(password());
	re.confirmpass(password());
	re.agreeclick();
	re.continueclick();
	re.success();
	re.logout();
	re.success();
	
	System.out.println("Email : " + email1 + " Password : "+password());
	
	XSSFRow row = sheet.createRow(rowNum++);
	row.createCell(0).setCellValue(email1);
	row.createCell(1).setCellValue(password());
	}
	
	@AfterClass
	public void closeexcel() throws IOException
	{
		FileOutputStream f = new FileOutputStream(".//TestData//ts.xlsx");
		workbook.write(f);
		workbook.close();
		System.out.println("Excel File created");
	}
	
}
