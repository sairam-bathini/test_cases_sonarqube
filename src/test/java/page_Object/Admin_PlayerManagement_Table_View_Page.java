package page_Object;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import test_Base.Admin_BaseClass;

import java.io.File;
import java.util.List;

public class Admin_PlayerManagement_Table_View_Page extends Admin_BaseClass {
    WebDriverWait wait;


    public Admin_PlayerManagement_Table_View_Page(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//div[text()='Player Management']")
    WebElement clickPlayerMngmt;
    @FindBy(xpath = "//input[@class='components__InputStyled-sc-78cfz3-1 juWmLe Searchbar__Input-co7tvo-1 GUUaa']")
    WebElement search;
    @FindBy(xpath = "//*[contains(@class,'SearchIcon')]")
    WebElement clickSearch;
    @FindBy(xpath = "//*[text()='No items to display']")
    WebElement noItemsToDisplay;
    @FindBy(xpath = " (//div[@class=' css-1hwfws3'])[1]")
    WebElement clickFilter;
    @FindBy(xpath = "//*[text()='Export']")
    WebElement clickExport;
    @FindBy(xpath = "(//div[@class=' css-tlfecz-indicatorContainer'])[2]")
    WebElement clickPagination;
    @FindBy(xpath = "//*[@class='FlexWrapper__StyledFlexWrapper-jk1687-0 kgnCTx ContentContainer__ContentContainerStyled-f4ze47-0 jAhnmz']/div")
    WebElement tableArea;
    @FindBy(xpath = "//*[@class='FlexWrapper__StyledFlexWrapper-jk1687-0 jBaDaB components__ChildrenWrapper-sc-5xr1xw-2 hMvWUv']")
    WebElement automergeText;
    @FindBy(xpath = "//*[contains(@class,'components__StyledTable')]/tbody")
    WebElement searchData;
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public void searchDisplay(String searchData) throws Throwable {
        logger = report.startTest("Player Management Table - TC-1819 Search displays ");
        log.info("####### Executing TC-1819 Search displays  #######");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", clickPlayerMngmt);
        Thread.sleep(1000);
        search.sendKeys(searchData);
        Thread.sleep(100);
        clickSearch.click();
        Thread.sleep(3200);
        List<WebElement> playersData = this.searchData.findElements(By.tagName("tr"));
        snapshot = (TakesScreenshot) driver;
        File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/Player Management/TC-1819 Search Results.png"));
        if (playersData.size() > 2) {
            log.info("####### TC-1819 The results of the search is not displayed in updated table #######");
            logger.log(LogStatus.PASS, "TC-1819 Search displays ");
            logger.log(LogStatus.INFO, "The results of the search displayed in updated table");
        } else if (playersData.size() == 2) {
            String msg = noItemsToDisplay.getText();
            log.info(msg + "####### TC-1819 The results of the search displayed in updated table #######");
            logger.log(LogStatus.FAIL, "TC-1819 Search displays ");
            logger.log(LogStatus.INFO, "The results of the search is not displayed in updated table");
        } else {
            log.info("####### TC-1819 The results of the search displayed in updated table #######");
            logger.log(LogStatus.FAIL, "TC-1819 Search displays ");
            logger.log(LogStatus.INFO, "The results of the search is not displayed in updated table");
        }


//
//        search.sendKeys(Keys.CONTROL + "a");
//        search.sendKeys(Keys.DELETE);
//        search.sendKeys("11268002");
//        clickSearch.click();
//        Thread.sleep(1000);
//        File screenShot1 = snapshot.getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(screenShot1, new File(System.getProperty("user.dir") + "/ScreenShots/SearchResultID.png"));
//        Thread.sleep(2000);


    }

    public void filterDropdown() throws Throwable {
        logger = report.startTest("Player Management Table - TC-1827 Filters dropdown displays ");
        log.info("####### Executing TC-1827 Filters dropdown displays #######");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", clickPlayerMngmt);
        clickFilter.click();
        List<WebElement> reportOptions = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        String reportVal = "ADA Request";
        for (WebElement option : reportOptions) {
            System.out.println(option.getText());
        }

        for (WebElement option : reportOptions) {
            if ((option.getText()).equals(reportVal)) {
                option.click();
                break;
            }
        }
        Thread.sleep(2000);
        snapshot = (TakesScreenshot) driver;
        File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/Player Management/TC-1827 clickFilter.png"));

        clickFilter.click();
        reportOptions = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        for (WebElement option : reportOptions) {
            if ((option.getText()).equals("Duplicate")) {
                option.click();
                break;
            }
        }
        Thread.sleep(2500);
        snapshot = (TakesScreenshot) driver;
        File screenShot1 = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot1, new File(System.getProperty("user.dir") + "/target/ScreenShots/Player Management/TC-1827 clickFilter.png"));
        Thread.sleep(1000);
        String filterValue = clickFilter.getText();
        System.out.println(filterValue);
        if (filterValue.contains("Duplicate")) {
            log.info(filterValue + "####### TC-1827 Filter which is selected is displayed in the drop down button by default along with the count of players that match the filter. #######");
            logger.log(LogStatus.PASS, "TC-1827 Filters dropdown displays ");
            logger.log(LogStatus.INFO, "Filter which is selected is displayed in the drop down button by default along with the count of players that match the filter.");
        } else {
            log.info(filterValue + "####### TC-1827 Filter which is selected is not displayed in the drop down button by default along with the count of players that match the filter. #######");
            logger.log(LogStatus.FAIL, "TC-1827 Filters dropdown displays ");
            logger.log(LogStatus.INFO, "Filter which is selected is not displayed in the drop down button by default along with the count of players that match the filter.");
        }


    }

