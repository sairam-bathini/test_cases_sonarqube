package page_Object;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import test_Base.Admin_BaseClass;
import java.io.File;
import java.util.List;

public class Admin_Add_Site_Page extends Admin_BaseClass {
    public Admin_Add_Site_Page(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//div[text()='Qualifying Site Management']")
    WebElement qualifyingSiteMngmt;
    @FindBy(xpath = "//*[text()='Add site']")
    WebElement addSite;
    @FindBy(xpath = "//*[text()='Site Number']/following:: input[@class='components__InputStyled-sc-78cfz3-1 juWmLe'][1]")
    WebElement enterSiteNumber;
    @FindBy(xpath = "(//div[@class=' css-1hwfws3'])[1]")
    WebElement clickYear;
    @FindBy(xpath = "(//div[@class=' css-1hwfws3'])[2]")
    WebElement clickChamp;
    @FindBy(xpath = "//*[text()='City']/following:: input[@class='components__InputStyled-sc-78cfz3-1 juWmLe'][1]")
    WebElement enterCity;
    @FindBy(xpath = "//*[text()='Type of qualifying']/following:: *[@class=' css-1hwfws3'][1]")
    WebElement selectTypeOfQualifying;
    @FindBy(xpath = "//*[text()='Country']/following:: *[@class=' css-1hwfws3'][1]")
    WebElement enterCountry;
    @FindBy(xpath = "//*[text()='State']/following:: *[@class=' css-1hwfws3'][1]")
    WebElement enterState;
    @FindBy(xpath = "//*[text()='Qualifying Date']/following :: input[contains(@class,'inputGroup__month')][1]")
    WebElement enterQualifyingDate;
    @FindBy(xpath = "//*[text()='Rain Date']/following :: input[contains(@class,'inputGroup__month')][1]")
    WebElement enterRainDate;
    @FindBy(xpath = "//*[text()='Max Site Capacity']/following:: input[@class='components__InputStyled-sc-78cfz3-1 juWmLe'][1]")
    WebElement enterMaxSiteCapacity;
    @FindBy(xpath = "//*[text()='Practice Dates / Info']/following:: *[@class='Textarea-sc-68pl4m-0 hKVfVN'][1]")
    WebElement enterPracticeDates;
    @FindBy(xpath = "//*[text()='Website of Allied Golf Association']/following:: input[@class='components__InputStyled-sc-78cfz3-1 juWmLe'][1]")
    WebElement enterWebsiteofAlliedGolfAssociation;
    @FindBy(xpath = "//div[contains(text(),'Carts Available')]/following:: *[@class=' css-1hwfws3'][1]")
    WebElement enterCartsAvailable;
    @FindBy(xpath = "//div[contains(text(),'Push Carts')]/following:: *[@class=' css-1hwfws3'][1]")
    WebElement enterPushCarts;
    @FindBy(xpath = "//div[text()='Course Access']/following:: *[@class=' css-1hwfws3'][1]")
    WebElement enterCourseAccess;
    @FindBy(xpath = "//div[text()='Club Search']/following:: *[@class=' css-1hwfws3'][1]")
    WebElement enterClubSearch;
    @FindBy(xpath = "//div[text()='POC Search']/following:: *[@class=' css-1hwfws3'][1]")
    WebElement enterPocSearch;
    @FindBy(xpath = "//*[text()='Submitted By First Name']/following:: input[@class='components__InputStyled-sc-78cfz3-1 juWmLe'][1]")
    WebElement enterFirstName;
    @FindBy(xpath = "//*[text()='Submitted By Last Name']/following:: input[@class='components__InputStyled-sc-78cfz3-1 juWmLe'][1]")
    WebElement enterLastName;
    @FindBy(xpath = "//*[text()='Submitted By AGA']/following:: input[@class='components__InputStyled-sc-78cfz3-1 juWmLe'][1]")
    WebElement enterSubmittedAGA;
    @FindBy(xpath = "//*[text()='Save Changes']")
    WebElement saveChanges;
    @FindBy(xpath = "//*[text()='CLUB INFORMATION']")
    WebElement clubInfo;
    @FindBy(xpath = "//*[text()='USGA POINT OF CONTACT (POC)']")
    WebElement POC;
    @FindBy(xpath = "//div[contains(@id,'react-select')]")
    WebElement select;
    @FindBy(xpath = "(//*[text()='Local Qualifying'])[1]")
    WebElement selectQualifyingLocation;
    @FindBy(xpath = "(//*[text()='Delete'])[1]")
    WebElement delete;
    @FindBy(xpath = "(//*[text()='Delete'])[1]")
    WebElement confirmDelete;
    @FindBy(xpath = "(//*[@class='components__Text-sc-1if6yln-0 fuBvBY'])[3]")
    WebElement getSiteNumber;

    public void saveCTADisplayedAndFunctioning(String year, String championship, String siteNum, String typeOfQualifying, String city, String country, String qualifyingDate,
                                               String rainDate, String maxSiteCapacity, String practiceDates, String websiteGA, String cartsAvailable, String pushCarts, String courseAccess,
                                               String clubSearch, String pocSearch, String fName, String lName, String agaName, String state) throws Throwable {
        logger = report.startTest("TC-1908 Save CTA is displayed and functioning");
        log.info("####### TC-1908 Save CTA is displayed and functioning #######");
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
        addSite.click();
        enterSiteNumber.sendKeys(siteNum);
        selectTypeOfQualifying.click();
        List<WebElement> options = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        String val = typeOfQualifying;
        for (WebElement option : options) {
            if ((option.getText()).equals(val)) {
                option.click();
                break;
            }
        }

        enterCity.sendKeys(city);
        enterCountry.click();
        List<WebElement> countryOptions = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        String countryVal = country;
        for (WebElement option : countryOptions) {
            if ((option.getText()).equals(countryVal)) {
                option.click();
                break;
            }
        }
        Thread.sleep(1000);
        enterState.click();
        List<WebElement> stateOptions = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        String stateVal = state;
        for (WebElement option : stateOptions) {
            if ((option.getText()).equals(stateVal)) {
                option.click();
                break;
            }
        }
        Thread.sleep(1000);
        enterMaxSiteCapacity.sendKeys(maxSiteCapacity);
        Thread.sleep(1000);
        enterPracticeDates.sendKeys(practiceDates);

        enterWebsiteofAlliedGolfAssociation.sendKeys(websiteGA);
        Thread.sleep(1000);
        js.executeScript("arguments[0].scrollIntoView(true);", enterPracticeDates);
        Thread.sleep(1000);
        enterCartsAvailable.click();
        List<WebElement> cartsOptions = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        String cartsVal = cartsAvailable;
        for (WebElement option : cartsOptions) {
            if ((option.getText()).equals(cartsVal)) {
                option.click();
                break;
            }
        }

        enterPushCarts.click();
        List<WebElement> pushOptions = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        String pushVal = pushCarts;
        for (WebElement option : pushOptions) {
            if ((option.getText()).equals(pushVal)) {
                option.click();
                break;
            }
        }

        enterCourseAccess.click();
        List<WebElement> courseOptions = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        String courseVal = courseAccess;
        for (WebElement option : courseOptions) {
            if ((option.getText()).equals(courseVal)) {
                option.click();
                break;
            }
        }

        js.executeScript("arguments[0].scrollIntoView(true);", clubInfo);
        Actions actions = new Actions(driver);
        actions.moveToElement(enterClubSearch).click().sendKeys(clubSearch).build().perform();
        Thread.sleep(500);
        select.click();

        js.executeScript("arguments[0].scrollIntoView(true);", POC);
        actions.moveToElement(enterPocSearch).click().sendKeys(pocSearch).build().perform();
        Thread.sleep(500);
        select.click();

        enterFirstName.sendKeys(fName);
        enterLastName.sendKeys(lName);
        enterSubmittedAGA.sendKeys(agaName);

        js.executeScript("arguments[0].scrollIntoView(true);", enterSiteNumber);
        enterRainDate.sendKeys(rainDate);
        Thread.sleep(1000);
        enterQualifyingDate.sendKeys(qualifyingDate);
        saveChanges.click();
        Thread.sleep(3000);
        snapshot = (TakesScreenshot) driver;
        File screenShot1 = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot1, new File(System.getProperty("user.dir") + "/target/ScreenShots/Add Site/TC-1908 Save CTA.png"));
        String getSiteNo = getSiteNumber.getText();
        if (getSiteNo.contains(siteNum)) {
            log.info("####### TC-1908 Save CTA is displayed and functioning #######");
            logger.log(LogStatus.PASS, "TC-1908 Save CTA is displayed and functioning");
            logger.log(LogStatus.INFO, "Save CTA is displayed and functioning as expected");
        } else {
            log.info("####### TC-1908 Save CTA is displayed and functioning #######");
            logger.log(LogStatus.FAIL, "TC-1908 Save CTA is displayed and functioning");
            logger.log(LogStatus.INFO, "Save CTA is displayed and not functioning as expected");
        }
        Thread.sleep(1000);
        selectQualifyingLocation.click();
        delete.click();
        confirmDelete.click();
        Thread.sleep(1000);
        addSite.click();
        Thread.sleep(2000);
        saveChanges.click();
        Thread.sleep(3000);
        snapshot = (TakesScreenshot) driver;
        File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/Add Site/TC-1908 Save CTA Error.png"));

    }

}
