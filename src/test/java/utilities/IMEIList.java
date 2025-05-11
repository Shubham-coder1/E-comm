package utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IMEIList
{
	public static String IMEI() throws IOException
	{
		File file = new File(".//TestData//IMEI.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		List<String> lines = new ArrayList<>();

		String IMEItoUse = br.readLine();
		String nextall;

		while ((nextall = br.readLine()) != null) {
			lines.add(nextall);
		}
		br.close();

		BufferedWriter br1 = new BufferedWriter(new FileWriter(file));
		for (String x : lines) {
			br1.write(x);
			br1.newLine();
		}
		br1.close();

		return IMEItoUse;
	}
}
