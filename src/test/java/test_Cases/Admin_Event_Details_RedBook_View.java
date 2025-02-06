package test_Cases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import page_Object.Admin_Event_Details_RedBook_View_Page;
import test_Base.Admin_BaseClass;
import test_Base.Admin_Login;
import test_Base.Admin_Logout;
import utilities.ExcelFileUtil;

public class Admin_Event_Details_RedBook_View extends Admin_BaseClass {
    String input = "./FileInput/ChampAdmin_TestData.xlsx";
    String sheetName = "Champ_Details";
    ExcelFileUtil xl;
    int rc;
    Admin_Login adminLogin = new Admin_Login();
    Admin_Logout adminLogout = new Admin_Logout();

    @Test(priority = 1, description = "TC-1929 List of qualifying sites will display with qualified players, Alternate 1 and Alternate 2 related to the qualifying sites", enabled = true)
    public void listOfQualifyingSitesDisplays() throws Throwable {
        adminLogin.login1();
        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        for (int i = 20; i <= 20; i++) {

            String year = xl.getcelldata(sheetName, i, 1);
            String champName = xl.getcelldata(sheetName, i, 2);
            Admin_Event_Details_RedBook_View_Page data = PageFactory.initElements(driver, Admin_Event_Details_RedBook_View_Page.class);
            data.listOfQualifyingSitesDisplays(year, champName);
        }
        adminLogout.logout();
    }

    @Test(priority = 2, description = "TC-1935 Rank list item is displayed and functioning", enabled = true)
    public void rankListItemIsDisplayedFunctioning() throws Throwable {
        adminLogin.login1();
        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        for (int i = 21; i <= 21; i++) {

            String year = xl.getcelldata(sheetName, i, 1);
            String champName = xl.getcelldata(sheetName, i, 2);
            String rank = xl.getcelldata(sheetName, i, 3);
            Admin_Event_Details_RedBook_View_Page data = PageFactory.initElements(driver, Admin_Event_Details_RedBook_View_Page.class);
            data.rankListItemIsDisplayedFunctioning(year, champName, rank);
        }
        adminLogout.logout();
    }

    @Test(priority = 3, description = "TC-1940 Save CTA is displayed and functioning", enabled = true)
    public void saveCTAIsDisplayedFunctioning() throws Throwable {
        adminLogin.login1();
        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        for (int i = 22; i <= 22; i++) {

            String year = xl.getcelldata(sheetName, i, 1);
            String champName = xl.getcelldata(sheetName, i, 2);
            String rank = xl.getcelldata(sheetName, i, 3);
            Admin_Event_Details_RedBook_View_Page data = PageFactory.initElements(driver, Admin_Event_Details_RedBook_View_Page.class);
            data.saveCTAIsDisplayedFunctioning(year, champName, rank);
        }
        adminLogout.logout();
    }
    @Test(priority = 4, description = "TC-1940 Qualifier Information Table: Column Header and Rows are displayed", enabled = true)
    public void qualifierInformationDisplay() throws Throwable {
        adminLogin.login1();
        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        for (int i = 22; i <= 22; i++) {

            String year = xl.getcelldata(sheetName, i, 1);
            String champName = xl.getcelldata(sheetName, i, 2);
            String rank = xl.getcelldata(sheetName, i, 3);
            Admin_Event_Details_RedBook_View_Page data = PageFactory.initElements(driver, Admin_Event_Details_RedBook_View_Page.class);
            data.qualifierInformation(year, champName);
        }
        adminLogout.logout();
    }
}
