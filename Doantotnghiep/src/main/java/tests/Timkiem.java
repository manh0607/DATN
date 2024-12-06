//package tests;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//import base.BaseSetup;
//import pages.LoginPage;
//
//public class Timkiem extends BaseSetup {
//
//    private LoginPage loginPage;
//
//    @BeforeMethod
//    public void setUp() {
//        driver = getDriver();
//        loginPage = new LoginPage(driver);
//    }
//
//    @Test
//    public void loginTest() throws InterruptedException {
//        driver.get("https://tiki.vn/");
//        Thread.sleep(5000);
//
//        loginPage.Qc(); // Đóng quảng cáo nếu có
//        Thread.sleep(5000);
//        
//        loginPage.Sanpham("Iphone 12 pro max");// nhập tên sản phẩm
//        Thread.sleep(2000);
//        loginPage.clickTimkiem(); 
//        Thread.sleep(10000);
//
//    }
//
//    @AfterMethod
//    public void tearDown() {
//        super.tearDown(); // Dọn dẹp sau kiểm thử
//    }
//}



package tests;

import base.BaseSetup;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ExcelUtils;

import java.util.List;

public class Timkiem extends BaseSetup {

    private LoginPage loginPage;
    private ExcelUtils excelUtils;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = getDriver();
        loginPage = new LoginPage(driver);

        // Khởi tạo ExcelUtils với file và sheet cụ thể
        String filePath = "C:\\Users\\ASIS\\eclipse-workspace\\Doantotnghiep\\src\\test\\timkiem.xlsx";
        String sheetName = "Sheet1";
        excelUtils = new ExcelUtils(filePath, sheetName);
    }

    @Test
    public void searchWithExcelData() throws InterruptedException {
        // Lấy danh sách sản phẩm từ file Excel
        List<String> productNames = excelUtils.readExcelData();

        // Mở trang Tiki
        driver.get("https://tiki.vn/");
        Thread.sleep(5000);

        loginPage.Qc(); // Đóng quảng cáo nếu có
        Thread.sleep(5000);

        // Lặp qua danh sách sản phẩm từ file Excel
        for (String product : productNames) {
            // Xóa sạch nội dung trong ô tìm kiếm
            loginPage.clearSearchBox();
            Thread.sleep(1000);

            // Nhập tên sản phẩm mới vào ô tìm kiếm
            loginPage.Sanpham(product);
            Thread.sleep(2000); 

            // Nhấn nút tìm kiếm
            loginPage.clickTimkiem();
            Thread.sleep(5000); 

            // In log để kiểm tra sản phẩm đã tìm kiếm
            System.out.println("Đã tìm kiếm sản phẩm: " + product);

            // Xóa lại nội dung trong ô tìm kiếm sau khi tìm kiếm xong
            loginPage.clearSearchBox();
            Thread.sleep(2000); 
        }
    }

    @AfterMethod
    public void tearDown() throws Exception {
        if (excelUtils != null) {
            excelUtils.close(); // Đóng workbook
        }
        super.tearDown(); // Dọn dẹp sau kiểm thử
    }
}
