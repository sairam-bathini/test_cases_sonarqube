package page_Object;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test_Base.Admin_BaseClass;

import java.io.File;
import java.time.Duration;
import java.util.List;


public class Admin_Player_Details_Page extends Admin_BaseClass {
    WebDriverWait wait;

    public Admin_Player_Details_Page(WebDriver driver) {
        this.driver = driver;
    }
    Actions act = new Actions(driver);

    @FindBy(xpath = "//div[text()='Player Management']")
    WebElement clickPlayerMngmt;
    @FindBy(xpath = "//*[text()='Dashboard']")
    WebElement clickDashboard;
    @FindBy(xpath = "//input[@class='components__InputStyled-sc-78cfz3-1 juWmLe Searchbar__Input-co7tvo-1 GUUaa']")
    WebElement search;
    @FindBy(xpath = "//*[contains(@class,'SearchIcon')]")
    WebElement clickSearch;
    @FindBy(xpath = "(//div[@class='components__Text-sc-1if6yln-0 fuBvBY'])[2]")
    WebElement clickPlayer;
    @FindBy(xpath = "(//div[@class='ValidatorInput__ValidationInputWrapper-sc-23dtz9-1 ljwdWP'])[1]")
    WebElement getPlayerID;
    @FindBy(xpath = "(//div[@class=' css-1hwfws3'])[1]")
    WebElement clickPlayerStatus;
    @FindBy(xpath = "(//div[@class='ValidatorInput__ValidationInputWrapper-sc-23dtz9-1 ljwdWP'])[1]")
    WebElement getEmailID;
    @FindBy(xpath = "(//*[@id='DataTable_x2F_Row_x2F_RowSelected'])[1]")
    WebElement verifyProfile;
    @FindBy(xpath = "//div[text()='Status & flags']")
    WebElement stausAndFlag;
    @FindBy(xpath = "//div[text()='SET FLAGS']/following::label[@class='Checkbox__Wrapper-sc-1xms6td-0 jibKrv'][1]")
    WebElement ADArequest;
    @FindBy(xpath = "//div[text()='SET FLAGS']/following::label[@class='Checkbox__Wrapper-sc-1xms6td-0 jibKrv'][2]")
    WebElement watchlist;
    @FindBy(xpath = "(//input[@class='components__InputStyled-sc-78cfz3-1 juWmLe'])[24]")
    WebElement enterReason;
    @FindBy(xpath = "//div[@title='Add to Performance Violation']")
    WebElement addPerformance;
    @FindBy(xpath = "( //div[@class=' css-1hwfws3'])[14]")
    WebElement clickYear;
    @FindBy(xpath = "( //div[@class=' css-1hwfws3'])[15]")
    WebElement clickChampionship;
    @FindBy(xpath = "( //div[@class=' css-1hwfws3'])[16]")
    WebElement clickPerformanceViolation;
    @FindBy(xpath = "//span[contains(text(),'Send Performance')]")
    WebElement checkPerformanceViolation;
    @FindBy(xpath = "//span[text()='Add to Performance Violation']")
    WebElement addPerformanceViolation;
    @FindBy(xpath = "//span[text()='Save']")
    WebElement clickSave;
    @FindBy(xpath = "//div[text()='Note']/following:: input[@class='components__InputStyled-sc-78cfz3-1 juWmLe']")
    WebElement note;
    @FindBy(xpath = "//div[text()='Select From List']")
    WebElement receivedBy;
    @FindBy(xpath = "//div[text()='Championship History']")
    WebElement champHistory;
    @FindBy(xpath = "(//*[@class='components__Th-jca4yq-13 ktKIEi'])[5]")
    WebElement champHistoryTHead;
    @FindBy(xpath = "(//*[contains(@class,'PabPN')])")
    WebElement champHistorySS;
    @FindBy(xpath = "(//*[@class='components__Tr-jca4yq-12 dcuOkE'])[6]")
    WebElement clickRow;
    @FindBy(xpath = "//*[text()='Status' and @cursor='pointer']")
    WebElement filterBy;
    @FindBy(xpath = "//*[@placeholder='Enter Keywords'][1]")
    WebElement filterSearch;
    @FindBy(xpath = "(*//*[@class='components__InputStyled-sc-78cfz3-1 juWmLe'])[1]")
    WebElement firstName;
    @FindBy(xpath = "//div[text()='All Years']")
    WebElement champYear;
    @FindBy(xpath = "//div[text()='All Championships']")
    WebElement allChampions;
    @FindBy(xpath = "//*[@class='Icon__TrashIcon-sc-1b8stld-9 cSWdba']")
    WebElement delete_icon;
    @FindBy(xpath = "//*[text()='Yes']")
    WebElement clickYes;
    @FindBy(xpath = "(//*[contains(@class,'eUFwwN admin-table')])[3]/tbody/tr[1]")
    WebElement voilation;

