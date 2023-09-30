package com.Crm.VTiger.practice;

import java.io.FileWriter;
import java.io.IOException;

import com.opencsv.CSVWriter;

public class WriteDataToCSVFile {

	public static void main(String[] args) throws IOException {
		FileWriter fw =new  FileWriter("./src/test/resources/Practice.csv");
		CSVWriter csw = new CSVWriter(fw);
		
		String cell[]= new String[3];
		cell[0]="Mounika";
		cell[1]="Lisa";
		cell[2]="Sindhu";
		
		csw.writeNext(cell);
		csw.flush();

	}

}