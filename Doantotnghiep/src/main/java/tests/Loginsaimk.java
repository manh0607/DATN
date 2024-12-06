package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseSetup;
import pages.LoginPage;

public class Loginsaimk extends BaseSetup {

    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        driver = getDriver();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginWithIncorrectPasswordTest() throws InterruptedException {
        driver.get("https://tiki.vn/");
        Thread.sleep(5000);

        loginPage.Qc(); // Đóng quảng cáo nếu có
        loginPage.Tk(); // Mở menu tài khoản
        Thread.sleep(5000);

        // Nhập vào trường số điện thoại
        loginPage.Sdt("0967931759"); 
        loginPage.clicktt(); 
        Thread.sleep(5000);

        // Nhập mật khẩu sai vào trường mật khẩu
        loginPage.Mk("acftgghh"); 
        loginPage.Dn();
        
        // Dừng lại để nhập CAPTCHA thủ công nếu cần
        System.out.println("Vui lòng nhập CAPTCHA thủ công. Sau khi hoàn tất, kiểm thử sẽ tiếp tục sau 10 giây...");
        Thread.sleep(30000); // Dừng 30 giây để nhập CAPTCHA
        
    }

    @AfterMethod
    public void tearDown() throws Exception {
        super.tearDown(); // Dọn dẹp sau kiểm thử
    }
}
