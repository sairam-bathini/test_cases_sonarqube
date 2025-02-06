package test_Cases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import page_Object.Admin_Event_Details_Bulk_Withdraw_Page;
import test_Base.Admin_BaseClass;
import test_Base.Admin_Login;
import test_Base.Admin_Logout;
import utilities.ExcelFileUtil;

public class Admin_Event_Details_Bulk_Withdraw extends Admin_BaseClass {
    String input = "./FileInput/ChampAdmin_TestData.xlsx";
    String sheetName = "Champ_Details";
    ExcelFileUtil xl;
    int rc;
    Admin_Login adminLogin = new Admin_Login();
    Admin_Logout adminLogout = new Admin_Logout();

    @Test(priority = 1, description = "TC-1890 Table Pagination is displayed and functioning ", enabled = true)
    public void listOfQualifyingSitesDisplays() throws Throwable {
        adminLogin.login1();
        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        for (int i = 39; i <= 39; i++) {
            String year = xl.getcelldata(sheetName, i, 1);
            String champName = xl.getcelldata(sheetName, i, 2);
            String pageNumber = xl.getcelldata(sheetName, i, 3);

            Admin_Event_Details_Bulk_Withdraw_Page data = PageFactory.initElements(driver, Admin_Event_Details_Bulk_Withdraw_Page.class);
            data.tablePaginationIsDisplayedAndfunctioning(year, champName,pageNumber);
        }
        adminLogout.logout();
    }
}
