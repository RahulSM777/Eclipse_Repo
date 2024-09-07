package base_classPKG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Sauce_Task_Base {
	
	public WebDriver Driver;
	
	@BeforeClass
	public void start()
	{
		Driver=new ChromeDriver();
		Driver.get("https://www.saucedemo.com/");
	}
	
	@AfterClass
	public void end()
	{
		// Driver.close();
	}

}
