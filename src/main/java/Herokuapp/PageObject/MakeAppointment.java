package Herokuapp.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MakeAppointment {

	Select s;
	WebDriver driver;

	public MakeAppointment(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "combo_facility")
	WebElement dropdown;

	@FindBy(id = "chk_hospotal_readmission")
	WebElement checkbox;

	@FindBy(id = "radio_program_medicaid")
	WebElement radioButton;

	@FindBy(id = "txt_visit_date")
	WebElement dateField;

	@FindBy(className = "datepicker-switch")
	WebElement datePicker;

	@FindBy(className = "next")
	WebElement nextArrow;

	@FindBy(id = "txt_comment")
	WebElement commentBox;

	@FindBy(id = "btn-book-appointment")
	WebElement bookAptButton;

	// Select dropdown
	public void selectFacility() {
		// WebElement dropdown = driver.findElement(By.id("combo_facility"));
		s = new Select(dropdown);
		s.selectByValue("Seoul CURA Healthcare Center");
		System.out.println("Selected dropdown is: " + s.getFirstSelectedOption().getText());
		getDropdownOptions();
	}

	// get all the dropdown otions
	public void getDropdownOptions() {
		List<WebElement> dropdownValues = s.getOptions();
		for (WebElement values : dropdownValues) {
			String option = values.getText();
			System.out.println(option);
		}
	}

	public void selectCheckbox() {
		// Click on checkbox
		checkbox.click();
		System.out.println(checkbox.isSelected()); // check checkbox is selected or not it will print true if selected
	}

	public void selectRadioButton() {
		// select radio button
		radioButton.click();
	}

	public void selectDate(String date, String month, String year) {
		// Select Date
		dateField.click();
		String monthYear = datePicker.getText();
		System.out.println(monthYear);
		String month1 = monthYear.split(" ")[0].trim();
		String year1 = monthYear.split(" ")[1].trim();

		while (!(month1.equals(month) && year1.equals(year))) {
			nextArrow.click();
			monthYear = datePicker.getText();
			System.out.println(monthYear);
			month1 = monthYear.split(" ")[0].trim();
			year1 = monthYear.split(" ")[1].trim();
		}

		driver.findElement(By.xpath("//td[text()='" + date + "']")).click();
	}

	public void addComment(String comment) {
		// add comment
		commentBox.sendKeys(comment);
	}

	public ConfirmationPage clickOnBookAppointmentButton() {
		// Click on book appointment
		bookAptButton.click();
		ConfirmationPage confirmationPage = new ConfirmationPage(driver);
		return confirmationPage;
	}
}
