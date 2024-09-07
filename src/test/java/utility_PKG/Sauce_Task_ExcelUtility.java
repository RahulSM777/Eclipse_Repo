package utility_PKG;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Sauce_Task_ExcelUtility {
	
	public static String getCellValues(String XL, String Sheet, int r,int c)
	{
		try
		{
		FileInputStream fi=new FileInputStream(XL);
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		XSSFCell cell=wb.getSheet(Sheet).getRow(r).getCell(c);
		if(cell.getCellType()==CellType.STRING)
		{
			return cell.getStringCellValue();
		}
		else
		{
			return cell.getRawValue();
		}
			
		} catch(Exception e)
		
		{
			return "";
		}
	}
	
	public static int getRowCount(String XL,String Sheet) throws IOException
	{
		FileInputStream fi=new FileInputStream(XL);
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		return wb.getSheet(Sheet).getLastRowNum();
	}

}
