package test_Cases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import page_Object.Admin_Event_Details_Pairings_Page;
import test_Base.Admin_BaseClass;
import test_Base.Admin_Login;
import test_Base.Admin_Logout;
import utilities.ExcelFileUtil;

public class Admin_Event_Details_Pairings extends Admin_BaseClass {
    String input = "./FileInput/ChampAdmin_TestData.xlsx";
    String sheetName = "Champ_Details";
    ExcelFileUtil xl;
    int rc;
    Admin_Login adminLogin = new Admin_Login();
    Admin_Logout adminLogout = new Admin_Logout();

    @Test(priority = 1, description = "TC-1865 Rules Randomise All  CTA is displayed and functioning ", enabled = false)
    public void listOfQualifyingSitesDisplays() throws Throwable {
        adminLogin.login1();
        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        for (int i = 27; i <= 27; i++) {

            String year = xl.getcelldata(sheetName, i, 1);
            String champName = xl.getcelldata(sheetName, i, 2);
            Admin_Event_Details_Pairings_Page data = PageFactory.initElements(driver, Admin_Event_Details_Pairings_Page.class);
            data.rulesRandomiseAllCTAIsDisplayedAndfunctioning(year, champName);
        }
        adminLogout.logout();
    }

    @Test(priority = 2, description = "TC-1872 Unpair All  CTA is displayed and functioning ", enabled = false)
    public void unpairAllCTAIsDisplayedAndfunctioning() throws Throwable {
        adminLogin.login1();
        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        for (int i = 28; i <= 28; i++) {

            String year = xl.getcelldata(sheetName, i, 1);
            String champName = xl.getcelldata(sheetName, i, 2);
            Admin_Event_Details_Pairings_Page data = PageFactory.initElements(driver, Admin_Event_Details_Pairings_Page.class);
            data.unpairAllCTAIsDisplayedAndfunctioning(year, champName);
        }
        adminLogout.logout();
    }

    @Test(priority = 3, description = "TC-1868 Save CTA is displayed and functioning", enabled = false)
    public void saveAllCTAIsDisplayedAndfunctioning() throws Throwable {
        adminLogin.login1();
        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        for (int i = 29; i <= 29; i++) {

            String year = xl.getcelldata(sheetName, i, 1);
            String champName = xl.getcelldata(sheetName, i, 2);
            Admin_Event_Details_Pairings_Page data = PageFactory.initElements(driver, Admin_Event_Details_Pairings_Page.class);
            data.saveAllCTAIsDisplayedAndfunctioning(year, champName);
        }
        adminLogout.logout();
    }

    @Test(priority = 4, description = "TC-1873 Table area is displayed", enabled = false)
    public void tableAreaIsDisplayed() throws Throwable {
        adminLogin.login1();
        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        for (int i = 30; i <= 30; i++) {
            String year = xl.getcelldata(sheetName, i, 1);
            String champName = xl.getcelldata(sheetName, i, 2);
            Admin_Event_Details_Pairings_Page data = PageFactory.initElements(driver, Admin_Event_Details_Pairings_Page.class);
            data.tableAreaIsDisplayed(year, champName);
        }
        adminLogout.logout();
    }

    @Test(priority = 5, description = "TC-1876 Add CTA is displayed and functioning", enabled = false)
    public void addCTAIsDisplayed() throws Throwable {
        adminLogin.login1();
        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        for (int i = 31; i <= 31; i++) {
            String year = xl.getcelldata(sheetName, i, 1);
            String champName = xl.getcelldata(sheetName, i, 2);
            Admin_Event_Details_Pairings_Page data = PageFactory.initElements(driver, Admin_Event_Details_Pairings_Page.class);
            data.addCTAIsDisplayed(year, champName);
        }
        adminLogout.logout();
    }
    @Test(priority = 6, description = "TC-1879 Unpair CTA is displayed and functioning", enabled = true)
    public void unpairCTAIsDisplayed() throws Throwable {
        adminLogin.login1();
        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        for (int i = 32; i <= 32; i++) {
            String year = xl.getcelldata(sheetName, i, 1);
            String champName = xl.getcelldata(sheetName, i, 2);
            Admin_Event_Details_Pairings_Page data = PageFactory.initElements(driver, Admin_Event_Details_Pairings_Page.class);
            data.unpairCTAIsDisplayed(year, champName);
        }
        adminLogout.logout();
    }
    @Test(priority = 7, description = "TC-1881 Export CTA displays and functioning", enabled = false)
    public void exportCTAIsDisplayed() throws Throwable {
        adminLogin.login1();
        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        for (int i = 33; i <= 33; i++) {
            String year = xl.getcelldata(sheetName, i, 1);
            String champName = xl.getcelldata(sheetName, i, 2);
            Admin_Event_Details_Pairings_Page data = PageFactory.initElements(driver, Admin_Event_Details_Pairings_Page.class);
            data.exportCTAIsDisplayed(year, champName);
        }
        adminLogout.logout();
    }
    @Test(priority = 8, description = "TC-1885 Access to Pairings page", enabled = false)
    public void accessToPairingsPage() throws Throwable {
        adminLogin.login1();
        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        for (int i = 34; i <= 34; i++) {
            String year = xl.getcelldata(sheetName, i, 1);
            String champName = xl.getcelldata(sheetName, i, 2);
            Admin_Event_Details_Pairings_Page data = PageFactory.initElements(driver, Admin_Event_Details_Pairings_Page.class);
            data.accessToPairingsPage(year, champName);
        }
        adminLogout.logout();
    }
    @Test(priority = 9, description = "TC-1887 Plain Randomise CTA is displayed and functioning", enabled = false)
    public void plainRandomiseCTAisDisplayedandfunctioning() throws Throwable {
        adminLogin.login1();
        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        for (int i = 35; i <= 35; i++) {
            String year = xl.getcelldata(sheetName, i, 1);
            String champName = xl.getcelldata(sheetName, i, 2);
            Admin_Event_Details_Pairings_Page data = PageFactory.initElements(driver, Admin_Event_Details_Pairings_Page.class);
            data.plainRandomiseCTAisDisplayedandfunctioning(year, champName);
        }
        adminLogout.logout();
    }

}
