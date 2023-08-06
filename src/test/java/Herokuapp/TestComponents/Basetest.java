package Herokuapp.TestComponents;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Herokuapp.PageObject.Login;

public class Basetest {

	public WebDriver driver;

	public WebDriver initializeDriver() {
//		Options options = new ChromeOptions();
//		options.addArguments("--start-maximized");
//		WebDriver driver = new ChromeDriver(options);	
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		return driver;
	}

	public Login launchApplication() {
		driver = initializeDriver();
		Login login = new Login(driver);
		login.goTo();
		return login;
	}

}
