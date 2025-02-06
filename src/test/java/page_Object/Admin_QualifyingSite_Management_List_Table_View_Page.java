package page_Object;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import test_Base.Admin_BaseClass;

import java.io.File;
import java.util.List;

public class Admin_QualifyingSite_Management_List_Table_View_Page extends Admin_BaseClass {
    public Admin_QualifyingSite_Management_List_Table_View_Page(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//div[text()='Qualifying Site Management']")
    WebElement qualifyingSiteMngmt;
    @FindBy(xpath = "//*[text()='Add site']")
    WebElement addSite;
    @FindBy(xpath = "//*[text()='Site Number']/following:: input[@class='components__InputStyled-sc-78cfz3-1 juWmLe'][1]")
    WebElement siteNumber;
    @FindBy(xpath = "//*[@class='components__Th-jca4yq-13 ktKIEi']")
    WebElement tableColumn;
    @FindBy(xpath = "(//div[@class=' css-1hwfws3'])[1]")
    WebElement clickYear;
    @FindBy(xpath = "(//div[@class=' css-1hwfws3'])[2]")
    WebElement clickChamp;
    @FindBy(xpath = "(//*[@class='Checkbox__Wrapper-sc-1xms6td-0 jibKrv'])[1]")
    WebElement checkAll;
    @FindBy(xpath = "//*[text()='Download Players']")
    WebElement downloadPlayers;
    @FindBy(xpath = "//*[text()='Close Selected']")
    WebElement closeSelected;
    @FindBy(xpath = "(//*[@class='Checkbox__Wrapper-sc-1xms6td-0 jibKrv'])[3]")
    WebElement checkFirstRow;
    @FindBy(xpath = "//input[@class='components__InputStyled-sc-78cfz3-1 juWmLe Searchbar__Input-co7tvo-1 GUUaa']")
    WebElement search;
    @FindBy(xpath = "//*[@class='components__Tr-jca4yq-12 dcuOkE'][1]")
    WebElement searchData1;
    @FindBy(xpath = "//*[text()='Export']")
    WebElement export;

    public void addSiteCTADisplayedAndFunctioning() throws Throwable {
        logger = report.startTest("TC-1891 Add Site CTA is displayed and functioning");
        log.info("####### TC-1891 Add Site CTA is displayed and functioning #######");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", qualifyingSiteMngmt);
        Thread.sleep(3000);
        js.executeScript("arguments[0].click();", addSite);
        Thread.sleep(500);
        snapshot = (TakesScreenshot) driver;
        File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/QualifyingSite Management/TC-1891 Add Site.png"));
        if (siteNumber.isDisplayed()) {
            log.info("####### TC-1891 Add Site CTA is displayed and functioning #######");
            logger.log(LogStatus.PASS, "TC-1891 Add Site CTA is displayed and functioning");
            logger.log(LogStatus.INFO, "Add Site CTA is displayed and functioning as expected");
        } else {
            log.info("####### TC-1891 Add Site CTA is displayed and functioning #######");
            logger.log(LogStatus.FAIL, "TC-1891 Add Site CTA is displayed and functioning");
            logger.log(LogStatus.INFO, "Add Site CTA is not functioning as expected");
        }
    }

    public void tableAreaTableTitlearedisplayedandfunctioning(String year, String championship) throws Throwable {
        logger = report.startTest("TC-1893 Table Area, Table Title are displayed and functioning");
        log.info("####### TC-1893 Table Area, Table Title are displayed and functioning #######");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", qualifyingSiteMngmt);
        Thread.sleep(3000);
        String tableColumnData = tableColumn.getText();
        snapshot = (TakesScreenshot) driver;
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
        Thread.sleep(3000);
        File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/QualifyingSite Management/TC-1893 Table Area.png"));
        if (tableColumnData.contains("Qualifying Type")) {
            log.info("####### TC-1893 Table Area, Table Title are displayed and functioning #######");
            logger.log(LogStatus.PASS, "TC-1893 Table Area, Table Title are displayed and functioning");
            logger.log(LogStatus.INFO, "Table Area, Table Title are displayed and functioning as expected");
        } else {
            log.info("####### TC-1891 Add Site CTA is displayed and functioning #######");
            logger.log(LogStatus.FAIL, "TC-1891 Add Site CTA is displayed and functioning");
            logger.log(LogStatus.INFO, "Table Area, Table Title are not displayed as expected");
        }
    }

    public void downloadPlayersIsDisplayedandFunctioning(String year, String championship) throws Throwable {
        logger = report.startTest("TC-1896 Download Players is displayed and functioning");
        log.info("####### TC-1896 Download Players is displayed and functioning #######");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", qualifyingSiteMngmt);
        Thread.sleep(3000);
        snapshot = (TakesScreenshot) driver;
        clickYear.click();
        List<WebElement> yearOptions = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        String yearVal = year;
        for (WebElement option : yearOptions) {
            if ((option.getText()).equals(yearVal)) {
                option.click();
                break;
            }
        }
        Thread.sleep(1000);
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
        Thread.sleep(3000);
        checkAll.click();
        Thread.sleep(500);
        downloadPlayers.click();
        snapshot = (TakesScreenshot) driver;
        Thread.sleep(4000);
        File screenShot1 = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot1, new File(System.getProperty("user.dir") + "/target/ScreenShots/QualifyingSite Management/TC-1896 Download Button.png"));

        if (downloadPlayers.isDisplayed()) {
            log.info("####### TC-1896 Download Players is displayed and functioning #######");
            logger.log(LogStatus.PASS, "TC-1896 Download Players is displayed and functioning");
            logger.log(LogStatus.INFO, "Download Players is displayed and functioning as expected");
        } else {
            log.info("####### TC-1896 Download Players is displayed and functioning #######");
            logger.log(LogStatus.FAIL, "TC-1896 Download Players is displayed and functioning");
            logger.log(LogStatus.INFO, "Download Players button is not functioning as expected");
        }
    }