    public void exportCTA() throws Throwable {
        logger = report.startTest("Player Management Table - TC-1833 Export CTA button displays ");
        log.info("####### Executing TC-1833 Export CTA button displays #######");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", clickPlayerMngmt);
        clickFilter.click();

        List<WebElement> reportOptions = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        String reportVal = "Cleared";
        for (WebElement option : reportOptions) {
            if ((option.getText()).equals("Duplicate")) {
                option.click();
                Thread.sleep(2000);
                break;
            }
        }
        Thread.sleep(1000);
        snapshot = (TakesScreenshot) driver;
        File screenShot1 = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot1, new File(System.getProperty("user.dir") + "/target/ScreenShots/Player Management/TC-1833 PlayerExport.png"));
        try {
            if (clickExport.isDisplayed()) {
                clickExport.click();
                log.info("####### TC-1833 Export button is available/clickable #######");
                logger.log(LogStatus.PASS, "TC-1833 Export CTA button displays");
                logger.log(LogStatus.INFO, "Export button is available/clickable");

            } else {
                log.info("####### TC-1833 Export button is not available/clickable #######");
                logger.log(LogStatus.FAIL, "TC-1833 Export CTA button displays");
                logger.log(LogStatus.INFO, "Export button is not available/clickable");
            }
        } catch (Exception e) {
            System.out.println("---------Running in catch block---------");
            log.info("####### TC-1833 Export button is not available/clickable #######");
            logger.log(LogStatus.FAIL, "TC-1833 Export CTA button displays");
            logger.log(LogStatus.INFO, "Export button is not available/clickable");
        }

        Thread.sleep(2000);

    }

    public void tableArea() throws Throwable {
        logger = report.startTest("Player Management Table - TC-1863 Table area displays  ");
        log.info("####### Executing TC-1863 Table area displays #######");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", clickPlayerMngmt);
        Thread.sleep(2000);
        snapshot = (TakesScreenshot) driver;
        File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/Player Management/TC-1863 PlayerMgmtArea.png"));
        Thread.sleep(2000);

        js.executeScript("arguments[0].scrollIntoView(true);", clickPagination);
        File screenShot1 = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot1, new File(System.getProperty("user.dir") + "/target/ScreenShots/Player Management/TC-1863 PlayerMgmtArea1.png"));
        Thread.sleep(2000);
        List<WebElement> reportOptions = tableArea.findElements(By.tagName("div"));
        String thead = automergeText.getText();
        String tlastRow = reportOptions.get(2).getText();
        System.out.println(thead);
        if (thead.contains("Export")) {
            log.info("####### TC-1869 The table area includes : Search, Filters,Auto-merge, Export, Grid Column Headers, Grid Rows, Pagination  #######");
            logger.log(LogStatus.PASS, "TC-1863 Table area displays ");
            logger.log(LogStatus.INFO, "The table area includes : Search, Filters,Auto-merge, Export, Grid Column Headers, Grid Rows, Pagination ");
        } else {
            log.info("####### TC-1869 The table area not displays : Search, Filters,Auto-merge, Export, Grid Column Headers, Grid Rows, Pagination  #######");
            logger.log(LogStatus.FAIL, "TC-1863 Table area displays ");
            logger.log(LogStatus.INFO, "The table area not displays : Search, Filters,Auto-merge, Export, Grid Column Headers, Grid Rows, Pagination ");
        }

    }
}
