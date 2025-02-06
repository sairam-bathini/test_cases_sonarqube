package page_Object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test_Base.Admin_BaseClass;

import java.time.Duration;

public class Admin_Login_Page extends Admin_BaseClass {
	WebDriver driver;

	public Admin_Login_Page(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//input[@placeholder='yours@example.com']")
	WebElement emailID;
	@FindBy(xpath = "//input[@placeholder='your password']")
	WebElement password;
	@FindBy(xpath = "//button[@name='submit']")
	WebElement logIn;

	public void loginMethod(String emailId, String pswd) throws Throwable {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.elementToBeClickable(emailID));
		emailID.sendKeys(emailId);
		password.sendKeys(pswd);
		Thread.sleep(1000);
		logIn.click();
		Thread.sleep(2000);
		log.info("##### Login Successful with : "+emailId+" and " +pswd+" #####");
		System.out.println("##### Login Successful with : "+emailId+" and " +pswd+" #####");
	}
}
