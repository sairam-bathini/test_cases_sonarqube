package page_Object;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import test_Base.Admin_BaseClass;

import java.io.File;
import java.util.List;

public class Admin_Event_Details_Bulk_Withdraw_Page extends Admin_BaseClass {
    public Admin_Event_Details_Bulk_Withdraw_Page(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//div[text()='Championship Management']")
    WebElement clickChampMngmt;
    @FindBy(xpath = "(//div[@class=' css-1hwfws3'])[1]")
    WebElement clickYear;
    @FindBy(xpath = "//*[text()='Bulk Withdraw/Refund']")
    WebElement bulkWithdraw;
    @FindBy(xpath = "//*[text()='Rows per page:']/following :: div[@class=' css-tlfecz-indicatorContainer']")
    WebElement rowsPage;
    @FindBy(xpath = "//*[@class='FlexWrapper__StyledFlexWrapper-jk1687-0 ckWAFH']")
    WebElement paginationValues;
    @FindBy(xpath = "//*[contains(@class,'components__PaginationButton')][1]")
    WebElement nextPageFirstClick;
    @FindBy(xpath = "//*[contains(@class,'components__PaginationButton')][1]")
    WebElement prevPage;
    @FindBy(xpath = "//*[contains(@class,'components__PaginationButton')][2]")
    WebElement nextPage;


    public void tablePaginationIsDisplayedAndfunctioning(String year, String championship, String pageNumber) throws Throwable {
        logger = report.startTest("TC-1890 Table Pagination is displayed and functioning ");
        log.info("####### TC-1890 Table Pagination is displayed and functioning #######");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", clickChampMngmt);
        Thread.sleep(4000);
        clickYear.click();
        List<WebElement> yearOptions = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        String yearVal = year;
        for (WebElement option : yearOptions) {
            if ((option.getText()).equals(yearVal)) {
                option.click();
                break;
            }
        }
        List<WebElement> champOptions = driver.findElements(By.xpath("//div[@class='components__Text-sc-1if6yln-0 hJlldQ']"));
        String champVal = championship;
        for (WebElement option : champOptions) {
            if ((option.getText()).equals(champVal)) {
                option.click();
                break;
            }
        }

        js.executeScript("arguments[0].click();", bulkWithdraw);
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(950, 1900)");
        rowsPage.click();
        Thread.sleep(2000);
        List<WebElement> rowsOptions = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        String rowsVal = pageNumber;
        for (WebElement option : rowsOptions) {
            if ((option.getText()).equals(rowsVal)) {
                option.click();
                break;
            }
        }
        System.out.println(paginationValues.getText());
        js.executeScript("window.scrollBy(950, 1900)");
        if (nextPageFirstClick.isDisplayed()) {
            js.executeScript("window.scrollBy(950, 1900)");
            nextPageFirstClick.click();
            Thread.sleep(1000);
            nextPage.click();
            Thread.sleep(2000);
        }
        js.executeScript("window.scrollBy(950, 1900)");
        if (prevPage.isDisplayed()) {
            js.executeScript("window.scrollBy(950, 1900)");
            prevPage.click();
            Thread.sleep(2000);
        }
        js.executeScript("window.scrollBy(950, 1900)");
        rowsPage.click();
        snapshot = (TakesScreenshot) driver;
        File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/Event Details Bulk Withdraw/TC-1890 Table Pagination.png"));

        if (paginationValues.isDisplayed()) {
            log.info("####### TC-1890 Table Pagination is displayed and functioning #######");
            logger.log(LogStatus.PASS, "TC-1890 Table Pagination is displayed and functioning");
            logger.log(LogStatus.INFO, "Table Pagination is displayed and functioning as expected");
        } else {
            log.info("####### TTC-1890 Table Pagination is displayed and functioning #######");
            logger.log(LogStatus.FAIL, "TC-1890 Table Pagination is displayed and functioning");
            logger.log(LogStatus.INFO, "Table Pagination is not functioning as expected ");
        }
    }
}
