package test_Cases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import page_Object.Admin_Bulk_Qualified_Alternate_Page;
import test_Base.Admin_BaseClass;
import test_Base.Admin_Login;
import test_Base.Admin_Logout;

public class Admin_Bulk_Qualified_Alternate extends Admin_BaseClass {
    Admin_Login adminLogin = new Admin_Login();
    Admin_Logout adminLogout = new Admin_Logout();

    @Test(priority = 1, description = "TC-1912 Table Send CTA is displayed and functioning ", enabled = true)
    public void tableSendCTADisplays() throws Throwable {
        adminLogin.login1();
        Admin_Bulk_Qualified_Alternate_Page data = PageFactory.initElements(driver, Admin_Bulk_Qualified_Alternate_Page.class);
        data.tableSendCTADisplays();
        adminLogout.logout();
    }

    @Test(priority = 2, description = "TC-1918 Table Area displays ", enabled = true)
    public void tableAreaDisplays() throws Throwable {
        adminLogin.login1();
        Admin_Bulk_Qualified_Alternate_Page data = PageFactory.initElements(driver, Admin_Bulk_Qualified_Alternate_Page.class);
        data.tableAreaDisplays();
        adminLogout.logout();
    }
}
