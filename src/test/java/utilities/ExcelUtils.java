package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * This class reads data from excel
 */

public class ExcelUtils {

	public static FileInputStream fileInput;
	public static FileOutputStream fileOutputo;
	public static XSSFWorkbook workbook;
	public static XSSFSheet worksheet;
	public static XSSFRow row;
	public static XSSFCell cell;

	/**
	 * This method returns row count of excel
	 */
	public static int getRowCount(String xlfile, String xlsheet) throws IOException {
		fileInput = new FileInputStream(xlfile);
		workbook = new XSSFWorkbook(fileInput);
		worksheet = workbook.getSheet(xlsheet);
		int rowcount = worksheet.getLastRowNum();
		workbook.close();
		fileInput.close();
		return rowcount;
	}

	/**
	 * This method returns cell count of a row in excel
	 */
	public static int getCellCount(String xlfile, String xlsheet, int rownum) throws IOException {
		fileInput = new FileInputStream(xlfile);
		workbook = new XSSFWorkbook(fileInput);
		worksheet = workbook.getSheet(xlsheet);
		row = worksheet.getRow(rownum);
		int cellcount = row.getLastCellNum();
		workbook.close();
		fileInput.close();
		return cellcount;
	}

	/**
	 * This method returns cell data of excel
	 */
	public static String getCellData(String xlfile, String xlsheet, int rownum, int colnum) throws IOException {
		fileInput = new FileInputStream(xlfile);
		workbook = new XSSFWorkbook(fileInput);
		worksheet = workbook.getSheet(xlsheet);
		row = worksheet.getRow(rownum);
		cell = row.getCell(colnum);
		String data;
		try {
			DataFormatter formatter = new DataFormatter();
			String cellData = formatter.formatCellValue(cell);
			return cellData;
		} catch (Exception e) {
			data = "";
		}
		workbook.close();
		fileInput.close();
		return data;
	}
	
	/**
	 * This method sets cell data of excel
	 */

	public static void setCellData(String xlfile, String xlsheet, int rownum, int colnum, String data)
			throws IOException {
		fileInput = new FileInputStream(xlfile);
		workbook = new XSSFWorkbook(fileInput);
		worksheet = workbook.getSheet(xlsheet);
		row = worksheet.getRow(rownum);
		cell = row.createCell(colnum);
		cell.setCellValue(data);
		fileOutputo = new FileOutputStream(xlfile);
		workbook.write(fileOutputo);
		workbook.close();
		fileInput.close();
		fileOutputo.close();
	}

}