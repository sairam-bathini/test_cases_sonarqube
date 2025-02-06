package test_Cases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import page_Object.Admin_ChampManagement_Create_Team_Page;
import test_Base.Admin_BaseClass;
import test_Base.Admin_Login;
import test_Base.Admin_Logout;
import utilities.ExcelFileUtil;

public class Admin_ChampManagement_Create_Team extends Admin_BaseClass {
    String input = "./FileInput/ChampAdmin_TestData.xlsx";
    String sheetName = "Champ_Details";
    ExcelFileUtil xl;
    int rc;
    Admin_Login adminLogin = new Admin_Login();
    Admin_Logout adminLogout = new Admin_Logout();

    @Test(priority = 1, description = "TC-1871 Merge into Team CTA ", enabled = true)
    public void listOfQualifyingSitesDisplays() throws Throwable {
        adminLogin.login1();
        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        for (int i = 43; i <= 43; i++) {

            String year = xl.getcelldata(sheetName, i, 1);
            String champName = xl.getcelldata(sheetName, i, 2);
            String pageNumber = xl.getcelldata(sheetName, i, 3);

            Admin_ChampManagement_Create_Team_Page data = PageFactory.initElements(driver, Admin_ChampManagement_Create_Team_Page.class);
            data.mergeIntoTeam(year, champName);
        }
          adminLogout.logout();
    }
}
