package com.Crm.Vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	
	public String getDataFromExcel(String Sheetname, int rowno, int cellno) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis =new FileInputStream(IPathConstant.excelfilepath);
		Workbook wb=WorkbookFactory.create(fis);
		
		String value=wb.getSheet(Sheetname).getRow(rowno).getCell(cellno).getStringCellValue();
		return value;
	}
	
	public void updateExcelData(String Sheetname, int rowno, int cellno, String data) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis =new FileInputStream(IPathConstant.excelfilepath);
		Workbook wb=WorkbookFactory.create(fis);
		
		wb.getSheet(Sheetname).createRow(rowno).createCell(cellno).setCellValue(data);
		FileOutputStream fos=new FileOutputStream(IPathConstant.excelfilepath);
		wb.write(fos);
		
	}

} 
