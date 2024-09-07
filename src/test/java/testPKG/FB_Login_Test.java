package testPKG;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base_classPKG.FB_Login_Base;
import utility_PKG.FB_Login_Excelutil;
import web_elementPKG.FB_Login_Page;

public class FB_Login_Test extends FB_Login_Base {
	
	@Test
	public void LoginTitleTest() throws IOException, InterruptedException
	{
		FB_Login_Page ob=new FB_Login_Page(driver);
		
		String xl="C:\\Users\\rahul\\Desktop\\Testing\\4. Selenium\\Apache POI (Excel)\\Book1.xlsx";
		String Sheet="Sheet1";
		int rowCount=FB_Login_Excelutil.getRowCount(xl, Sheet);
		
		for(int i=1;i<=rowCount;i++)
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
			String Email=FB_Login_Excelutil.getCellValues(xl, Sheet, 0, i);
			System.out.println("Email: " + Email);
			
			String Password=FB_Login_Excelutil.getCellValues(xl, Sheet, 1, i);
			System.out.println("Password: " + Password);
			
			ob.setValues(Email, Password);
			ob.loginClick();
			
			
			
			String expectedurl="https://www.facebook.com/login/?privacy_mutation_token=eyJ0eXBlIjowLCJjcmVhdGlvbl90aW1lIjoxNjIwMzg4MTQ0LCJjYWxsc2l0ZV9pZCI6MzgxMjI5MDc5NTc1OTQ2fQ%3D%3D";
 			String actualurl= driver.getCurrentUrl();
 			  
 			     if(actualurl.equals(expectedurl))
 			     {
 			    	System.out.println("Test Pass");
 			     }else
 			     {
 			    	System.out.println("Test Pass");
 			     }
 			     
 			driver.findElement(By.name("email")).clear();
 			driver.findElement(By.name("pass")).clear();
 			 
		}
		
		
	
				
	}
	

}
