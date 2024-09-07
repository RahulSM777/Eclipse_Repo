package base_classPKG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class FB_Login_Base {
	
	public WebDriver driver;
	
	@BeforeClass
	public void start()
	{
		driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
	}
	
	@AfterClass
	public void end()
	{
		//driver.close();
	}

}
