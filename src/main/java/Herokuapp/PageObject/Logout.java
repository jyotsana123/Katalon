package Herokuapp.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logout {
	
	WebDriver driver;
	public Logout(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="menu-toggle")
	WebElement menu;
	
	@FindBy(xpath="//a[text()='Logout']")
	WebElement logout;
	
	
	public void clickOnLogout()
	{
		menu.click();
		logout.click();
	}

}

/*public void login()
{
	driver.findElement(By.linkText("Make Appointment")).click();
	Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/profile.php#login");
	driver.findElement(By.name("username")).sendKeys("John Doe");
	driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
} 
public void logout()
	{
		driver.findElement(By.id("menu-toggle")).click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
	}
*/
