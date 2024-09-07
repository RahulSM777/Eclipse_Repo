package web_elementPKG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearch_Page {
	
	WebDriver Driver;
	By SearchBar=By.xpath("//*[@id=\"APjFqb\"]");
	
	public GoogleSearch_Page(WebDriver Driver)
	{
		this.Driver=Driver;
	}
	
	public void SearchKey(String key)
	{
		Driver.findElement(SearchBar).sendKeys(key, Keys.ENTER);
	}

}
