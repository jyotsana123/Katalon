package Herokuapp.Tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import Herokuapp.PageObject.ConfirmationPage;
import Herokuapp.PageObject.Login;
import Herokuapp.PageObject.MakeAppointment;
import Herokuapp.TestComponents.Basetest;

public class BookAppointment extends Basetest {

	@Test()
	public void bookAppointment() {

		Login login = launchApplication();
		login.clickOnMakeAptButton();
		login.enterUsernamePassword("John Doe", "ThisIsNotAPassword");
		login.clickOnSubmit();
		Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/#appointment");
		MakeAppointment ma = new MakeAppointment(driver); 
		ma.selectFacility();   // Select facility
		ma.selectCheckbox(); // Click on checkbox
		ma.selectRadioButton(); // select radio button
		ma.selectDate("3", "December", "2023"); // Select Date
		ma.addComment("Hello I am jyotsana pandey"); // Add comment
		ConfirmationPage confirmationPage = ma.clickOnBookAppointmentButton(); // Click on book appointment
		Assert.assertEquals(confirmationPage.cnfPage(), "Appointment Confirmation"); // verify appointment confirmation page																						
	}

	@Test(dependsOnMethods = { "bookAppointment()" })
	public void goToHomePage() throws InterruptedException {
		// bookAppointment();
		driver.findElement(By.xpath("//a[text()='Go to Homepage']")).click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/");
	}
}
