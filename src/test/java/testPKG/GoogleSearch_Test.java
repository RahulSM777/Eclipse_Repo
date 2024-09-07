package testPKG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import web_elementPKG.GoogleSearch_Page;

public class GoogleSearch_Test {
	
	WebDriver Driver;
	String URL="https://www.google.com/";
	
	@BeforeTest
	public void start()
	{
		Driver=new ChromeDriver();
		Driver.get(URL);
	}
	
	@Test
	public void test()
	{
		GoogleSearch_Page ob=new GoogleSearch_Page(Driver);
		ob.SearchKey("Donald Trump");
	}

}
