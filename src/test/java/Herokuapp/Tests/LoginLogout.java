package Herokuapp.Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Herokuapp.PageObject.Login;
import Herokuapp.PageObject.Logout;
import Herokuapp.TestComponents.Basetest;

public class LoginLogout extends Basetest {

	@Test
	public void login() {
		Login login = launchApplication();
		login.clickOnMakeAptButton();
		Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/profile.php#login.");
		login.enterUsernamePassword("John Doe", "ThisIsNotAPassword");
		login.clickOnSubmit();
	}

	@Test(dependsOnMethods = { "login" })
	public void logout() {
		Logout logout = new Logout(driver);
		logout.clickOnLogout();
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
