package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {
    private Workbook workbook;
    private Sheet sheet;

    // Constructor để khởi tạo với đường dẫn file và tên sheet
    public ExcelUtils(String filePath, String sheetName) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File(filePath));
        workbook = new XSSFWorkbook(fileInputStream);
        sheet = workbook.getSheet(sheetName);
    }

    // Phương thức đọc dữ liệu từ một ô cụ thể
    public String getCellData(int row, int col) {
        Row sheetRow = sheet.getRow(row);
        if (sheetRow != null) {
            Cell cell = sheetRow.getCell(col);
            if (cell != null) {
                if (cell.getCellType() == CellType.STRING) {
                    return cell.getStringCellValue();
                } else if (cell.getCellType() == CellType.NUMERIC) {
                    return String.valueOf((int) cell.getNumericCellValue());
                }
            }
        }
        return "";
    }

    // Phương thức đọc tất cả dữ liệu từ cột đầu tiên
    public List<String> readExcelData() {
        List<String> data = new ArrayList<>();
        for (Row row : sheet) {
            Cell cell = row.getCell(0); // Đọc dữ liệu từ cột đầu tiên
            if (cell != null) {
                if (cell.getCellType() == CellType.STRING) {
                    data.add(cell.getStringCellValue());
                } else if (cell.getCellType() == CellType.NUMERIC) {
                    data.add(String.valueOf((int) cell.getNumericCellValue()));
                }
            }
        }
        return data;
    }

    // Đếm số lượng dòng
    public int getRowCount() {
        return sheet.getLastRowNum() + 1;
    }

    // Phương thức đóng workbook
    public void close() throws IOException {
        workbook.close();
    }

	public int getTotalRows() {
		return sheet.getPhysicalNumberOfRows();
	}
}
