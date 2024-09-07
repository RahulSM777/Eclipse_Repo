package utility_PKG;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FB_Login_Excelutil {
	
	public static String getCellValues(String xl, String Sheet, int c, int r)
	{
		try
		{
		FileInputStream fi=new FileInputStream(xl);
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		XSSFCell cell=wb.getSheet(Sheet).getRow(r).getCell(c);
		if(cell.getCellType()==CellType.STRING)
		{
			return cell.getStringCellValue();
		}
		else
		{
			return cell.getRawValue();               // Here when ".getRawValue" is used we get the datatype as "string" even if it is "int"
			//        OR
			// int v=cell.getNumericCellValue();     // Here if we directly get the value using ".getNumericValue" we have to convert it into string       
			// return String.valueOf(v);             // Since return value datatype is string
		}
		
		} catch(Exception e)                         // Or this could be handled by adding suggested throwable
		
		{
			return"";                                // By adding this return all the returns within the method be have an outer linkage
		}
		
	}
	
	public static int getRowCount(String xl, String Sheet) throws IOException         // Here instead of  "try-catch" we used direct throwable
	{
		FileInputStream fi=new FileInputStream(xl);
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		return wb.getSheet(Sheet).getLastRowNum();                                   // Since the method is not in "try-catch' method no external return should be neede
	}

}