    public void closeQualifyingSiteCTAIsDisplayedandFunctioning(String year, String championship) throws Throwable {
        logger = report.startTest("TC-1902 Close Qualifying Site CTA is displayed and functioning");
        log.info("####### TC-1902 Close Qualifying Site CTA is displayed and functioning #######");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", qualifyingSiteMngmt);
        Thread.sleep(5000);
        String tableColumnData = tableColumn.getText();
        snapshot = (TakesScreenshot) driver;
        clickYear.click();
        List<WebElement> yearOptions = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        String yearVal = year;
        for (WebElement option : yearOptions) {
            if ((option.getText()).equals(yearVal)) {
                option.click();
                break;
            }
        }
        Thread.sleep(1000);
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
        Thread.sleep(3000);
        checkFirstRow.click();
        js.executeScript("arguments[0].scrollIntoView(true);", closeSelected);
        Thread.sleep(1000);
        closeSelected.click();
        File screenShot1 = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot1, new File(System.getProperty("user.dir") + "/target/ScreenShots/QualifyingSite Management/TC-1902 Close QualifyingSite.png"));
        if (tableColumnData.contains("Qualifying Type")) {
            log.info("####### TC-1902 Close Qualifying Site CTA is displayed and functioning #######");
            logger.log(LogStatus.PASS, "TC-1902 Close Qualifying Site CTA is displayed and functioning");
            logger.log(LogStatus.INFO, "Close Qualifying Site CTA is displayed and functioning as expected");
        } else {
            log.info("####### TC-1902 Close Qualifying Site CTA is displayed and functioning #######");
            logger.log(LogStatus.FAIL, "TC-1902 Close Qualifying Site CTA is displayed and functioning");
            logger.log(LogStatus.INFO, "Close Qualifying Site CTA is not displayed as expected");
        }
    }

    public void Searchfiledisdisplayedandfunctioning(String year, String championship, String searchData) throws Throwable {
        logger = report.startTest("TC-2988 Search filed is displayed and functioning");
        log.info("####### TC-2988 Search filed is displayed and functioning #######");
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
        Thread.sleep(1000);
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
        Thread.sleep(2000);
        search.sendKeys(searchData);
        Thread.sleep(2000);
        snapshot = (TakesScreenshot) driver;
        File screenShot1 = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot1, new File(System.getProperty("user.dir") + "/target/ScreenShots/QualifyingSite Management/TC-2988 Search filed.png"));
        String data = searchData1.getText();
        if (data.contains(searchData)) {
            log.info("####### TC-2988 Search filed is displayed and functioning #######");
            logger.log(LogStatus.PASS, "TC-2988 Search filed is displayed and functioning");
            logger.log(LogStatus.INFO, "Search filed is displayed and functioning as expected");
        } else {
            log.info("####### TC-1902 Close Qualifying Site CTA is displayed and functioning #######");
            logger.log(LogStatus.FAIL, "TC-1902 Close Qualifying Site CTA is displayed and functioning");
            logger.log(LogStatus.INFO, "Search filed is displayed and data enetered in Search field is not displayed");
        }
    }

    public void exportCTAIsDisplayedAndFunctioning(String year, String championship) throws Throwable {
        logger = report.startTest("TC-2989 Export CTA displays and functioning");
        log.info("####### TC-2989 Export CTA displays and functioning #######");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", qualifyingSiteMngmt);
        Thread.sleep(3000);
        snapshot = (TakesScreenshot) driver;
        clickYear.click();
        List<WebElement> yearOptions = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        String yearVal = year;
        for (WebElement option : yearOptions) {
            if ((option.getText()).equals(yearVal)) {
                option.click();
                break;
            }
        }
        Thread.sleep(1000);
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
        Thread.sleep(3000);
        checkAll.click();
        Thread.sleep(500);
        export.click();
        snapshot = (TakesScreenshot) driver;
        Thread.sleep(4000);
        File screenShot1 = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot1, new File(System.getProperty("user.dir") + "/target/ScreenShots/QualifyingSite Management/TC-1896 Download Button.png"));

        if (export.isDisplayed()) {
            log.info("####### TC-2989 Export CTA displays and functioning #######");
            logger.log(LogStatus.PASS, "TC-2989 Export CTA displays and functioning");
            logger.log(LogStatus.INFO, "Export CTA is displayed and functioning as expected");
        } else {
            log.info("####### TC-2989 Export CTA displays and functioning #######");
            logger.log(LogStatus.FAIL, "TC-2989 Export CTA displays and functioning");
            logger.log(LogStatus.INFO, "Export CTA button is not functioning as expected");
        }
    }
}
