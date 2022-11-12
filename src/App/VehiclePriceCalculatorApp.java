package App;

import java.io.FileNotFoundException;

import FileAcces.FileIO;

public class VehiclePriceCalculatorApp {
	public static void main(String[] args) {
		System.out.println(FileIO.readCsv("src/file/HW2_SoldVehicles.csv")); 
	}
}
