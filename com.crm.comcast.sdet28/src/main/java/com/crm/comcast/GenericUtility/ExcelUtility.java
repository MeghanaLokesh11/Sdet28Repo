package com.crm.comcast.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author Meghana L
 *
 */

public class ExcelUtility {
	
	
	/**
	 * This method will return string value from excel sheet
	 * @param sheetname
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws Throwable
	 */
	
	public String getStringCellData(String sheetname, int rowNo , int cellNo) throws Throwable {
		
		FileInputStream file = new FileInputStream(IPathCanstant.EXCELFILEPATH);
	Workbook workbook = WorkbookFactory.create(file);
	Sheet sheet = workbook.getSheet(sheetname);
	Row row = sheet.getRow(rowNo);
	Cell cell = row.getCell(cellNo);
	return cell.toString();

		 }
	/**
	 * This method will return numeric cell data
	 * @param sheetname
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws Throwable
	 */
	
	public double getNumericCellData(String sheetname, int rowNo , int cellNo) throws Throwable {
		FileInputStream file = new FileInputStream(IPathCanstant.EXCELFILEPATH);
		Workbook workbook = WorkbookFactory.create(file);
		return workbook.getSheet(sheetname).getRow(rowNo).getCell(cellNo).getNumericCellValue();
		
		
	}
	/**
	 * This method will return multiple set of data from excel sheet
	 * @param sheetname
	 * @return
	 * @throws Throwable
	 */
	
	public Object[][] getMultipleData(String sheetname) throws Throwable {
		FileInputStream file = new FileInputStream(IPathCanstant.EXCELFILEPATH);
		Workbook workbook = WorkbookFactory.create(file);
	Sheet sheet = workbook.getSheet(sheetname);
	int rowNo = sheet.getLastRowNum();
	int cellNo = sheet.getRow(0).getLastCellNum();
	Object[][] data = new Object[rowNo][cellNo];
	for(int i=0;i<rowNo;i++) {
		for(int j=0;j<cellNo;j++) {
			data[i][j]=sheet.getRow(i).getCell(j).toString();
		}
	}
	return data;
	}
	
	/**
	 * This Method will write the data into excel sheet
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @param value
	 * @throws Throwable
	 * @throws IOException
	 */

	public void writeDataIntoExcel(String sheetName, int rowNo ,int cellNo ,String value) throws Throwable, IOException {
		FileInputStream readfile = new FileInputStream(IPathCanstant.EXCELFILEPATH);
	Workbook workbook = WorkbookFactory.create(readfile);
	workbook.createSheet(sheetName).createRow(rowNo).createCell(cellNo).setCellValue(value);
	
	FileOutputStream writefile = new FileOutputStream(IPathCanstant.EXCELFILEPATH);
	workbook.write(writefile);
	workbook.close();
	}
}
