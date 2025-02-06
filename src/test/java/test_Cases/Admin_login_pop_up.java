package test_Cases;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.Test;

import page_Object.Admin_login_pop_up_page;
import test_Base.Admin_BaseClass;
import test_Base.Admin_Logout;
import utilities.ExcelFileUtil;

public class Admin_login_pop_up extends Admin_BaseClass {

    WebDriverWait wait;
    String input = "./FileInput/ChampAdmin_TestData.xlsx";
    String sheetName = "Forget_Pass";
    String sheetName1 = "Admin_profile";
    static ExcelFileUtil xl;
    int rc;
    Admin_Logout adminLogout = new Admin_Logout();

    @Test(priority = 1, description = "TC-1823 Email field is required, displayed and functioning", enabled = true)
    public void emailVerification() throws Throwable {
        wait = new WebDriverWait(driver, Duration.ofMinutes(2));

        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        for (int i = 1; i <= 1; i++) {

            String invalidEmail = xl.getcelldata(sheetName, i, 0);
            Admin_login_pop_up_page data = PageFactory.initElements(driver, Admin_login_pop_up_page.class);
            data.emailVerification(invalidEmail);
        }

    }

    @Test(priority = 2, description = "TC-1829 Password Field is required, displayed and functioning ")
    public void passwordVerification() throws Throwable {

        wait = new WebDriverWait(driver, Duration.ofMinutes(2));

        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName1);
        for (int i = 1; i <= 1; i++) {

            String validEmail = xl.getcelldata(sheetName1, i, 0);
            String invalidPassword = xl.getcelldata(sheetName1, i, 2);
            Admin_login_pop_up_page data = PageFactory.initElements(driver, Admin_login_pop_up_page.class);
            data.passwordVerification(validEmail, invalidPassword);
        }

    }

    @Test(priority = 4, description = "TC-1845 'Don't remember your password?' Link is displayed and functioning")
    public void forgotPassword() throws Throwable {
        {

            wait = new WebDriverWait(driver, Duration.ofMinutes(2));
            xl = new ExcelFileUtil(input);
            rc = xl.rowcount(sheetName1);
            for (int i = 1; i <= 1; i++) {

                String validEmail = xl.getcelldata(sheetName1, i, 0);
                Admin_login_pop_up_page data = PageFactory.initElements(driver, Admin_login_pop_up_page.class);
                data.forgotPassword(validEmail);
            }

        }
    }

    @Test(priority = 5, description = "TC-1837 Log In CTA is active and functioning and TC-1816 Admin menu is displayed and functioning")
    public void login() throws Throwable {
        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName1);
        for (int i = 1; i <= 1; i++) {

            String validEmail = xl.getcelldata(sheetName1, i, 0);
            String validPassword = xl.getcelldata(sheetName1, i, 1);
            Admin_login_pop_up_page data = PageFactory.initElements(driver, Admin_login_pop_up_page.class);
            data.loginApplication(validEmail, validPassword);
        }
        adminLogout.logout();

    }

}
