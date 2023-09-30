package pactice;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelSheetNumericValue2Practice {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		FileInputStream Fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(Fis);
		//second  approach using to string method to fetch numeric value from excel
		String value = wb.getSheet("Sheet2").getRow(0).getCell(0).toString();
		System.out.println(value);
	}
}
