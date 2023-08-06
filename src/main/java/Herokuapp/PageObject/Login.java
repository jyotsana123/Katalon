package Herokuapp.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	
	WebDriver driver;
	public Login(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Make Appointment")
	WebElement makeAppointmentButton;
	
	@FindBy(name="username")
	WebElement userName;
	
	@FindBy(id="txt-password")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement submit;
	
	public void goTo()
	{
		driver.get("https://katalon-demo-cura.herokuapp.com/");
	}
	
	public void clickOnMakeAptButton()
	{
		makeAppointmentButton.click();
		//driver.findElement(By.linkText("Make Appointment")).click();
	}
	
	public void enterUsernamePassword(String uName, String pass)
	{
		userName.sendKeys(uName);
		password.sendKeys(pass);
//	driver.findElement(By.name("username")).sendKeys("John Doe");
//	driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");
//	driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	public void clickOnSubmit()
	{
		submit.click();
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