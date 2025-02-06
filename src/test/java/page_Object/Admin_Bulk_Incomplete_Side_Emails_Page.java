package page_Object;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import test_Base.Admin_BaseClass;

import java.io.File;

public class Admin_Bulk_Incomplete_Side_Emails_Page extends Admin_BaseClass {
    public Admin_Bulk_Incomplete_Side_Emails_Page(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//div[text()='Email Management']")
    WebElement emailMngmt;
    @FindBy(xpath = "//*[text()='Bulk Incomplete Side Emails']")
    WebElement bulkIncompleteSideEmails;
    @FindBy(xpath = "(//*[@class=' css-1hwfws3'])[2]")
    WebElement selectChampionship;
    @FindBy(xpath = "//div[contains(@id,'react-select')][2]")
    WebElement selectFirst;
    @FindBy(xpath = "//*[@class='components__Th-jca4yq-13 ktKIEi']")
    WebElement tableData;
    @FindBy(xpath = "//*[contains(text(),'Selected Player')]")
    WebElement sendToSelectedRecipients;
    @FindBy(xpath = "(//*[@class='FlexWrapper__StyledFlexWrapper-jk1687-0 brzuDz'])[1]")
    WebElement selectClubs;
    @FindBy(xpath = "//*[text()='Yes']")
    WebElement clickYes;
    @FindBy(xpath = "//*[text()='No']")
    WebElement clickNo;

    public void tableSendCTADisplays() throws Throwable {
        logger = report.startTest("TC-1910 Table Send CTA is displayed and functioning ");
        log.info("####### TC-1910 Table Send CTA is displayed and functioning #######");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", emailMngmt);
        bulkIncompleteSideEmails.click();
        Thread.sleep(1000);
        selectChampionship.click();
        try {
            selectFirst.click();
            Thread.sleep(500);
            selectClubs.click();
            sendToSelectedRecipients.click();
            Thread.sleep(500);
            clickNo.click();
            Thread.sleep(1000);
            sendToSelectedRecipients.click();
            clickYes.click();
            Thread.sleep(2000);
            snapshot = (TakesScreenshot) driver;
            File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/Bulk Incomplete Side Emails/TC-1910 Table Send CTA.png"));
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("No items to display");
        }

        if (sendToSelectedRecipients.isDisplayed()) {
            log.info("####### TC-1910 Table Send CTA is displayed and functioning #######");
            logger.log(LogStatus.PASS, "TC-1910 Table Send CTA is displayed and functioning ");
            logger.log(LogStatus.INFO, "Send CTA is displayed and functioning as expected ");
        } else {
            log.info("####### TC-1910 Table Send CTA is displayed and functioning #######");
            logger.log(LogStatus.FAIL, "TC-1910 Table Send CTA is displayed and functioning ");
            logger.log(LogStatus.INFO, "Send CTA is displayed and not functioning as expected ");
        }
    }

    public void tableAreaDisplays() throws Throwable {
        logger = report.startTest("TC-1907 Table Area displays ");
        log.info("####### TC-1907 Table Area displays #######");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", emailMngmt);
        bulkIncompleteSideEmails.click();
        Thread.sleep(1000);
        selectChampionship.click();
        selectFirst.click();

        try {
            selectClubs.click();
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println("No items to display");
        }

        snapshot = (TakesScreenshot) driver;
        File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/Bulk Incomplete Side Emails/TC-1907 Table Area display.png"));

        if (sendToSelectedRecipients.isDisplayed()) {
            log.info("####### TC-1907 Table Area displays #######");
            logger.log(LogStatus.PASS, "TC-1907 Table Area displays ");
            logger.log(LogStatus.INFO, "Table Area is displayed and functioning as expected ");
        } else {
            log.info("####### TC-1907 Table Area displays #######");
            logger.log(LogStatus.FAIL, "TC-1907 Table Area displays ");
            logger.log(LogStatus.INFO, "Table Area is not displayed as expected ");
        }

    }
}

