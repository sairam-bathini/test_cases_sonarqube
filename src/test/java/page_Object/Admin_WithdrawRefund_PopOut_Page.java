package page_Object;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import test_Base.Admin_BaseClass;

import java.io.File;
import java.util.List;

public class Admin_WithdrawRefund_PopOut_Page extends Admin_BaseClass {
    public Admin_WithdrawRefund_PopOut_Page(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//div[text()='Application Management']")
    WebElement clickAppMngmt;
    @FindBy(xpath = "(//div[@class=' css-1hwfws3'])[1]")
    WebElement clickYear;
    @FindBy(xpath = "//div[text()='Select a Championship']")
    WebElement clickChampionship;
    @FindBy(xpath = "//*[text()='Payment information']")
    WebElement paymentInfo;
    @FindBy(xpath = "//div[text()='Total Entries']")
    WebElement clickStatus;
    @FindBy(xpath = "//input[@class='components__InputStyled-sc-78cfz3-1 juWmLe Searchbar__Input-co7tvo-1 GUUaa']")
    WebElement search;
    @FindBy(xpath = "//div[contains(text(),'Send withdrawal notification')]")
    WebElement notificationCheckbox;
    @FindBy(xpath = "//span[text()='Withdraw/Refund']")
    WebElement withdrawPopup;
    @FindBy(xpath = "(//div[@class='components__Text-sc-1if6yln-0 gbuFAn'])[1]")
    WebElement clickPlayer;
    @FindBy(xpath = "//div[text()='Select Reason']")
    WebElement withdrawReason;
    @FindBy(xpath = "(//*[@class='FlexWrapper__StyledFlexWrapper-jk1687-0 hXInGW'])[10]")
    WebElement refundAmount;
    @FindBy(xpath = "(//*[contains(@class,'Textarea')])[2]")
    WebElement enterComment;
    @FindBy(xpath = "//div[text()='Select From List']")
    WebElement receivedBy;
    @FindBy(xpath = "//span[text()='Submit']")
    WebElement submit;

    public void emailCheckboxDisplay(String year, String championship, String searchData) throws Throwable {
        logger = report.startTest("TC-1821 Email Checkbox displays");
        log.info("####### TC-1821 Email Checkbox displays #######");
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
        Actions actions = new Actions(driver);
        actions.sendKeys(championship).click().build().perform();
        Thread.sleep(1000);
        List<WebElement> champOptions = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        String champVal = championship;
        System.out.println(champVal);
        for (WebElement option : champOptions) {
            if ((option.getText()).equals(champVal)) {
                Thread.sleep(500);
                option.click();
                break;
            }
        }
        search.sendKeys(searchData);
        clickPlayer.click();
        js.executeScript("arguments[0].scrollIntoView(true);", paymentInfo);
        try {
            js.executeScript("arguments[0].click();", withdrawPopup);
            if (!notificationCheckbox.isSelected()) {
                System.out.println("Email Checkbox is selected");
            } else {
                notificationCheckbox.click();
            }

            withdrawReason.click();
            List<WebElement> Options = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
            String Val = "Illness";
            for (WebElement option : Options) {

                if ((option.getText()).equals(Val)) {
                    option.click();
                    break;
                }
            }

            if (!refundAmount.isEnabled()) {

            } else {
                refundAmount.click();
                List<WebElement> Options1 = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
                String Val1 = "No Refund";
                for (WebElement option : Options1) {

                    if ((option.getText()).equals(Val1)) {
                        option.click();
                        break;
                    }
                }
            }
            receivedBy.click();
            List<WebElement> Options2 = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
            String Val2 = "Incoming Call";
            for (WebElement option : Options2) {

                if ((option.getText()).equals(Val2)) {
                    option.click();
                    break;
                }
            }
            enterComment.sendKeys("Test");
            submit.click();
            Thread.sleep(3000);
            snapshot = (TakesScreenshot) driver;
            File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/WithdrawRefund PopUp/TC-1849 EmailCheckbox.png"));
            Thread.sleep(4000);
            log.info("####### TC-1821 Email Checkbox displays #######");
            logger.log(LogStatus.PASS, "TC-1821 Email Checkbox displays");
            logger.log(LogStatus.INFO, "Able to click Email Checkbox and submit");
        } catch (Exception e) {
            System.out.println("Please enter new player entry ID");
            log.info("####### TC-1821 Email Checkbox displays #######");
            logger.log(LogStatus.FAIL, "TC-1821 Email Checkbox displays");
            logger.log(LogStatus.INFO, "Player is already withdrawn, please enter appropriate Player ID");

        }

    }

    public void requestReceivedBy(String year, String championship, String searchData) throws Throwable {
        logger = report.startTest("TC-1828 Request Received By displays");
        log.info("####### TC-1828 Request Received By displays #######");
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
        clickPlayer.click();
        js.executeScript("arguments[0].scrollIntoView(true);", paymentInfo);
        try {
            js.executeScript("arguments[0].click();", withdrawPopup);
            receivedBy.click();
            snapshot = (TakesScreenshot) driver;
            File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/WithdrawRefund PopUp/TC-1828 RequestReecivedBy.png"));

            List<WebElement> Options2 = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
            for (WebElement option : Options2) {
                System.out.println(option.getText());
            }
            Thread.sleep(2000);
            log.info("####### TC-1828 Request Received By displays #######");
            logger.log(LogStatus.PASS, "TC-1828 Request Received By displays");
            logger.log(LogStatus.INFO, "Request Received is displayed with all the dropdown values");
        } catch (Exception e) {
            System.out.println("Please enter new player entry ID");
            log.info("####### TC-1828 Request Received By displays #######");
            logger.log(LogStatus.FAIL, "TC-1828 Request Received By is not displayed");
            logger.log(LogStatus.INFO, "Player is already withdrawn, please enter appropriate  Player ID");
        }
    }

    public void refundAmount(String year, String championship, String searchData) throws Throwable {
        logger = report.startTest("TC-1835 Refund Amount displays");
        log.info("####### TC-1835 Refund Amount displays #######");
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
        clickPlayer.click();
        js.executeScript("arguments[0].scrollIntoView(true);", paymentInfo);
        try {
            js.executeScript("arguments[0].click();", withdrawPopup);

            if (!refundAmount.isEnabled()) {
                log.info("####### TC-1835 Refund Amount is not displayed  #######");
                logger.log(LogStatus.FAIL, "TC-1835 Refund Amount displays ");
                logger.log(LogStatus.INFO, "For this player Refund Amount field is disabled, please enter appropriate  Player ID ");

            } else {
                refundAmount.click();
                Thread.sleep(1000);
                snapshot = (TakesScreenshot) driver;
                File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/WithdrawRefund PopUp/TC-1835 Refund Amount.png"));

                List<WebElement> Options1 = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
                for (WebElement option : Options1) {
                    System.out.println(option.getText());
                }
            }
            Thread.sleep(2000);
            log.info("####### TC-1835 Refund Amount is not displayed #######");
            logger.log(LogStatus.PASS, "TC-1835 Refund Amount is displayed");
            logger.log(LogStatus.INFO, "Refund Amount is displayed with all the dropdown values");
        } catch (Exception e) {
            System.out.println("Please enter new player entry ID");
            log.info("####### TC-1835 Refund Amount is not displayed #######");
            logger.log(LogStatus.FAIL, "TC-1835 Refund Amount is not displayed");
            logger.log(LogStatus.INFO, "Player is already withdrawn, please enter appropriate  Player ID");

        }

    }

    public void commentFieldDisplay(String year, String championship, String searchData) throws Throwable {
        logger = report.startTest("TC-1839 Comment field displays");
        log.info("####### TC-1839 Comment field displays #######");
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
        clickPlayer.click();
        try {
            js.executeScript("arguments[0].click();", withdrawPopup);
            Thread.sleep(1000);
            js.executeScript("arguments[0].scrollIntoView(true);", enterComment);
            submit.click();
            snapshot = (TakesScreenshot) driver;
            File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/WithdrawRefund PopUp/TC-1839 Comment Field Required.png"));
            enterComment.sendKeys("Test");
            snapshot = (TakesScreenshot) driver;
            File screenShot1 = snapshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenShot1, new File(System.getProperty("user.dir") + "/target/ScreenShots/WithdrawRefund PopUp/TC-1839 Comment Field.png"));
            Thread.sleep(4000);
            log.info("####### TC-1839 Comment field displays #######");
            logger.log(LogStatus.PASS, "TC-1839 Comment field displays");
            logger.log(LogStatus.INFO, "Able to enter text in Comment textbox");
        } catch (Exception e) {
            System.out.println("Please enter new player entry ID");
            log.info("####### TC-1839 Comment field displays #######");
            logger.log(LogStatus.FAIL, "TC-1839 Comment field displays");
            logger.log(LogStatus.INFO, "Unable to enter text in Comment textbox");

        }

    }

