package page_Object;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import test_Base.Admin_BaseClass;

import java.io.File;
import java.util.List;

public class Admin_Application_Mngt_ListView_Page extends Admin_BaseClass {

    WebDriverWait wait;

    public Admin_Application_Mngt_ListView_Page(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//div[text()='Application Management']")
    WebElement clickAppMngmt;
    @FindBy(xpath = "(//div[@class=' css-1hwfws3'])[1]")
    WebElement clickYear;
    @FindBy(xpath = "//div[text()='Select a Championship']")
    WebElement clickChampionship;
    @FindBy(xpath = "//div[text()='Total Entries']")
    WebElement clickStatus;
    @FindBy(xpath = "//input[@class='components__InputStyled-sc-78cfz3-1 juWmLe Searchbar__Input-co7tvo-1 GUUaa']")
    WebElement search;
    @FindBy(xpath = "//tr[@class='components__Th-jca4yq-13 ktKIEi']")
    WebElement tableHeaders;
    @FindBy(xpath = "(//*[text()='First Name'])[1]")
    WebElement firstName;

    public void yearAndNameSelection(String year, String championship) throws Throwable {
        logger = report.startTest("TC-1820 'Year' and 'Name' of the Championship can be selected from the drop-downs ");
        log.info("####### Executing TC-1820 'Year' and 'Name' of the Championship #######");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", clickAppMngmt);
        clickYear.click();
        List<WebElement> yearOptions = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        String yearVal = year;
        for (WebElement option : yearOptions) {
            if ((option.getText()).equals(yearVal)) {
                option.click();
                break;
            }
        }
        Thread.sleep(5000);
        clickChampionship.click();
        List<WebElement> champOptions = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        String champVal = championship;
        for (WebElement option : champOptions) {
            if ((option.getText()).equals(champVal)) {
                option.click();
                break;
            } else {

            }
        }
        if (firstName.isDisplayed()) {
            log.info("####### TC-1820 'Year' and 'Name' of the Championship can be selected from the drop-downs #######");
            logger.log(LogStatus.PASS, "TC-1820 'Year' and 'Name' is clickable ");
            logger.log(LogStatus.INFO, "Year and Name dropdowns are clicking and respected data is displayed");
        } else {
            log.info("####### TC-1820 'Year' and 'Name' of the Championship can be selected from the drop-downs #######");
            logger.log(LogStatus.FAIL, "TC-1820 'Year' and 'Name' is clickable ");
            logger.log(LogStatus.INFO, "Year and Name dropdowns are not clicking");
        }

        Thread.sleep(2000);
    }

    public void filtersDropdownDisplay(String year, String championship, String status) throws Throwable {
        logger = report.startTest("TC-1825 Filters dropdown is displayed and functioning ");
        log.info("####### TC-1825 Filters dropdown is displayed and functioning #######");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", clickAppMngmt);
        clickYear.click();
        List<WebElement> yearOptions = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        String yearVal = year;
        for (WebElement option : yearOptions) {
            if ((option.getText()).equals(yearVal)) {
                option.click();
                break;
            }
        }
        Thread.sleep(5000);
        clickChampionship.click();
        List<WebElement> champOptions = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        String champVal = championship;
        for (WebElement option : champOptions) {
            if ((option.getText()).equals(champVal)) {
                option.click();
                break;
            }
        }
        Thread.sleep(2000);

        clickStatus.click();
        List<WebElement> Options = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        String Val = status;
        for (WebElement option : Options) {
            System.out.println(option.getText());
        }
        System.out.println("###########################################");
        for (WebElement option : Options) {
            if ((option.getText()).equals(Val)) {
                option.click();
                snapshot = (TakesScreenshot) driver;
                File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/Application Management/TC-1825 FiltersDropdownDisplay.png"));
                break;
            }
        }
        if (firstName.isDisplayed()) {
            log.info("####### TC-1825 Filters dropdown is displayed and functioning #######");
            logger.log(LogStatus.PASS, "TC-1825 filters dropdown displays");
            logger.log(LogStatus.INFO, "Able to select the filters dropdown and respected data is visible");
        } else {
            log.info("####### TC-1825 Filters dropdown is displayed and functioning #######");
            logger.log(LogStatus.FAIL, "TC-1825 filters dropdown displays");
            logger.log(LogStatus.INFO, "Unable to select the filters dropdown and respected data is visible");
        }
        Thread.sleep(3000);

    }

    public void searchBarDisplay(String year, String championship, String searchData) throws Throwable {
        logger = report.startTest("TC-1832 Search bar is displayed and functioning ");
        log.info("####### TC-1832 Search bar is displayed and functioning #######");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", clickAppMngmt);
        clickYear.click();
        List<WebElement> yearOptions = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        String yearVal = year;
        for (WebElement option : yearOptions) {
            if ((option.getText()).equals(yearVal)) {
                option.click();
                break;
            }
        }
        Thread.sleep(5000);
        clickChampionship.click();
        List<WebElement> champOptions = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        String champVal = championship;
        for (WebElement option : champOptions) {
            if ((option.getText()).equals(champVal)) {
                option.click();
                break;
            }
        }
        search.sendKeys(searchData);
        List<WebElement> value = driver.findElements(By.xpath("//*[@class='Icon__CheckboxUncheckedIcon-sc-1b8stld-5 dJEkSc']"));
        Thread.sleep(2000);
        if (value.size() > 2) {
            System.out.println("Entered data is correct");
            Thread.sleep(1000);
            snapshot = (TakesScreenshot) driver;
            File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/Application Management/TC-1832 SearchData.png"));

            log.info("####### TC-1832 Search bar is displayed and functioning #######");
            logger.log(LogStatus.PASS, "TC-1832 Search bar is displayed and functioning");
            logger.log(LogStatus.INFO, "Able to search the Player data in the Search bar");
        } else {
            System.out.println(driver.findElement(By.xpath("//*[text()='No items to display']")).getText());
            Thread.sleep(1000);
            snapshot = (TakesScreenshot) driver;
            File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/Application Management/TC-1832 SearchData.png"));
            log.info("####### TC-1832 Search bar is displayed and functioning #######");
            logger.log(LogStatus.FAIL, "TC-1832 Search bar is displayed and functioning");
            logger.log(LogStatus.INFO, "Please enter the correct data in the Search bar");
        }

    }

    public void tableAreaDisplay() throws Throwable {
        logger = report.startTest("TC-1838 Table area is displayed ");
        log.info("####### TC-1838 Table area is displayed #######");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", clickAppMngmt);
        String tableData = tableHeaders.getText();
        System.out.println(tableData);
        if (tableData.contains("Entry ID")) {
            snapshot = (TakesScreenshot) driver;
            File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/Application Management/TC-1838 TableData.png"));
            log.info("####### TC-1832 Search bar is displayed and functioning #######");
            logger.log(LogStatus.PASS, "TC-1838 Table area is displayed");
            logger.log(LogStatus.INFO, "Table area is displayed");
        } else {
            log.info("####### TC-1832 Search bar is displayed and functioning #######");
            logger.log(LogStatus.FAIL, "TC-1832 Search bar is displayed and functioning");
            logger.log(LogStatus.INFO, "Table area is not displayed");
        }
    }
}
