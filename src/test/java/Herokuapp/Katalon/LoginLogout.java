package Herokuapp.Katalon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginLogout {
	
	static WebDriver driver;
	ChromeOptions options;

	@BeforeMethod
	public void setUp() {
		options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		driver.get("https://katalon-demo-cura.herokuapp.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@Test
	public void login()
	{
		driver.findElement(By.linkText("Make Appointment")).click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/profile.php#login");
		driver.findElement(By.name("username")).sendKeys("John Doe");
		driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	@Test(dependsOnMethods= "login")
	public void logout()
	{
		driver.findElement(By.id("menu-toggle")).click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
	}

}
