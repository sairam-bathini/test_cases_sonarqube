package test_Cases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import page_Object.Admin_Add_Site_Page;
import test_Base.Admin_BaseClass;
import test_Base.Admin_Login;
import test_Base.Admin_Logout;
import utilities.ExcelFileUtil;

public class Admin_Add_Site extends Admin_BaseClass {
    String input = "./FileInput/ChampAdmin_TestData.xlsx";
    String sheetName = "Qualifying Site";
    ExcelFileUtil xl;
    int rc;
    Admin_Login adminLogin = new Admin_Login();
    Admin_Logout adminLogout = new Admin_Logout();

    @Test(priority = 1, description = "TC-1891 Add Site CTA is displayed and functioning ", enabled = true)
    public void QualifyingSite_Management_List_Table_View_Page() throws Throwable {
        adminLogin.login1();
        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        for (int i = 10; i <= 10; i++) {
            String year = xl.getcelldata(sheetName, i, 1);
            String champName = xl.getcelldata(sheetName, i, 2);
            String siteNumber = xl.getcelldata(sheetName, i, 3);
            String typeOfQualifying = xl.getcelldata(sheetName, i, 4);
            String city = xl.getcelldata(sheetName, i, 5);
            String country = xl.getcelldata(sheetName, i, 6);
            String qualifyingDate = xl.getcelldata(sheetName, i, 7);
            String rainDate = xl.getcelldata(sheetName, i, 8);
            String maxSiteCapacity = xl.getcelldata(sheetName, i, 9);
            String practiceDates = xl.getcelldata(sheetName, i, 10);
            String websiteGA = xl.getcelldata(sheetName, i, 11);
            String cartsAvailable = xl.getcelldata(sheetName, i, 12);
            String pushCarts = xl.getcelldata(sheetName, i, 13);
            String courseAccess = xl.getcelldata(sheetName, i, 14);
            String clubSearch = xl.getcelldata(sheetName, i, 15);
            String pocSearch = xl.getcelldata(sheetName, i, 16);
            String fName = xl.getcelldata(sheetName, i, 17);
            String lName = xl.getcelldata(sheetName, i, 18);
            String agaName = xl.getcelldata(sheetName, i, 19);
            String state = xl.getcelldata(sheetName, i, 20);


            Admin_Add_Site_Page data = PageFactory.initElements(driver, Admin_Add_Site_Page.class);
            data.saveCTADisplayedAndFunctioning(year, champName, siteNumber, typeOfQualifying, city, country, qualifyingDate, rainDate, maxSiteCapacity, practiceDates, websiteGA, cartsAvailable,
                    pushCarts, courseAccess, clubSearch, pocSearch, fName, lName, agaName,state);
        }
        adminLogout.logout();
    }
}