    public void generalInformationDisplays(String PlayerID) throws Throwable {
        logger = report.startTest("Admin DashBoard - TC-1852 General Information displays ");
        log.info("####### Executing TC-1852 General Information displays #######");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", clickPlayerMngmt);
        //clickPlayerMngmt.click();
        search.sendKeys(PlayerID);
        Thread.sleep(1000);
        clickSearch.click();
        Thread.sleep(3000);
        clickPlayer.click();
        boolean playerStatus = getPlayerID.isEnabled();
        System.out.println(playerStatus);
        Thread.sleep(2000);
        clickPlayerStatus.click();
        List<WebElement> reportOptions = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        String reportVal = "";
        System.out.println("******* Player Status Dropdown Values *******");
        String playerStatus_ = "";
        for (WebElement option : reportOptions) {
            playerStatus_ = option.getText();
            System.out.println(playerStatus_);
        }
        System.out.println("**********************************************");
        snapshot = (TakesScreenshot) driver;
        File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/Player Details/TC-1852 PlayerGeneralInfo.png"));
        if (playerStatus_.contains("Pro")) {
            log.info("####### TC-1852 Drop Down displays with : Amateur, Pro, Applicant for Reinstatement is displayed #######");
            logger.log(LogStatus.PASS, "TC-1852 General Information displays");
            logger.log(LogStatus.INFO, "Drop Down displays with : Amateur, Pro, Applicant for Reinstatement is displayed ");
        } else {
            log.info("####### TC-1852 Drop Down displays with : Amateur, Pro, Applicant for Reinstatement is not displayed #######");
            logger.log(LogStatus.PASS, "TC-1852 General Information displays");
            logger.log(LogStatus.INFO, "Drop Down displays with : Amateur, Pro, Applicant for Reinstatement is not displayed ");
        }

    }

    public void contactInfoDisplay(String PlayerID) throws Throwable {

    }

    public void statusAndFlagDisplay(String PlayerID) throws Throwable {
        logger = report.startTest("Player Details - TC-1869 Status and Flags displays ");
        log.info("####### Executing TC-1869 Status and Flags displays #######");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", clickPlayerMngmt);
        //clickPlayerMngmt.click();
        search.sendKeys(PlayerID);
        Thread.sleep(1000);
        clickSearch.click();
        Thread.sleep(1000);
        clickPlayer.click();
        Thread.sleep(3000);
        js.executeScript("arguments[0].scrollIntoView(true);", stausAndFlag);

//        if (ADArequest.isDisplayed()) {
//
//        } else {
//            System.out.println("ADA Req check box is not interactable");
//        }
//
//        if (watchlist.isDisplayed()) {
//
//            Thread.sleep(2000);
//            enterReason.sendKeys("Test");
//
//        } else {
//            System.out.println("Watchlist check box is not interactable");
//        }
        addPerformance.click();
        Thread.sleep(1000);

        clickYear.click();
        List<WebElement> Options = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        String value = "2024";
        for (WebElement option : Options) {
            if ((option.getText()).equals(value)) {
                option.click();
                break;
            }
        }

        clickChampionship.click();
        Thread.sleep(3000);
        List<WebElement> Option = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        String value1 = "124th U.S. Amateur Championship";
        for (WebElement option : Option) {
            if ((option.getText()).equals(value1)) {
                option.click();
                break;
            }
        }
        Thread.sleep(1000);

        clickPerformanceViolation.click();
        List<WebElement> Option1 = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        String value2 = "No Show 2";
        for (WebElement option : Option1) {
            if ((option.getText()).equals(value2)) {
                option.click();
                break;
            }
        }
        checkPerformanceViolation.click();
        addPerformanceViolation.click();
        Thread.sleep(1000);
        snapshot = (TakesScreenshot) driver;
        File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/Player Details/TC-1869 Add performance.png"));

        Thread.sleep(4000);

        js.executeScript("window.scrollTo(1190, 6327);");
        act.moveToElement(delete_icon).click().perform();
        Thread.sleep(300);
        clickYes.click();
        Thread.sleep(300);
        clickSave.click();
        Thread.sleep(1000);

        receivedBy.click();
        List<WebElement> Option3 = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        String value4 = "Incoming Call";
        for (WebElement option : Option3) {
            if ((option.getText()).equals(value4)) {
                option.click();
                break;
            }
        }
        note.sendKeys("Test");
        clickSave.click();

        Thread.sleep(4000);
        if (voilation.isDisplayed()) {
            log.info("####### TC-1869 Status and Flags displays #######");
            logger.log(LogStatus.PASS, "TC-1869 Status and Flags displays");
            logger.log(LogStatus.INFO, "Status and Flags displays ");
        } else {
            log.info("####### TC-1869 Status and Flags not displays #######");
            logger.log(LogStatus.FAIL, "TC-1869 Status and Flags displays");
            logger.log(LogStatus.INFO, "Status and Flags not displays ");
        }
    }

