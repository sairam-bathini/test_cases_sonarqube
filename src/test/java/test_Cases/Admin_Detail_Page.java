package test_Cases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import page_Object.Admin_Detail_Page_Page;
import test_Base.Admin_BaseClass;
import test_Base.Admin_Login;
import test_Base.Admin_Logout;
import utilities.ExcelFileUtil;

public class Admin_Detail_Page extends Admin_BaseClass {
    String input = "./FileInput/ChampAdmin_TestData.xlsx";
    String sheetName = "Qualifying Site";
    ExcelFileUtil xl;
    int rc;
    Admin_Login adminLogin = new Admin_Login();
    Admin_Logout adminLogout = new Admin_Logout();

    @Test(priority = 1, description = "TC-1908 Save CTA is displayed and functioning", enabled = true)
    public void QualifyingSite_Management_List_Table_View_Page() throws Throwable {
        adminLogin.login1();
        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        for (int i = 14; i <= 14; i++) {
            String year = xl.getcelldata(sheetName, i, 1);
            String champName = xl.getcelldata(sheetName, i, 2);

            Admin_Detail_Page_Page data = PageFactory.initElements(driver, Admin_Detail_Page_Page.class);
            data.saveCTADisplayedAndFunctioning(year, champName);
        }
        adminLogout.logout();
    }
}
