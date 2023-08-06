package Herokuapp.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ConfirmationPage {

	WebDriver driver;
	public ConfirmationPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h2[text()='Appointment Confirmation']")
	WebElement appointmentCnf;
	
	public String cnfPage()
	{
	// verify appointment confirmation page
			//String appointmentConfirmation = appointmentCnf.getText();
			return appointmentCnf.getText();
	}
}
