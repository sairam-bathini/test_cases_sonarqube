package test_Cases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import page_Object.Admin_Event_Details_Page;
import test_Base.Admin_BaseClass;
import test_Base.Admin_Login;
import test_Base.Admin_Logout;
import utilities.ExcelFileUtil;

public class Admin_Event_Details extends Admin_BaseClass {
    String input = "./FileInput/ChampAdmin_TestData.xlsx";
    String sheetName = "Champ_Details";
    ExcelFileUtil xl;
    int rc;
    Admin_Login adminLogin = new Admin_Login();
    Admin_Logout adminLogout = new Admin_Logout();

    @Test(priority = 1, description = "TC-1917 Email Section displays", enabled = true)
    public void emailSectionDisplays() throws Throwable {
        adminLogin.login1();
        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        for (int i = 7; i <= 7; i++) {

            String year = xl.getcelldata(sheetName, i, 1);
            String champName = xl.getcelldata(sheetName, i, 2);
            Admin_Event_Details_Page data = PageFactory.initElements(driver, Admin_Event_Details_Page.class);
            data.emailSectionDisplay(year, champName);
        }
        adminLogout.logout();

    }

    @Test(priority = 2, description = "TC-1924 Reports Section displays", enabled = true)
    public void reportSectionDisplays() throws Throwable {
        adminLogin.login1();
        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        for (int i = 8; i <= 8; i++) {

            String year = xl.getcelldata(sheetName, i, 1);
            String champName = xl.getcelldata(sheetName, i, 2);
            Admin_Event_Details_Page data = PageFactory.initElements(driver, Admin_Event_Details_Page.class);
            data.reportSectionDisplay(year, champName);
        }
        adminLogout.logout();
    }

    @Test(priority = 3, description = "TC-1883 Application Summary displays", enabled = true)
    public void applicationSummaryDisplays() throws Throwable {
        adminLogin.login1();
        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        for (int i = 9; i <= 9; i++) {

            String year = xl.getcelldata(sheetName, i, 1);
            String champName = xl.getcelldata(sheetName, i, 2);
            Admin_Event_Details_Page data = PageFactory.initElements(driver, Admin_Event_Details_Page.class);
            data.applicationSummaryDisplay(year, champName);
        }
        adminLogout.logout();
    }

    @Test(priority = 4, description = "TC-1883 Application Summary displays", enabled = true)
    public void playersEligibleToApplyAfterCloseOfEntries() throws Throwable {
        adminLogin.login1();
        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        for (int i = 10; i <= 10; i++) {

            String year = xl.getcelldata(sheetName, i, 1);
            String champName = xl.getcelldata(sheetName, i, 2);
            String playerId = xl.getcelldata(sheetName, i, 3);
            Admin_Event_Details_Page data = PageFactory.initElements(driver, Admin_Event_Details_Page.class);
            data.playersEligibleToApplyAfterCloseOfEntry(year, champName, playerId);
        }
        adminLogout.logout();
    }

    @Test(priority = 5, description = "TC-1883 Application Summary displays", enabled = true)
    public void selectedYearChampDropDowndisplays() throws Throwable {
        adminLogin.login1();
        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        for (int i = 11; i <= 11; i++) {

            String year = xl.getcelldata(sheetName, i, 1);
            String champName = xl.getcelldata(sheetName, i, 2);
            String champYear = xl.getcelldata(sheetName, i, 4);
            String champName1 = xl.getcelldata(sheetName, i, 5);
            Admin_Event_Details_Page data = PageFactory.initElements(driver, Admin_Event_Details_Page.class);
            data.selectedYearChampDropDowndisplay(year, champName, champYear, champName1);
        }
        adminLogout.logout();
    }

    @Test(priority = 6, description = "TC-1901 USGA Staff Management", enabled = true)
    public void USGAStaffManagement() throws Throwable {
        adminLogin.login1();
        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        for (int i = 12; i <= 12; i++) {

            String year = xl.getcelldata(sheetName, i, 1);
            String champName = xl.getcelldata(sheetName, i, 2);

            Admin_Event_Details_Page data = PageFactory.initElements(driver, Admin_Event_Details_Page.class);
            data.USGAStaffManagement(year, champName);
        }
        adminLogout.logout();
    }

    @Test(priority = 7, description = "TC-1909 AGA Management Displays", enabled = true)
    public void AGAManagementDisplays() throws Throwable {
        adminLogin.login1();
        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        for (int i = 13; i <= 13; i++) {

            String year = xl.getcelldata(sheetName, i, 1);
            String champName = xl.getcelldata(sheetName, i, 2);

            Admin_Event_Details_Page data = PageFactory.initElements(driver, Admin_Event_Details_Page.class);
            data.AGAManagementDisplays(year, champName);
        }
        adminLogout.logout();
    }

    @Test(priority = 8, description = "TC-3024 Verify Qualifying Results Page", enabled = true)
    public void verifyQualifyingResultsPage() throws Throwable {
        adminLogin.login1();
        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        for (int i = 14; i <= 14; i++) {

            String year = xl.getcelldata(sheetName, i, 1);
            String champName = xl.getcelldata(sheetName, i, 2);
            String champyear = xl.getcelldata(sheetName, i, 4);
            String champName1 = xl.getcelldata(sheetName, i, 5);
            String qSite = xl.getcelldata(sheetName, i, 6);

            Admin_Event_Details_Page data = PageFactory.initElements(driver, Admin_Event_Details_Page.class);
            data.verifyQualifyingResultsPage(year, champName, champyear, champName1, qSite);
        }
        // logout.logout();
    }
}
