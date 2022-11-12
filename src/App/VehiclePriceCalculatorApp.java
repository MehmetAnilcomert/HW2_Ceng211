package App;

import java.io.FileNotFoundException;

import Business.SalesRecord;
import FileAcces.FileIO;

public class VehiclePriceCalculatorApp {
	public static void main(String[] args) {
		SalesRecord records = new SalesRecord();
		records.runProgram();
	}
}
