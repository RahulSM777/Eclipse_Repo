package testPKG;

import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.Test;

import base_classPKG.Sauce_Task_Base;
import utility_PKG.Sauce_Task_ExcelUtility;
import web_elementPKG.Sauce_Task_Page;

public class Sauce_Task_Test extends Sauce_Task_Base {
	
	@Test
	public void MainTask() throws IOException, InterruptedException
	{
		Sauce_Task_Page ob=new Sauce_Task_Page(Driver);
		
		String XL="C:\\Users\\rahul\\Desktop\\Testing\\4. Selenium\\Apache POI (Excel)\\Book2.xlsx";
		String Sheet="Sheet1";
		int rowCount=Sauce_Task_ExcelUtility.getRowCount(XL, Sheet);
		
		for(int i=1;i<=rowCount;i++)
		{
			Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
			String Username=Sauce_Task_ExcelUtility.getCellValues(XL, Sheet, i, 0);
			System.out.println("Username: " + Username);
			
			String Password=Sauce_Task_ExcelUtility.getCellValues(XL, Sheet, i, 1);
			System.out.println("Password: " + Password);
			
			ob.setValues(Username, Password);
			ob.loginBtn();
			
			Thread.sleep(2000);
			
			String ExpectedSuccessURL="https://www.saucedemo.com/inventory.html";
			String CurrentURL=Driver.getCurrentUrl();
			if(ExpectedSuccessURL.equals(CurrentURL))
			{
				System.out.println("Login Successfull");
				System.out.println(Driver.getCurrentUrl());
			}
			else
			{
				System.out.println("Login Failed");
				System.out.println(Driver.getCurrentUrl());
			}
			
			//Driver.findElement(By.name("user-name")).clear();
			//Driver.findElement(By.name("password")).clear();
			Driver.navigate().refresh();
		}
		
		Thread.sleep(2000);
		ob.addToCart();
		
		Thread.sleep(2000);
		ob.Cart_Checkout();
		
		Thread.sleep(2000);
		ob.YourInfo("Rahul", "Menon", "690101");
		
		Thread.sleep(2000);
		ob.LogOut();
		
		
	}
}
