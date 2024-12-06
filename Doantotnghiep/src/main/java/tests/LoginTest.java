package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseSetup;
import pages.LoginPage;

public class LoginTest extends BaseSetup {

    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        driver = getDriver();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginTest() throws InterruptedException {
        driver.get("https://tiki.vn/");
        Thread.sleep(5000);

        loginPage.Qc(); // Đóng quảng cáo nếu có
        Thread.sleep(5000);
        loginPage.Tk(); // Mở menu tài khoản
        Thread.sleep(5000);

        // Nhập vào trường số điện thoại
        loginPage.Sdt("0967931759"); 
        loginPage.clicktt(); 
        Thread.sleep(5000);

        // Nhập vào trường mật khẩu
        loginPage.Mk("Manhtran0607"); 
        loginPage.Dn();
        
        // Dừng lại để nhập CAPTCHA thủ công
        System.out.println("Vui lòng nhập CAPTCHA thủ công.");
        Thread.sleep(20000); // Dừng 30 giây để nhập CAPTCHA
        
        loginPage.Qc(); // Đóng quảng cáo nếu có
        Thread.sleep(5000);
        
    }

    @AfterMethod
    public void tearDown() throws Exception {
        super.tearDown(); // Dọn dẹp sau kiểm thử
    }
}






//package tests;
//
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//import base.BaseSetup;
//import pages.LoginPage;
//import utils.ExcelUtils;
//import org.openqa.selenium.By;
//
//public class LoginTest extends BaseSetup {
//    private LoginPage loginPage;
//    private ExcelUtils excelUtils;
//
//    @BeforeMethod
//    public void setUp() throws Exception {
//        driver = getDriver();
//        loginPage = new LoginPage(driver);
//
//        // Đường dẫn tới file Excel và tên sheet
//        String filePath = "C:\\Users\\ASIS\\eclipse-workspace\\Doantotnghiep\\src\\test\\login.xlsx";
//        String sheetName = "Sheet1";
//        excelUtils = new ExcelUtils(filePath, sheetName);
//    }
//
//    @Test
//    public void loginTest() throws InterruptedException {
//        // Mở trang Tiki
//        driver.get("https://tiki.vn/");
//        Thread.sleep(5000);
//
//        // Đóng quảng cáo nếu có
//        loginPage.Qc();
//        Thread.sleep(5000);
//
//        // Mở menu tài khoản
//        loginPage.Tk();
//        Thread.sleep(5000);
//
//        // Lấy số lượng tài khoản từ file Excel
//        int totalRows = excelUtils.getTotalRows();
//
//        // Lặp qua từng tài khoản trong file Excel
//        for (int i = 0; i < totalRows; i++) {
//            String phoneNumber = excelUtils.getCellData(i, 0); // Cột 0: Số điện thoại
//            String password = excelUtils.getCellData(i, 1);    // Cột 1: Mật khẩu
//
//            System.out.println("Thử đăng nhập với tài khoản: " + phoneNumber);
//
//            try {
//                // Nhập số điện thoại
//                loginPage.Sdt(phoneNumber);
//                loginPage.clicktt();
//                Thread.sleep(5000);
//
//                // Nhập mật khẩu
//                loginPage.Mk(password);
//                loginPage.Dn();
//
//                // Dừng để nhập CAPTCHA thủ công
//                System.out.println("Vui lòng nhập CAPTCHA thủ công.");
//                Thread.sleep(20000); // Dừng 20 giây để nhập CAPTCHA
//
//                // Kiểm tra trạng thái đăng nhập thành công
//                if (isLoginSuccessful()) {
//                    System.out.println("Đăng nhập thành công với tài khoản: " + phoneNumber);
//                    return; // Dừng vòng lặp và kết thúc nếu đăng nhập thành công
//                } else {
//                    System.out.println("Đăng nhập thất bại với tài khoản: " + phoneNumber);
//                }
//            } catch (Exception e) {
//                System.out.println("Lỗi khi thử đăng nhập với tài khoản: " + phoneNumber);
//                e.printStackTrace();
//            }
//
//            // Reset giao diện trước khi thử tài khoản khác
//            resetLoginState();
//        }
//
//        System.out.println("Không có tài khoản nào đăng nhập thành công.");
//    }
//
//    // Kiểm tra nếu đăng nhập thành công
//    private boolean isLoginSuccessful() {
//        try {
//            // Kiểm tra một phần tử xuất hiện sau khi đăng nhập thành công
//            return driver.findElement(By.xpath("//div[contains(text(),'Tài khoản của bạn')]")).isDisplayed();
//        } catch (Exception e) {
//            return false; // Nếu không tìm thấy phần tử, tức là đăng nhập thất bại
//        }
//    }
//
//    // Hàm reset trạng thái sau khi đăng nhập thất bại
//    private void resetLoginState() throws InterruptedException {
//        // Đóng quảng cáo nếu có
//        loginPage.Qc();
//        Thread.sleep(2000);
//
//        // Mở lại menu tài khoản để thử tài khoản mới
//        loginPage.Tk();
//        Thread.sleep(2000);
//    }
//    @AfterMethod
//    public void tearDown() throws Exception {
//        if (excelUtils != null) {
//            excelUtils.close(); // Đóng workbook
//        }
//        super.tearDown(); // Dọn dẹp sau kiểm thử
//    }
//}
