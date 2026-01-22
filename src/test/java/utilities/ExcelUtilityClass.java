package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilityClass {
	
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook workbook;
	public static XSSFSheet worksheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public String path;
	
	public ExcelUtilityClass(String path)
	{
		this.path=path;
	}
	
	public int getRow(String SheetName) throws IOException
	{
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		worksheet = workbook.getSheet(SheetName);
		int rowCount=worksheet.getLastRowNum();
		workbook.close();
		fis.close();
		return rowCount;
	}
	
	public int getCellCount(String SheetName, int rowCount) throws IOException
	{
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis); 
		worksheet = workbook.getSheet(SheetName);
		int CellCount=worksheet.getRow(rowCount).getLastCellNum();
		workbook.close();
		fis.close();		
		return CellCount;
	}
	
	public String getCellData(String SheetName, int rowCount, int CellCount) throws IOException
	{
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		worksheet= workbook.getSheet(SheetName);
		row= worksheet.getRow(rowCount);
		cell=row.getCell(CellCount);
		String CellValue=cell.getStringCellValue();
		return CellValue;
	}
	

}
