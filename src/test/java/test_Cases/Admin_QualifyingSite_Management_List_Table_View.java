package test_Cases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import page_Object.Admin_QualifyingSite_Management_List_Table_View_Page;
import test_Base.Admin_BaseClass;
import test_Base.Admin_Login;
import test_Base.Admin_Logout;
import utilities.ExcelFileUtil;

public class Admin_QualifyingSite_Management_List_Table_View extends Admin_BaseClass {
    String input = "./FileInput/ChampAdmin_TestData.xlsx";
    String sheetName = "Qualifying Site";
    ExcelFileUtil xl;
    int rc;
    Admin_Login adminLogin = new Admin_Login();
    Admin_Logout adminLogout = new Admin_Logout();

    @Test(priority = 1, description = "TC-1891 Add Site CTA is displayed and functioning ", enabled = true)
    public void QualifyingSite_Management_List_Table_View_Page() throws Throwable {
        adminLogin.login1();
        Admin_QualifyingSite_Management_List_Table_View_Page data = PageFactory.initElements(driver, Admin_QualifyingSite_Management_List_Table_View_Page.class);
        data.addSiteCTADisplayedAndFunctioning();
        adminLogout.logout();
    }

    @Test(priority = 2, description = "TC-1893 Table Area, Table Title are displayed and functioning", enabled = true)
    public void tableAreaTableTitlearedisplayedandfunctioning() throws Throwable {
        adminLogin.login1();
        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        for (int i = 2; i <= 2; i++) {
            String year = xl.getcelldata(sheetName, i, 1);
            String champName = xl.getcelldata(sheetName, i, 2);
            Admin_QualifyingSite_Management_List_Table_View_Page data = PageFactory.initElements(driver, Admin_QualifyingSite_Management_List_Table_View_Page.class);
            data.tableAreaTableTitlearedisplayedandfunctioning(year, champName);
        }
        adminLogout.logout();
    }

    @Test(priority = 3, description = "TC-1896 Download Players is displayed and functioning ", enabled = true)
    public void downloadPlayersIsDisplayedandFunctioning() throws Throwable {
        adminLogin.login1();
        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        for (int i = 3; i <= 3; i++) {
            String year = xl.getcelldata(sheetName, i, 1);
            String champName = xl.getcelldata(sheetName, i, 2);
            Admin_QualifyingSite_Management_List_Table_View_Page data = PageFactory.initElements(driver, Admin_QualifyingSite_Management_List_Table_View_Page.class);
            data.downloadPlayersIsDisplayedandFunctioning(year, champName);
        }
        adminLogout.logout();
    }

    @Test(priority = 4, description = "TC-1902 Close Qualifying Site CTA is displayed and functioning ", enabled = true)
    public void closeQualifyingSiteCTAIsDisplayedandFunctioning() throws Throwable {
        adminLogin.login1();
        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        for (int i = 4; i <= 4; i++) {
            String year = xl.getcelldata(sheetName, i, 1);
            String champName = xl.getcelldata(sheetName, i, 2);
            Admin_QualifyingSite_Management_List_Table_View_Page data = PageFactory.initElements(driver, Admin_QualifyingSite_Management_List_Table_View_Page.class);
            data.closeQualifyingSiteCTAIsDisplayedandFunctioning(year, champName);
        }
        adminLogout.logout();
    }
    @Test(priority = 5, description = "TC-2988 Search filed is displayed and functioning Search filed is displayed and functioning", enabled = true)
    public void Searchfiledisdisplayedandfunctioning() throws Throwable {
        adminLogin.login1();
        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        for (int i = 5; i <= 5; i++) {
            String year = xl.getcelldata(sheetName, i, 1);
            String champName = xl.getcelldata(sheetName, i, 2);
            String search =xl.getcelldata(sheetName,i,3);

            Admin_QualifyingSite_Management_List_Table_View_Page data = PageFactory.initElements(driver, Admin_QualifyingSite_Management_List_Table_View_Page.class);
            data.Searchfiledisdisplayedandfunctioning(year, champName,search);
        }
        adminLogout.logout();
    }
    @Test(priority = 6, description = "TC-2989 Export CTA displays and functioning", enabled = true)
    public void exportCTAIsDisplayedAndFunctioning() throws Throwable {
        adminLogin.login1();
        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        for (int i = 6; i <= 6; i++) {
            String year = xl.getcelldata(sheetName, i, 1);
            String champName = xl.getcelldata(sheetName, i, 2);

            Admin_QualifyingSite_Management_List_Table_View_Page data = PageFactory.initElements(driver, Admin_QualifyingSite_Management_List_Table_View_Page.class);
            data.exportCTAIsDisplayedAndFunctioning(year, champName);
        }
        adminLogout.logout();
    }
}
