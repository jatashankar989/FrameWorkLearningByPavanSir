package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class ExcelDataProvider {
	
	@DataProvider(name="loginDetail")
	public String[][] DataSet() throws IOException
	{
		String path = ".//testData//DataLogin.xlsx";
		ExcelUtilityClass Ec = new ExcelUtilityClass(path);
		int RowCount=Ec.getRow("Sheet1");
		int CellCount = Ec.getCellCount("Sheet1", 1);
		String data[][] = new String[RowCount][CellCount];
		for(int i=1; i<=RowCount; i++)
		{
			for(int j=0; j<CellCount; j++)
			{
				data[i-1][j]=Ec.getCellData("Sheet1", i, j);
			}
		}
		return data;
	}
}
