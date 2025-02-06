package test_Base;

import org.openqa.selenium.support.PageFactory;
import page_Object.Admin_Logout_Page;

public class Admin_Logout extends Admin_BaseClass {

public void logout(){
        Admin_Logout_Page data = PageFactory.initElements(driver, Admin_Logout_Page.class);
        data.logOut();
    }
}
