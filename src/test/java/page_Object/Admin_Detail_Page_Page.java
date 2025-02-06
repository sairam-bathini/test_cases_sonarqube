package page_Object;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import test_Base.Admin_BaseClass;

import java.io.File;
import java.util.List;

public class Admin_Detail_Page_Page extends Admin_BaseClass {
    @FindBy(xpath = "//div[text()='Qualifying Site Management']")
    WebElement qualifyingSiteMngmt;
    @FindBy(xpath = "//*[text()='Save Changes']")
    WebElement saveChanges;
    @FindBy(xpath = "(//*[@class='components__Text-sc-1if6yln-0 fuBvBY'])[3]")
    WebElement siteNumber;
    @FindBy(xpath = "//*[text()='City']/following:: input[@class='components__InputStyled-sc-78cfz3-1 juWmLe'][1]")
    WebElement city;
    @FindBy(xpath = "(//div[@class=' css-1hwfws3'])[1]")
    WebElement clickYear;
    @FindBy(xpath = "(//div[@class=' css-1hwfws3'])[2]")
    WebElement clickChamp;

    public void saveCTADisplayedAndFunctioning(String year, String championship) throws Throwable {
        logger = report.startTest("TC-1888 Save CTA is displays");
        log.info("####### TC-1888 Save CTA is displays #######");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", qualifyingSiteMngmt);
        Thread.sleep(3000);
        clickYear.click();
        List<WebElement> yearOptions = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        String yearVal = year;
        for (WebElement option : yearOptions) {
            if ((option.getText()).equals(yearVal)) {
                option.click();
                break;
            }
        }
        clickChamp.click();
        Thread.sleep(1000);
        List<WebElement> champOptions = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        String champVal = championship;
        for (WebElement option : champOptions) {
            if ((option.getText()).equals(champVal)) {
                option.click();
                break;
            }
        }
        Thread.sleep(1000);
        siteNumber.click();
        Thread.sleep(1000);
        saveChanges.click();
        Thread.sleep(3000);
        snapshot = (TakesScreenshot) driver;
        File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/Details Page/TC-1888 Save CTA.png"));
        Thread.sleep(8000);
        city.sendKeys(Keys.CONTROL+"a");
        city.sendKeys(Keys.DELETE);
        saveChanges.click();
        Thread.sleep(1000);
        File screenShot1 = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot1, new File(System.getProperty("user.dir") + "/target/ScreenShots/Details Page/TC-1888 Save CTA Error.png"));
        if (saveChanges.isDisplayed()) {
            log.info("####### TC-1888 Save CTA is displays #######");
            logger.log(LogStatus.PASS, "TC-1888 Save CTA is displays");
            logger.log(LogStatus.INFO, "Save CTA is displayed and functioning as expected");
        } else {
            log.info("####### TC-1888 Save CTA is displays #######");
            logger.log(LogStatus.FAIL, "TC-1888 Save CTA is displays");
            logger.log(LogStatus.INFO, "Save CTA is displayed and not functioning as expected");
        }
    }
}
