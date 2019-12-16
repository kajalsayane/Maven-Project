package dataReading;

import java.io.IOException;
import java.util.ArrayList;

public class PrintData {
	public static void main(String[] args) throws IOException {
		
		ExcelReading obj = new ExcelReading();
		ArrayList<String> print = obj.getDataFromExcel("general", "name", "Amruta Deshpande");
		System.out.println(print.get(0));
		System.out.println(print.get(1));
		System.out.println(print.get(2));
		System.out.println(print.get(3));

	}

}
