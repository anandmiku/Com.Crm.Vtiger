package pactice;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelSheetNumericValuePractice {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		FileInputStream Fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(Fis);
		//first approach using single quote on the starting of number
		String value = wb.getSheet("Sheet2").getRow(0).getCell(0).getStringCellValue();
		System.out.println(value);
	}
}
