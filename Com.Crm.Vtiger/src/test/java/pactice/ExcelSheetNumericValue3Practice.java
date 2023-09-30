package pactice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelSheetNumericValue3Practice {

	public static void main(String[] args) throws Throwable {
		FileInputStream Fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(Fis);
		//3rd approach is by using DataFormatter
		DataFormatter df=new DataFormatter();
		String value=df.formatCellValue(wb.getSheet("Sheet2").getRow(0).getCell(0));
		System.out.println(value);
	}
}