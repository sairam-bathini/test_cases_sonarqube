package page_Object;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test_Base.Admin_BaseClass;

import java.time.Duration;

public class Admin_Logout_Page extends Admin_BaseClass {
    WebDriver driver;

    public Admin_Logout_Page(WebDriver driver) {
        this.driver = driver;
    }


    @FindBy(xpath = "//span[@class='components__Text-sc-1if6yln-0 bYNJvw']/div")
    WebElement clickProfile;
    @FindBy(xpath = "//*[text()='My Profile']")
    WebElement clickMyProfile;
    @FindBy(xpath = "//*[text()='Sign Out']")
    WebElement clicksignout;

    public void logOut() {
       // js.executeScript("arguments[0].scrollIntoView(true);", clickProfile);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        wait.until(ExpectedConditions.elementToBeClickable(clickProfile));

        js.executeScript("arguments[0].scrollIntoView(true);", clickProfile);
        js.executeScript("arguments[0].click();", clickProfile);

        wait.until(ExpectedConditions.elementToBeClickable(clickMyProfile));
        js.executeScript("arguments[0].click();", clickMyProfile);

        wait.until(ExpectedConditions.elementToBeClickable(clicksignout));
        js.executeScript("arguments[0].click();", clicksignout);
    }


}
