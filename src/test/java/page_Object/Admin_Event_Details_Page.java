package page_Object;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import test_Base.Admin_BaseClass;

import java.io.File;
import java.util.List;

public class Admin_Event_Details_Page extends Admin_BaseClass {
    public Admin_Event_Details_Page(WebDriver driver) {
        this.driver = driver;
    }

    Actions actions = new Actions(driver);
    @FindBy(xpath = "//div[text()='Championship Management']")
    WebElement clickChampMngmt;
    @FindBy(xpath = "//div[text()='Emails']")
    WebElement emailSection;
    @FindBy(xpath = "(//div[@class=' css-1hwfws3'])[1]")
    WebElement clickYear;
    @FindBy(xpath = "//div[text()='Bulk Qualified & Alternate Emails']/following :: span[text()='Send'][1]")
    WebElement bulkQualifyEmails;
    @FindBy(xpath = "//div[text()='Bulk Qualified & Alternate Emails']/following :: span[text()='Send'][2]")
    WebElement bulkFinalEmails;
    @FindBy(xpath = "//div[text()='Bulk Qualified & Alternate Emails']/following :: span[text()='Send'][3]")
    WebElement bulkExceptionEmails;
    @FindBy(xpath = "//div[text()='Bulk Qualified & Alternate Emails']/following :: span[text()='Send'][4]")
    WebElement bulkOICEmails;
    @FindBy(xpath = "//div[text()='Quick Reports']")
    WebElement reportSection;
    @FindBy(xpath = "//span[text()='Export']")
    WebElement export;
    @FindBy(xpath = "//span[text()='Total Applications']")
    WebElement totalApplications;
    @FindBy(xpath = "//span[text()='Exempt from Qualifying']")
    WebElement exemptQualifying;
    @FindBy(xpath = "//span[text()='Review Needed']")
    WebElement reviewNeeded;
    @FindBy(xpath = "//span[text()='Active Applications']")
    WebElement activeApplications;
    @FindBy(xpath = "//span[text()='Qualifying']")
    WebElement qualifying;
    @FindBy(xpath = "//span[text()='Reviewed Applications']")
    WebElement reviewedApplications;
    @FindBy(xpath = "//span[text()='Q Applications']")
    WebElement QApplications;
    @FindBy(xpath = "//span[text()='Finalists']")
    WebElement finalists;
    @FindBy(xpath = "//span[text()='Withdrawn Applications']")
    WebElement withdrawnApplications;
    @FindBy(xpath = "//span[text()='Finalist Alternates']")
    WebElement finalistAlternates;
    @FindBy(xpath = "//span[text()='Total Redboxes']")
    WebElement totalRedboxes;
    @FindBy(xpath = "//span[text()='Local Qualifying']")
    WebElement localQualifying;
    @FindBy(xpath = "//span[text()='Final Qualifying']")
    WebElement finalQualifying;
    @FindBy(xpath = "//span[text()='Final Q Alternates']")
    WebElement finalQalternates;
    @FindBy(xpath = "//span[text()='Exempt from Local Qualifying']")
    WebElement exemptfromLocalQualifying;
    @FindBy(xpath = "//span[text()='Exempt from Final Qualifying']")
    WebElement exemptfromFinalQualifying;
    @FindBy(xpath = "//span[text()='Completed Sides']")
    WebElement completedSides;
    @FindBy(xpath = "//span[text()='Exempt from Final Qualifying']")
    WebElement exemptSides;
    @FindBy(xpath = "//span[text()='Exempt from Final Qualifying']")
    WebElement incompleteSides;
    @FindBy(xpath = "//div[text()='Players Eligible to Apply After the Close of Entries']")
    WebElement applyCloseOfEntries;
    @FindBy(xpath = "//button[@class='FlatIconicButton__StyledButton-sc-1645q4d-0 dmeLpm'][1]")
    WebElement addEntry;
    @FindBy(xpath = " //*[@class=' css-1n7v3ny-option']")
    WebElement playerClick;
    @FindBy(xpath = "//button[@class='FlatIconicButton__StyledButton-sc-1645q4d-0 dmeLpm'][2]")
    WebElement delEntry;
    @FindBy(xpath = "//div[text()='Search for a player']")
    WebElement playerSearch;
    @FindBy(xpath = "//*[text()='OK']")
    WebElement clickOk;
    @FindBy(xpath = "(//*[@class='components__Tr-jca4yq-12 dcuOkE'])[3]//following::label")
    WebElement selectPlayer;
    @FindBy(xpath = "//*[text()='Are you sure you want to remove the selected player(s)?']/following::*[text()='Yes']")
    WebElement clickYes;
    @FindBy(xpath = "(//div[@class=' css-1hwfws3'])[1]")
    WebElement champYear;
    @FindBy(xpath = "(//div[@class=' css-1hwfws3'])[3]")
    WebElement Qsites;
    @FindBy(xpath = "(//div[@class=' css-tlfecz-indicatorContainer'])[3]")
    WebElement clickCross;
    @FindBy(xpath = "(//div[@class=' css-1uccc91-singleValue'])[2]")
    WebElement newChampionship;
    @FindBy(xpath = "//div[text()='USGA Staff Management']")
    WebElement staffManagement;
    @FindBy(xpath = "(//div[text()='Current Championship Field']/following ::span[text()='Auto'])[1]")
    WebElement currentChampionshipField;
    @FindBy(xpath = "(//div[text()='Championship Reports']/following ::span[text()='Auto'])[1]")
    WebElement championshipReports;
    @FindBy(xpath = "(//div[text()='Current Alternates']/following ::span[text()='Auto'])[1]")
    WebElement currentAlternates;
    @FindBy(xpath = "//span[text()='Disable']")
    WebElement disable;
    @FindBy(xpath = "(//div[text()='AGA Management'])[2]")
    WebElement AGAManagement;
    @FindBy(xpath = "(//div[text()='Current Player List']/following ::span[text()='Auto'])[1]")
    WebElement currentPlayerList;
    @FindBy(xpath = "(//div[text()='Players Withdrawn']/following ::span[text()='Auto'])[1]")
    WebElement playersWithdrawn;
    @FindBy(xpath = "(//div[text()='Upload Results']/following ::span[text()='Auto'])[1]")
    WebElement uploadResults;
    @FindBy(xpath = "//div[text()='Uploads']")
    WebElement uploads;
    @FindBy(xpath = "//*[text()='Qualifying Results']")
    WebElement qualifyingResults;
    @FindBy(xpath = "//*[@class='components__Th-jca4yq-13 ktKIEi']")
    WebElement QResultsColumn;
    @FindBy(xpath = "//*[text()='Publish']")
    WebElement publish;
    @FindBy(xpath = "//*[text()='Upload']")
    WebElement upload;
    @FindBy(xpath = "(//*[@class='components__Text-sc-1if6yln-0 fuBvBY'])[2]")
    WebElement tableRow;


