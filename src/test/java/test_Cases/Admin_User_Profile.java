package test_Cases;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import page_Object.Admin_User_Profile_page;
import test_Base.Admin_BaseClass;
import utilities.ExcelFileUtil;

public class Admin_User_Profile extends Admin_BaseClass {

    WebDriverWait wait;
    String input = "./FileInput/ChampAdmin_TestData.xlsx";
    String sheetName = "Admin_profile";
    static ExcelFileUtil xl;
    int rc;

    @Test(priority = 1, description = "TC-1830 Sign Out CTA is displayed & functioning " )
    public void signOut() throws Throwable {

        wait = new WebDriverWait(driver, Duration.ofMinutes(1));

        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        for (int i = 1; i <= 1; i++) {

            String validemail = xl.getcelldata(sheetName, i, 0);
            String validpass = xl.getcelldata(sheetName, i, 1);
            Admin_User_Profile_page data = PageFactory.initElements(driver, Admin_User_Profile_page.class);
            data.signOut(validemail, validpass);
            System.out.println(validemail + "  " + validpass);
        }



    }

    @Test(priority = 2, description = "TC-1834 & TC-1844 General Information section & Save Changes CTA ")
    public void generalInformationSection_and_SaveChangesCTA() throws Throwable {

        wait = new WebDriverWait(driver, Duration.ofMinutes(1));

        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);

            for (int i = 1; i <= 1; i++) {

                String validemail = xl.getcelldata(sheetName, i, 0);
                String validpass = xl.getcelldata(sheetName, i, 1);
                String firstName = xl.getcelldata(sheetName, i, 3);
                String lastName = xl.getcelldata(sheetName, i, 4);
                Admin_User_Profile_page data = PageFactory.initElements(driver, Admin_User_Profile_page.class);
                data.generalInformationSection_and_SaveChangesCTA(validemail,validpass,firstName,lastName);
                System.out.println(validemail + "  " + validpass);
            }



    }

    @Test(priority = 3, description = "TC-1841 Change Password section is displayed and functioning")
    public void changePassword() throws Throwable {

        wait = new WebDriverWait(driver, Duration.ofMinutes(1));


        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        try {
            for (int i = 1; i <= 1; i++) {

                String validemail = xl.getcelldata(sheetName, i, 0);
                String validpass = xl.getcelldata(sheetName, i, 1);
                Admin_User_Profile_page data = PageFactory.initElements(driver, Admin_User_Profile_page.class);
                data.changePswd(validemail, validpass);
            }
        } catch (Exception e) {

        }

    }

}
