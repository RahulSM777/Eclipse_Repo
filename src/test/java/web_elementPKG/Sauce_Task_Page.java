package web_elementPKG;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Sauce_Task_Page {
	
	WebDriver Driver;
	@FindBy(name="user-name") WebElement UN;
	@FindBy(name="password") WebElement PWD;
	@FindBy(id="login-button") WebElement LB;
	
	@FindBy(id="add-to-cart-sauce-labs-backpack") WebElement Item_1;
	@FindBy(id="add-to-cart-sauce-labs-bike-light") WebElement Item_2;
	@FindBy(id="add-to-cart-sauce-labs-bolt-t-shirt") WebElement Item_3;
	@FindBy(id="add-to-cart-sauce-labs-fleece-jacket") WebElement Item_4;
	@FindBy(id="add-to-cart-sauce-labs-onesie") WebElement Item_5;
	@FindBy(id="add-to-cart-test.allthethings()-t-shirt-(red)") WebElement Item_6;
	
	@FindBy(xpath="//*[@id=\"shopping_cart_container\"]/a") WebElement CartButton;
	@FindBy(name="checkout") WebElement CheckOutButton;
	
	@FindBy(id="first-name") WebElement First_name;
	@FindBy(id="last-name") WebElement Last_name;
	@FindBy(id="postal-code") WebElement Postal_code;
	@FindBy(id="continue") WebElement Cont;
	
	@FindBy(id="react-burger-menu-btn") WebElement HamBurgerMenu;
	@FindBy(xpath="//*[@id=\"logout_sidebar_link\"]") WebElement LogOutButton;
	
	public Sauce_Task_Page(WebDriver Driver)
	{
		this.Driver=Driver;
		PageFactory.initElements(Driver, this);
	}
	
	public void setValues(String Username, String Password)
	{
		UN.sendKeys(Username);
		PWD.sendKeys(Password);
	}
	
	public void loginBtn()
	{
		LB.click();
	}
	
	public void addToCart()
	{
		Item_1.click();
		Item_2.click();
		Item_3.click();
		Item_4.click();
		Item_5.click();
		Item_6.click();
		// Here instead of taking each element we can choose a common path with reference for eg:Class, which is common in all the 6 products
		// Which shows after the path 1 in 6, it can be done as following:
		
		// @FindBy(xpath="common path(Mostly common @class)") List<WebElement> addToCartList
		// System.out.println("No of Products: " + addToCartList.size());
		// for(WebElement OneProduct: addToCartList) {
		//    OneProduct.click();  }
	}
	
	public void Cart_Checkout() throws InterruptedException
	{
		CartButton.click();
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor) Driver;
		js.executeScript("window.scrollBy(0,700)");
		CheckOutButton.click();
	}
	
	public void YourInfo(String FirstName, String LastName,String ZipCode)
	{
		First_name.sendKeys(FirstName);
		Last_name.sendKeys(LastName);
		Postal_code.sendKeys(ZipCode);
		Cont.click();
	}
	
	public void LogOut()
	{
		Driver.navigate().back();
		Driver.navigate().back();
		Driver.navigate().back();
		String ExpURL="https://www.saucedemo.com/inventory.html";
		if(ExpURL.equals(Driver.getCurrentUrl()))
		{
			HamBurgerMenu.click();
			LogOutButton.click();
		}
		else
		{
			System.out.println("Home Page not Reached: Log Out Failed");
		}
	}

}