    public void emailSectionDisplay(String year, String championship) throws Throwable {
        logger = report.startTest("TC-1917 Email Section displays");
        log.info("####### TC-1917 Email Section displays #######");
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
        Thread.sleep(1000);
        js.executeScript("arguments[0].scrollIntoView(true);", emailSection);
        Thread.sleep(1000);
        snapshot = (TakesScreenshot) driver;
        File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/Event Details/TC-1917 EmailSection.png"));
        bulkQualifyEmails.click();
        Thread.sleep(2000);
        File screenShot1 = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot1, new File(System.getProperty("user.dir") + "/target/ScreenShots/Event Details/TC-1917 Bulk Qualified Alternate Emails.png"));

        driver.navigate().back();
        Thread.sleep(1000);
        js.executeScript("arguments[0].scrollIntoView(true);", emailSection);
        bulkFinalEmails.click();
        Thread.sleep(2000);
        File screenShot2 = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot2, new File(System.getProperty("user.dir") + "/target/ScreenShots/Event Details/TC-1917 Bulk Final Confirmation Emails.png"));

        driver.navigate().back();
        Thread.sleep(1000);
        js.executeScript("arguments[0].scrollIntoView(true);", emailSection);
        bulkExceptionEmails.click();
        Thread.sleep(2000);
        File screenShot3 = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot3, new File(System.getProperty("user.dir") + "/target/ScreenShots/Event Details/TC-1917 Bulk Exemption Notification Emails.png"));

        driver.navigate().back();
        Thread.sleep(1000);
        js.executeScript("arguments[0].scrollIntoView(true);", emailSection);
        bulkOICEmails.click();
        Thread.sleep(2000);
        File screenShot4 = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot4, new File(System.getProperty("user.dir") + "/target/ScreenShots/Event Details/TC-1917 Bulk Emails To Officials.png"));

        driver.navigate().back();
        js.executeScript("arguments[0].scrollIntoView(true);", emailSection);
        List<WebElement> emailSections = driver.findElements(By.xpath("//div[text()='Bulk Qualified & Alternate Emails']/following :: span[text()='Send']"));
        for (WebElement option : emailSections) {
            if (option.isEnabled() && option.isDisplayed()) {
                log.info("####### TC-1917 Email Section displays #######");
                logger.log(LogStatus.PASS, "TC-1917 Email Section displays");
                logger.log(LogStatus.INFO, "Email section is displayed and able to navigate different email sections");
            } else {
                log.info("####### TC-1917 Email Section displays #######");
                logger.log(LogStatus.FAIL, "TC-1917 Email Section displays");
                logger.log(LogStatus.INFO, "Email section is displayed and able to navigate different email sections");
            }
        }

    }

    public void reportSectionDisplay(String year, String championship) throws Throwable {
        logger = report.startTest("TC-1924 Reports Section displays");
        log.info("####### TC-1924 Reports Section displays #######");
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
        Thread.sleep(1000);
        js.executeScript("arguments[0].scrollIntoView(true);", reportSection);
        Thread.sleep(1000);
        snapshot = (TakesScreenshot) driver;
        File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/Event Details/TC-1924 ReportSection.png"));

        List<WebElement> exports = driver.findElements(By.xpath("//span[text()='Export']"));
        for (WebElement option : exports) {
            if (option.isEnabled() && option.isDisplayed()) {
                log.info("####### TC-1924 Reports Section displays #######");
                logger.log(LogStatus.PASS, "TC-1924 Reports Section displays");
                logger.log(LogStatus.INFO, "Reports section is displayed and Export button is clickable");
            } else {
                log.info("####### TC-1924 Reports Section displays #######");
                logger.log(LogStatus.FAIL, "TC-1924 Reports Section displays");
                logger.log(LogStatus.INFO, "Reports section is displayed and Export button is not clickable");
            }
        }
    }

    public void applicationSummaryDisplay(String year, String championship) throws Throwable {
        logger = report.startTest("TC-1883 Application Summary displays");
        log.info("####### TC-1883 Application Summary displays #######");
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
        js.executeScript("arguments[0].click();", totalApplications);
        Thread.sleep(1500);
        snapshot = (TakesScreenshot) driver;
        File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/Event Details/TC-1883 Total Entries.png"));
        driver.navigate().back();

        js.executeScript("arguments[0].click();", activeApplications);
        Thread.sleep(1500);
        File screenShot1 = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot1, new File(System.getProperty("user.dir") + "/target/ScreenShots/Event Details/TC-1883 Active Applications.png"));
        driver.navigate().back();

        js.executeScript("arguments[0].click();", QApplications);
        Thread.sleep(1500);
        File screenShot2 = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot2, new File(System.getProperty("user.dir") + "/target/ScreenShots/Event Details/TC-1883 Queued Applications .png"));
        driver.navigate().back();

        js.executeScript("arguments[0].click();", withdrawnApplications);
        Thread.sleep(1500);
        File screenShot3 = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot3, new File(System.getProperty("user.dir") + "/target/ScreenShots/Event Details/TC-1883 Withdrawn Applications.png"));
        driver.navigate().back();

        js.executeScript("arguments[0].click();", totalRedboxes);
        Thread.sleep(1500);
        File screenShot4 = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot4, new File(System.getProperty("user.dir") + "/target/ScreenShots/Event Details/TC-1883 Total Redboxes.png"));
        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(1000);

        try {
            js.executeScript("arguments[0].click();", exemptQualifying);
            Thread.sleep(1500);
            File screenShot5 = snapshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenShot5, new File(System.getProperty("user.dir") + "/target/ScreenShots/Event Details/TC-1883 Exempt from Qualifying.png"));
            driver.navigate().back();
            Thread.sleep(1000);
        } catch (Exception e) {
        }

        try {
            js.executeScript("arguments[0].click();", qualifying);
            Thread.sleep(1500);
            File screenShot5 = snapshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenShot5, new File(System.getProperty("user.dir") + "/target/ScreenShots/Event Details/TC-1883 Qualifying.png"));
            driver.navigate().back();
            Thread.sleep(1000);
        } catch (Exception e) {
        }

        if (championship.contains("U.S. Open")) {
            js.executeScript("arguments[0].click();", localQualifying);
            Thread.sleep(1500);
            File screenShot7 = snapshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenShot7, new File(System.getProperty("user.dir") + "/target/ScreenShots/Event Details/TC-1883 Local Qualifying.png"));
            Thread.sleep(1000);
            driver.navigate().back();
            Thread.sleep(500);

            js.executeScript("arguments[0].click();", finalQualifying);
            Thread.sleep(1500);
            File screenShot8 = snapshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenShot7, new File(System.getProperty("user.dir") + "/target/ScreenShots/Event Details/TC-1883 Final Qualifying.png"));
            Thread.sleep(1000);
            driver.navigate().back();
            Thread.sleep(500);

            js.executeScript("arguments[0].click();", finalQalternates);
            Thread.sleep(1500);
            File screenShot9 = snapshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenShot7, new File(System.getProperty("user.dir") + "/target/ScreenShots/Event Details/TC-1883 Final Q Qualifying.png"));
            Thread.sleep(1000);
            driver.navigate().back();
            Thread.sleep(500);

            js.executeScript("arguments[0].click();", exemptfromLocalQualifying);
            Thread.sleep(1500);
            File screenShot10 = snapshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenShot7, new File(System.getProperty("user.dir") + "/target/ScreenShots/Event Details/TC-1883 Exempt from Local Qualifying.png"));
            Thread.sleep(1000);
            driver.navigate().back();
            Thread.sleep(500);

            js.executeScript("arguments[0].click();", exemptfromFinalQualifying);
            Thread.sleep(1500);
            File screenShot11 = snapshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenShot7, new File(System.getProperty("user.dir") + "/target/ScreenShots/Event Details/TC-1883 Exempt from Final Qualifying.png"));
            Thread.sleep(1000);
            driver.navigate().back();
            Thread.sleep(500);
        }

        js.executeScript("arguments[0].click();", finalists);
        Thread.sleep(1500);
        File screenShot10 = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot10, new File(System.getProperty("user.dir") + "/target/ScreenShots/Event Details/TC-1883 Finalists.png"));
        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(500);

        js.executeScript("arguments[0].click();", finalistAlternates);
        Thread.sleep(1500);
        File screenShot11 = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot11, new File(System.getProperty("user.dir") + "/target/ScreenShots/Event Details/TC-1883 Finalist Alternates.png"));
        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(500);

        js.executeScript("arguments[0].click();", reviewNeeded);
        Thread.sleep(1500);
        File screenShot12 = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot12, new File(System.getProperty("user.dir") + "/target/ScreenShots/Event Details/TC-1883 Review Needed.png"));
        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(500);

        js.executeScript("arguments[0].click();", reviewedApplications);
        Thread.sleep(1500);
        File screenShot13 = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot13, new File(System.getProperty("user.dir") + "/target/ScreenShots/Event Details/TC-1883 Reviewed Applications.png"));
        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(500);

        if (championship.contains("Four-Ball")) {
            js.executeScript("arguments[0].click();", completedSides);
            Thread.sleep(1500);
            File screenShot14 = snapshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenShot14, new File(System.getProperty("user.dir") + "/target/ScreenShots/Event Details/TC-1883 Completed Sides.png"));
            Thread.sleep(1000);
            driver.navigate().back();
            Thread.sleep(500);

            js.executeScript("arguments[0].click();", exemptSides);
            Thread.sleep(1500);
            File screenShot15 = snapshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenShot15, new File(System.getProperty("user.dir") + "/target/ScreenShots/Event Details/TC-1883 Exempt Sides.png"));
            Thread.sleep(1000);
            driver.navigate().back();
            Thread.sleep(500);

            js.executeScript("arguments[0].click();", incompleteSides);
            Thread.sleep(1500);
            File screenShot16 = snapshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenShot16, new File(System.getProperty("user.dir") + "/target/ScreenShots/Event Details/TC-1883 Incomplete Sides.png"));
            Thread.sleep(1000);
            driver.navigate().back();
            Thread.sleep(500);
            driver.navigate().back();
        }
        List<WebElement> emailSections = driver.findElements(By.xpath("//span[@class='components__Text-sc-1if6yln-0 gYBdgH']"));
        for (WebElement option : emailSections) {
            if (option.isDisplayed()) {
                log.info("####### TC-1883 Application Summary displays #######");
                logger.log(LogStatus.PASS, "TC-1883 Application Summary displays");
                logger.log(LogStatus.INFO, "Application Summary is displayed");
            } else {
                log.info("####### TC-1883 Application Summary displays #######");
                logger.log(LogStatus.FAIL, "TC-1883 Application Summary displays");
                logger.log(LogStatus.INFO, "Application Summary is displayed");
            }
        }
    }

    public void playersEligibleToApplyAfterCloseOfEntry(String year, String championship, String playerID) throws Throwable {
        logger = report.startTest("TC-1867 Players Eligible to Apply After the Close of Entries");
        log.info("####### TC-1867 Players Eligible to Apply After the Close of Entries #######");
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
        try {
            js.executeScript("arguments[0].scrollIntoView(true);", applyCloseOfEntries);
            Thread.sleep(1000);
            js.executeScript("arguments[0].click();", applyCloseOfEntries);
            addEntry.click();
            Thread.sleep(2000);
            actions.moveToElement(playerSearch).click().sendKeys(playerID).perform();
            Thread.sleep(3000);
            playerClick.click();
            clickOk.click();
            Thread.sleep(9000);
            snapshot = (TakesScreenshot) driver;
            File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/Event Details/TC-1867 Player Added.png"));
            selectPlayer.click();
            delEntry.click();
            clickYes.click();
            Thread.sleep(3000);
            File screenShot1 = snapshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenShot1, new File(System.getProperty("user.dir") + "/target/ScreenShots/Event Details/TC-1867 Player removed.png"));
            log.info("####### TC-1867 Players Eligible to Apply After the Close of Entries #######");
            logger.log(LogStatus.PASS, "TC-1867 Players Eligible to Apply After the Close of Entries");
            logger.log(LogStatus.INFO, "Able to add players after the Close of Entries");
        } catch (Exception e) {
            log.info("####### TC-1867 Players Eligible to Apply After the Close of Entries #######");
            logger.log(LogStatus.FAIL, "TC-1867 Players Eligible to Apply After the Close of Entries");
            logger.log(LogStatus.INFO, "Unable to add players after the Close of Entries");
        }
    }

    public void selectedYearChampDropDowndisplay(String year, String championship, String newYear, String newChamp) throws Throwable {
        logger = report.startTest("TC-1875 Selected Year and Champ Drop Down display");
        log.info("####### TC-1875 Selected Year and Champ Drop Down display #######");
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
        Thread.sleep(2000);
        champYear.click();
        List<WebElement> Options = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        String Val = newYear;
        for (WebElement option : Options) {
            if ((option.getText()).equals(Val)) {
                option.click();
                break;
            }
        }
        Thread.sleep(2000);
        newChampionship.click();
        List<WebElement> Options1 = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        String Val1 = newChamp;
        for (WebElement option : Options1) {
            if ((option.getText()).equals(Val1)) {
                option.click();
                break;
            }
        }
        if (champYear.isDisplayed() && newChampionship.isDisplayed()) {
            log.info("####### TC-1875 Selected Year and Champ Drop Down display #######");
            logger.log(LogStatus.PASS, "TC-1875 Selected Year and Champ Drop Down display");
            logger.log(LogStatus.INFO, "Able to select values from year and championship dropdowns");
        } else {
            log.info("####### TC-1875 Selected Year and Champ Drop Down display #######");
            logger.log(LogStatus.FAIL, "TC-1875 Selected Year and Champ Drop Down display");
            logger.log(LogStatus.INFO, "Unable to select values from year and championship dropdowns");
        }
    }

    public void USGAStaffManagement(String year, String championship) throws Throwable {
        logger = report.startTest("TC-1901 USGA Staff Management");
        log.info("####### TC-1901 USGA Staff Management #######");
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
        Thread.sleep(1000);
        js.executeScript("arguments[0].scrollIntoView(true);", staffManagement);
        Thread.sleep(1000);
        snapshot = (TakesScreenshot) driver;
        File screenShot3 = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot3, new File(System.getProperty("user.dir") + "/target/ScreenShots/Event Details/TC-1901 USGA Staff Management.png"));
        currentChampionshipField.click();
        disable.click();
        championshipReports.click();
        disable.click();
        currentAlternates.click();
        disable.click();
        File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/Event Details/TC-1901 USGA Staff Management1.png"));

    }

    public void AGAManagementDisplays(String year, String championship) throws Throwable {
        logger = report.startTest("TC-1909 AGA Management Displays");
        log.info("####### TC-1909 AGA Management Displays #######");
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
        Thread.sleep(1000);
        js.executeScript("arguments[0].scrollIntoView(true);", AGAManagement);
        Thread.sleep(1000);
        snapshot = (TakesScreenshot) driver;
        File screenShot3 = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot3, new File(System.getProperty("user.dir") + "/target/ScreenShots/Event Details/TC-1909 AGA Management.png"));
        currentPlayerList.click();
        disable.click();
        playersWithdrawn.click();
        disable.click();
        uploadResults.click();
        disable.click();
        File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/Event Details/TC-1909 AGA Management1.png"));

    }

    public void verifyQualifyingResultsPage(String year, String championship, String newYear, String newChamp, String Qsite) throws Throwable {
        logger = report.startTest("TC-3024 Verify Qualifying Results Page");
        log.info("####### TC-3024 Verify Qualifying Results Page #######");
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
        Thread.sleep(1000);
        js.executeScript("arguments[0].scrollIntoView(true);", uploads);
        Thread.sleep(1000);
        qualifyingResults.click();
        Thread.sleep(2000);
        snapshot = (TakesScreenshot) driver;
        File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/Event Details/TC-3024 VerifyQResults.png"));

        champYear.click();
        List<WebElement> Options = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        String Val = newYear;
        for (WebElement option : Options) {
            if ((option.getText()).equals(Val)) {
                option.click();
                break;
            }
        }
        Thread.sleep(2000);
        newChampionship.click();
        List<WebElement> Options1 = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        String Val1 = newChamp;
        for (WebElement option : Options1) {
            if ((option.getText()).equals(Val1)) {
                option.click();
                break;
            }
        }
        Qsites.click();
        List<WebElement> Options2 = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        String Val2 = Qsite;
        for (WebElement option : Options2) {
            if ((option.getText()).equals(Val2)) {
                option.click();
                break;
            }
        }
        Thread.sleep(1500);
        clickCross.click();
        File screenShot1 = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot1, new File(System.getProperty("user.dir") + "/target/ScreenShots/Event Details/TC-3024 VerifyQResults1.png"));
        Thread.sleep(2000);
        System.out.println(QResultsColumn.getText());
        tableRow.click();
        File screenShot2 = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot2, new File(System.getProperty("user.dir") + "/target/ScreenShots/Event Details/TC-3024 VerifyQResults2.png"));

    }


}

