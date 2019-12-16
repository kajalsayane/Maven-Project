package dataReading;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReading {
	
	public ArrayList<String> getDataFromExcel(String sheetName, String header, String empDetail) throws IOException {

		
		File f = new File("C:\\Users\\KAJAL SAYANE\\Desktop\\Selenium WebDriver\\Data Repo\\Employee Details.xlsx"); //points to a file in the local computer
		FileInputStream fis = new FileInputStream(f);//reads the file in java, opens the channel to read the data
		//fis object has the permission to read the file
		
		ArrayList<String> a = new ArrayList<String>(); //creating array list to store all data
		//1. Access workbook
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(fis);//now workbook object can access the sheet
		
		//2. Access to the required sheet 
		int sheetsCount = workbook.getNumberOfSheets();
		
		for(int i=0;i<sheetsCount;i++) {
			
			if(workbook.getSheetName(i).equalsIgnoreCase(sheetName)) {
				
				XSSFSheet sheet = workbook.getSheetAt(i);//return type is XSSFSheet
				
				//3. identify the entire rows in a sheet for scanning the column we need, identify 1st row to get name column details.

				Iterator<Row> allRowsOfSheet= sheet.iterator();//sheet is the collection of rows, here with the help of iterator we can access and traverse in the rows.
				Row firstRow = allRowsOfSheet.next(); // row is the collection of cells, now we are moving in the cells of first row
				
				//4. Identify all the cells in a specific row
				Iterator<Cell> cellsOfFirstRow = firstRow.cellIterator();//we are now accessing cells in a row with the help of cellIterator
				
				//5. Identify the particular cell
				int k = 0;
				int column = 0;
				while(cellsOfFirstRow.hasNext()){
					
					Cell eachCellofFirstRow =  cellsOfFirstRow.next();
					
					 if(eachCellofFirstRow.getStringCellValue().equalsIgnoreCase(header)) {
						 
						 column = k;
						 System.out.println(eachCellofFirstRow.getStringCellValue());
						 
					 }
					 k++;
					 
				 }
				while(allRowsOfSheet.hasNext()) {
					Row r = allRowsOfSheet.next();
					
					if(r.getCell(column).getStringCellValue().equalsIgnoreCase(empDetail)) {
						
						Iterator<Cell> cells = r.cellIterator();
						while(cells.hasNext()) {
							Cell eachValue = cells.next();
							if(eachValue.getCellType()==CellType.STRING) { //to check the data type of any cell value
								a.add(eachValue.getStringCellValue());
							
							}else {
								a.add(NumberToTextConverter.toText(eachValue.getNumericCellValue()));

							}
													
							
						}
						
					}
					
				}
			}
			
		}
		return a;
				
	}

}