    public void entryPlayerInformation(String year, String championship, String searchData) throws Throwable {
        logger = report.startTest("TC-1847 Entry and Player Information display ");
        log.info("####### TC-1847 Entry and Player Information display #######");
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
        clickPlayer.click();
        try {
            js.executeScript("arguments[0].click();", withdrawPopup);
            Thread.sleep(1000);
            snapshot = (TakesScreenshot) driver;
            File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/WithdrawRefund PopUp/TC-1847 PlayerInfo.png"));
            log.info("####### TC-1847 Entry and Player Information display #######");
            logger.log(LogStatus.PASS, "TC-1847 Entry and Player Information display");
            logger.log(LogStatus.INFO, "Entry and Player Information is displayed");
        } catch (Exception e) {
            System.out.println("Please enter new player entry ID");
            log.info("####### TC-1847 Entry and Player Information display #######");
            logger.log(LogStatus.FAIL, "TC-1847 Entry and Player Information display");
            logger.log(LogStatus.INFO, "Entry and Player Information is not displayed");

        }

    }

    public void withdrawalReason(String year, String championship, String searchData) throws Throwable {
        logger = report.startTest("TC-1854 Withdrawal Reason displays ");
        log.info("####### TC-1854 Withdrawal Reason displays  #######");
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
        clickPlayer.click();
        js.executeScript("arguments[0].scrollIntoView(true);", paymentInfo);
        try {
            js.executeScript("arguments[0].click();", withdrawPopup);

            withdrawReason.click();
            snapshot = (TakesScreenshot) driver;
            File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/WithdrawRefund PopUp/TC-1854 Withdraw Reason.png"));
            Thread.sleep(4000);
            List<WebElement> Options = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
            String Val = "Illness";
            for (WebElement option : Options) {
                System.out.println(option.getText());
            }
            log.info("####### TC-1854 Withdrawal Reason displays #######");
            logger.log(LogStatus.PASS, "TC-1854 Withdrawal Reason displays");
            logger.log(LogStatus.INFO, "Withdrawal Reason is displayed with all the dropdown values");
        } catch (Exception e) {
            System.out.println("Please enter new player entry ID");
            log.info("####### TC-1854 Withdrawal Reason displays #######");
            logger.log(LogStatus.FAIL, "TC-1854 Withdrawal Reason displays");
            logger.log(LogStatus.INFO, "Withdrawal Reason is not displayed");

        }

    }
    public void moduleDisplay(String year, String championship, String searchData) throws Throwable {
        logger = report.startTest("TC-1858 Module displays in a pop out when the user clicks on Withdraw Refund button ");
        log.info("####### TC-1858 Module displays in a pop out when the user clicks on Withdraw Refund button #######");
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
        clickPlayer.click();
        try {
            js.executeScript("arguments[0].click();", withdrawPopup);
            Thread.sleep(1000);
            snapshot = (TakesScreenshot) driver;
            File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/WithdrawRefund PopUp/TC-1858 Module Display.png"));
            log.info("####### TC-1858 Module displays in a pop out when the user clicks on Withdraw Refund button #######");
            logger.log(LogStatus.PASS, "TC-1858 Module displays in a pop out when the user clicks on Withdraw Refund button");
            logger.log(LogStatus.INFO, "Withdraw/Refund Module is displayed");
        } catch (Exception e) {
            System.out.println("Please enter new player entry ID");
            log.info("####### TC-1858 Module displays in a pop out when the user clicks on Withdraw Refund button #######");
            logger.log(LogStatus.FAIL, "TC-1858 Module displays in a pop out when the user clicks on Withdraw Refund button");
            logger.log(LogStatus.INFO, "Withdraw/Refund Module is not displayed");

        }

    }
    public void submitCTADisplay(String year, String championship, String searchData) throws Throwable {
        logger = report.startTest("TC-1906 Submit CTA displays ");
        log.info("####### TC-1906 Submit CTA displays #######");
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
        clickPlayer.click();
        js.executeScript("arguments[0].scrollIntoView(true);", paymentInfo);
        try {
            js.executeScript("arguments[0].click();", withdrawPopup);
            withdrawReason.click();
            List<WebElement> Options = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
            String Val = "Illness";
            for (WebElement option : Options) {

                if ((option.getText()).equals(Val)) {
                    option.click();
                    break;
                }
            }

            if (!refundAmount.isEnabled()) {

            } else {
                refundAmount.click();
                List<WebElement> Options1 = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
                String Val1 = "No Refund";
                for (WebElement option : Options1) {

                    if ((option.getText()).equals(Val1)) {
                        option.click();
                        break;
                    }
                }
            }
            receivedBy.click();
            List<WebElement> Options2 = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
            String Val2 = "Incoming Call";
            for (WebElement option : Options2) {

                if ((option.getText()).equals(Val2)) {
                    option.click();
                    break;
                }
            }
            enterComment.sendKeys("Test");
            submit.click();
            Thread.sleep(3000);
            snapshot = (TakesScreenshot) driver;
            File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/WithdrawRefund PopUp/TC-1906 Player Withdrawn.png"));
            Thread.sleep(4000);
            log.info("####### TC-1906 Submit CTA displays #######");
            logger.log(LogStatus.PASS, "TC-1906 Submit CTA displays");
            logger.log(LogStatus.INFO, "Submit button is displayed and working");
        } catch (Exception e) {
            System.out.println("Please enter new player entry ID");
            log.info("####### TC-1906 Submit CTA displays #######");
            logger.log(LogStatus.FAIL, "TC-1906 Submit CTA displayss");
            logger.log(LogStatus.INFO, "Submit button is not displayed ");
        }

    }
}
