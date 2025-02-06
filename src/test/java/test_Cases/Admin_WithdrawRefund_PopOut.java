package test_Cases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import page_Object.Admin_WithdrawRefund_PopOut_Page;
import test_Base.Admin_BaseClass;
import test_Base.Admin_Login;
import test_Base.Admin_Logout;
import utilities.ExcelFileUtil;

public class Admin_WithdrawRefund_PopOut extends Admin_BaseClass {
    String input = "./FileInput/ChampAdmin_TestData.xlsx";
    String sheetName = "App_Details";
    ExcelFileUtil xl;
    int rc;
    Admin_Login adminLogin = new Admin_Login();
    Admin_Logout adminLogout = new Admin_Logout();

    @Test(priority = 1, description = "TC-1821 Email Checkbox displays", enabled = true)
    public void emailCheckboxDisplays() throws Throwable {
        adminLogin.login1();
        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        for (int i = 15; i <= 15; i++) {

            String year = xl.getcelldata(sheetName, i, 1);
            String champName = xl.getcelldata(sheetName, i, 2);
            String searchData = xl.getcelldata(sheetName, i, 4);
            Admin_WithdrawRefund_PopOut_Page data = PageFactory.initElements(driver, Admin_WithdrawRefund_PopOut_Page.class);
            data.emailCheckboxDisplay(year, champName, searchData);
        }
        adminLogout.logout();

    }

    @Test(priority = 2, description = "TC-1828 Request Received By displays", enabled = true)
    public void requestReceivedByDisplay() throws Throwable {
        adminLogin.login1();
        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        for (int i = 16; i <= 16; i++) {

            String year = xl.getcelldata(sheetName, i, 1);
            String champName = xl.getcelldata(sheetName, i, 2);
            String searchData = xl.getcelldata(sheetName, i, 4);
            System.out.println(year + " test " + champName);
            Admin_WithdrawRefund_PopOut_Page data = PageFactory.initElements(driver, Admin_WithdrawRefund_PopOut_Page.class);
            data.requestReceivedBy(year, champName, searchData);
        }
        adminLogout.logout();
    }

    @Test(priority = 3, description = "TC-1835 Refund Amount displays", enabled = true)
    public void refundAmountDisplays() throws Throwable {
        adminLogin.login1();
        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        for (int i = 17; i <= 17; i++) {

            String year = xl.getcelldata(sheetName, i, 1);
            String champName = xl.getcelldata(sheetName, i, 2);
            String searchData = xl.getcelldata(sheetName, i, 4);
            System.out.println(year + " test " + champName);
            Admin_WithdrawRefund_PopOut_Page data = PageFactory.initElements(driver, Admin_WithdrawRefund_PopOut_Page.class);
            data.refundAmount(year, champName, searchData);
        }
        adminLogout.logout();
    }

    @Test(priority = 4, description = "TC-1839 Comment field displays", enabled = true)
    public void commentFieldDisplays() throws Throwable {
        adminLogin.login1();
        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        for (int i = 18; i <= 18; i++) {

            String year = xl.getcelldata(sheetName, i, 1);
            String champName = xl.getcelldata(sheetName, i, 2);
            String searchData = xl.getcelldata(sheetName, i, 4);
            System.out.println(year + " test " + champName);
            Admin_WithdrawRefund_PopOut_Page data = PageFactory.initElements(driver, Admin_WithdrawRefund_PopOut_Page.class);
            data.commentFieldDisplay(year, champName, searchData);
        }
        adminLogout.logout();
    }

    @Test(priority = 5, description = "TC-1847 Entry and Player Information display", enabled = true)
    public void entryPlayerInformationDisplays() throws Throwable {
        adminLogin.login1();
        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        for (int i = 19; i <= 19; i++) {

            String year = xl.getcelldata(sheetName, i, 1);
            String champName = xl.getcelldata(sheetName, i, 2);
            String searchData = xl.getcelldata(sheetName, i, 4);
            System.out.println(year + " test " + champName);
            Admin_WithdrawRefund_PopOut_Page data = PageFactory.initElements(driver, Admin_WithdrawRefund_PopOut_Page.class);
            data.entryPlayerInformation(year, champName, searchData);
        }
        adminLogout.logout();
    }

    @Test(priority = 6, description = "TC-1854 Withdrawal Reason displays", enabled = true)
    public void withdrawalReasonDisplay() throws Throwable {
        adminLogin.login1();
        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        for (int i = 20; i <= 20; i++) {
            String year = xl.getcelldata(sheetName, i, 1);
            String champName = xl.getcelldata(sheetName, i, 2);
            String searchData = xl.getcelldata(sheetName, i, 4);
            System.out.println(year + " test " + champName);
            Admin_WithdrawRefund_PopOut_Page data = PageFactory.initElements(driver, Admin_WithdrawRefund_PopOut_Page.class);
            data.withdrawalReason(year, champName, searchData);
        }
        adminLogout.logout();
    }
    @Test(priority = 7, description = "TC-1858 Module displays in a pop out when the user clicks on Withdraw Refund button", enabled = true)
    public void moduleDisplays() throws Throwable {
        adminLogin.login1();
        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        for (int i = 21; i <= 21; i++) {
            String year = xl.getcelldata(sheetName, i, 1);
            String champName = xl.getcelldata(sheetName, i, 2);
            String searchData = xl.getcelldata(sheetName, i, 4);
            System.out.println(year + " test " + champName);
            Admin_WithdrawRefund_PopOut_Page data = PageFactory.initElements(driver, Admin_WithdrawRefund_PopOut_Page.class);
            data.moduleDisplay(year, champName, searchData);
        }
        adminLogout.logout();
    }
    @Test(priority = 8, description = "TC-1906 Submit CTA displays", enabled = true)
    public void submitCTADisplays() throws Throwable {
        adminLogin.login1();
        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        for (int i = 22; i <= 22; i++) {
            String year = xl.getcelldata(sheetName, i, 1);
            String champName = xl.getcelldata(sheetName, i, 2);
            String searchData = xl.getcelldata(sheetName, i, 4);
            System.out.println(year + " test " + champName);
            Admin_WithdrawRefund_PopOut_Page data = PageFactory.initElements(driver, Admin_WithdrawRefund_PopOut_Page.class);
            data.submitCTADisplay(year, champName, searchData);
        }
        adminLogout.logout();
    }
}