    public void championshipHistory(String playerID) throws Throwable {
        wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        logger = report.startTest("Player Details - TC-1878 Player Championship History displays ");
        log.info("####### Executing TC-1878 Player Championship History displays #######");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", clickPlayerMngmt);
        //clickPlayerMngmt.click();
        search.sendKeys(playerID);
        Thread.sleep(1000);
        clickSearch.click();
        Thread.sleep(3000);
        clickPlayer.click();
        Thread.sleep(3000);
        js.executeScript("arguments[0].scrollIntoView(true);", champHistoryTHead);
        String thead = champHistoryTHead.getText();
        System.out.println(thead);
        log.info("Displays : " + thead);
        //  clickRow.click();
        Thread.sleep(1000);
        js.executeScript("arguments[0].scrollIntoView(false);", filterBy);
        wait.until(ExpectedConditions.elementToBeClickable(filterBy));
        js.executeScript("arguments[0].click();", filterBy);
        //  filterBy.click();
        Thread.sleep(2000);
        if (filterSearch.isDisplayed()) {
            log.info("####### TC-1869 Each column header can be selected which will drop down filtering functions with Search, Check all, Uncheck All and others... #######");
            logger.log(LogStatus.PASS, "TC-1878 Player Championship History displays ");
            logger.log(LogStatus.INFO, "Each column header can be selected which will drop down filtering functions with Search, Check all, Uncheck All and others... ");
        } else {
            log.info("####### TC-1869 Each column header can not be selected and don't have a dropdown filtering functions with Search, Check all, Uncheck All and others... #######");
            logger.log(LogStatus.FAIL, "TC-1878 Player Championship History displays ");
            logger.log(LogStatus.INFO, "Each column header can not be selected and don't have a dropdown filtering functions with Search, Check all, Uncheck All and others... ");
        }
        Actions ac = new Actions(driver);
        ac.moveToElement(champHistorySS).build().perform();
        snapshot = (TakesScreenshot) driver;
        File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/Player Details/TC-1878 PlayerHistory.png"));

    }

    public void saveChanges(String playerID) throws Throwable {
        logger = report.startTest("Player Details - TC-1884 Save Changes CTA displays  ");
        log.info("####### Executing TC-1884 Save Changes CTA displays  #######");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", clickPlayerMngmt);
//      clickPlayerMngmt.click();
        search.sendKeys(playerID);
        Thread.sleep(1000);
        clickSearch.click();
        Thread.sleep(3000);
        clickPlayer.click();
        Thread.sleep(3000);
        firstName.sendKeys(" ");
        Thread.sleep(1000);
        js.executeScript("arguments[0].click();", clickDashboard);
        Thread.sleep(1000);
        snapshot = (TakesScreenshot) driver;
        if (clickYes.isDisplayed()) {
            clickYes.click();
            Thread.sleep(2000);
            File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/Player Details/TC-1884 SaveChanges.png"));
            log.info("####### TC-1869 Are you sure you want to leave this page? The changes you made will be lost Yes/No option is displayed #######");
            logger.log(LogStatus.PASS, "TC-1884 Save Changes CTA displays ");
            logger.log(LogStatus.INFO, " Are you sure you want to leave this page? The changes you made will be lost Yes/No option is displayed");

        } else {
            log.info("####### TC-1869 Are you sure you want to leave this page? The changes you made will be lost Yes/No option is Not displayed #######");
            logger.log(LogStatus.FAIL, "TC-1884 Save Changes CTA displays ");
            logger.log(LogStatus.INFO, " Are you sure you want to leave this page? The changes you made will be lost Yes/No option is Not displayed");
        }
    }

}
