package web_elementPKG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FB_Login_Page {
	
	WebDriver driver;
	
	@FindBy(id="email") WebElement FBemail;
	@FindBy(name="pass") WebElement FBpass;
	@FindBy(name="login") WebElement loginButton;
	
	//                      OR
	//  By fbemail=By.id("email")                    // This is normal method in POM the above model is "PAGE FACTORY" model
	
    public FB_Login_Page(WebDriver driver)
    {
    	this.driver=driver;
    	PageFactory.initElements(driver, this);      // This syntax is required in PAGE FACTORY format for constructor
    }
    
    public void setValues(String Email, String Password)
    {
    	FBemail.sendKeys(Email);
    	FBpass.sendKeys(Password);
    }
    
    public void loginClick()
    {
    	loginButton.click();
    }

}
