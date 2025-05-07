package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Dataprovider1
{
	@DataProvider(name = "dp1")
	public String[][]datapro() throws IOException
	{
		String path = ".//TestData//ts.xlsx";
		FileInputStream f = new FileInputStream(path);
		XSSFWorkbook workbook = new XSSFWorkbook(f);
		XSSFSheet sheet = workbook.getSheet("New Sheet");
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(1).getLastCellNum();
		

		String[][] data = new String[rowcount][colcount];
				{
					for(int i=1;i<rowcount;i++)
					{
						for(int j=0;j<colcount;j++)
						{
							data[i-1][j]=sheet.getRow(i).getCell(j).toString();
						}
					}
				}
		workbook.close();
		f.close();
		return data;
	}
}
