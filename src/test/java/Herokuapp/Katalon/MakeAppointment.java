package Herokuapp.Katalon;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class MakeAppointment {

	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		//driver.manage().window().maximize();
		driver.get("https://katalon-demo-cura.herokuapp.com/");
		driver.findElement(By.linkText("Make Appointment")).click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/profile.php#login");
		driver.findElement(By.name("username")).sendKeys("John Doe");
		driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/#appointment");
		
		//Select facility
		WebElement dropdown = driver.findElement(By.id("combo_facility"));
		Select s = new Select(dropdown);
		s.selectByValue("Seoul CURA Healthcare Center");
		System.out.println("Selected dropdown is: "+s.getFirstSelectedOption().getText());  //print the selected dropdown
		//get all the dropdown otions
		List<WebElement> dropdownValues = s.getOptions();
		for(WebElement values :dropdownValues)
		{
			String option = values.getText();
			System.out.println(option);
		}
		
		//Click on checkbox
		WebElement checkbox = driver.findElement(By.id("chk_hospotal_readmission"));
		checkbox.click();
		System.out.println(checkbox.isSelected());  //check checkbox is selected or not it will print true if selected
		
		//select radio button
		driver.findElement(By.id("radio_program_medicaid")).click();
		
		//Select Date
		selectDate("3", "December", "2023");
		
		//Add comment
		driver.findElement(By.id("txt_comment")).sendKeys("Hello I am jyotsana");
		
		//Click on book appointment
		driver.findElement(By.id("btn-book-appointment")).click();
		
		//verify appointment confirmation page
		String appointmentCnf = driver.findElement(By.xpath("//h2[text()='Appointment Confirmation']")).getText();
		Assert.assertEquals(appointmentCnf, "Appointment Confirmation");
		
		//Select Date
/*		driver.findElement(By.id("txt_visit_date")).click();
	String monthYear = driver.findElement(By.className("datepicker-switch")).getText();
	List<WebElement> w = driver.findElements(By.className("datepicker-switch"));
	System.out.println(w.size());
	System.out.println(monthYear);
	String month = monthYear.split(" ")[0].trim();
	String year = monthYear.split(" ")[1].trim();
	
/*	while(!(month.equals("December") && year.equals("2023")))
	{
		driver.findElement(By.className("next")).click();
		monthYear = driver.findElement(By.className("datepicker-switch")).getText();
		System.out.println(monthYear);
		month = monthYear.split(" ")[0].trim();
		year = monthYear.split(" ")[1].trim();
	}  
	
	while(!(monthYear.equals("December 2023")))
	{
		driver.findElement(By.className("next")).click();
		monthYear = driver.findElement(By.className("datepicker-switch")).getText();
		System.out.println(monthYear);
	}
	driver.findElement(By.xpath("//td[text()='3']")).click();  */

	}
	
	public static void selectDate(String date, String month, String year)
	{
		//Select Date
		driver.findElement(By.id("txt_visit_date")).click();
	String monthYear = driver.findElement(By.className("datepicker-switch")).getText();
	List<WebElement> w = driver.findElements(By.className("datepicker-switch"));
	System.out.println(w.size());
	System.out.println(monthYear);
	String month1 = monthYear.split(" ")[0].trim();
	String year1 = monthYear.split(" ")[1].trim();
	
	while(!(month1.equals(month) && year1.equals(year)))
	{
		driver.findElement(By.className("next")).click();
		monthYear = driver.findElement(By.className("datepicker-switch")).getText();
		System.out.println(monthYear);
		month1 = monthYear.split(" ")[0].trim();
		year1 = monthYear.split(" ")[1].trim();
	}  
	
	driver.findElement(By.xpath("//td[text()='"+date+"']")).click();
	}

}
