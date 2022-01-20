package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class CheckFirstCellValueAndGetSecondCellValueTest {

	public static void main(String[] args) throws Throwable, IOException {
	
		// java object representation for physical excel sheet
		FileInputStream fis = new FileInputStream("./src/test/resources/VtigersTestData.xlsx");
		//create a work book for physical file object representation
		Workbook workbook = WorkbookFactory.create(fis);
		 //get the control of sheet
		Sheet sheet = workbook.getSheet("Sheet1");
		String CellData ="CreateOrganization";
	
		int rowNo = sheet.getLastRowNum();
		for(int i=1; i<=rowNo; i++)
		{
		Row row = sheet.getRow(i);
		String firstCellData=row.getCell(0).getStringCellValue();
		if(firstCellData.equals(CellData)) {
			String secondCellValue=row.getCell(1).getStringCellValue();
			System.out.println(secondCellValue);
		}
		workbook.close();
		}
	

	}

}
