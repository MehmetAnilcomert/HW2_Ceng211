package Business;

import java.util.ArrayList;
import java.util.Scanner;
import FileAcces.FileIO;

public class SalesRecord {
	ArrayList<String> soldVehiclesString = new ArrayList<String>();
	ArrayList<Vehicle> soldVehicles = new ArrayList<Vehicle>();
	ArrayList<Bicycle> soldBicycle = new ArrayList<Bicycle>();
	ArrayList<Hatchback> soldHatchback =new ArrayList<Hatchback>();
	ArrayList<Minivan> soldMinivan = new ArrayList<Minivan>();
	ArrayList<PickupTruck> soldPickupTruck = new ArrayList<PickupTruck>();
	ArrayList<Sedan> soldSedan = new ArrayList<Sedan>();
	
	public SalesRecord() {
		
	}
	public void fillWithStrings() {
		soldVehiclesString = FileIO.readCsv("src/file/HW2_SoldVehicles.csv");
	}
	/*
	 * This method fills vehicle objects to its appropriate array list.
	 */
	public void fillSoldVehicles(){
		String[] vehicleString = new String[7];
		for(int i = 0; i<soldVehiclesString.size();i++) {
			vehicleString = soldVehiclesString.get(i).split(",");
			Vehicle aVehicle = new Vehicle(vehicleString[0],vehicleString[1],vehicleString[2],Integer.parseInt(vehicleString[3]),Integer.parseInt(vehicleString[6]));
			soldVehicles.add(aVehicle);
		}
	}
	/*
	 * This method fills sedan objects to its appropriate array list.
	 */
	public void fillSoldSedan(String[] _aSedan){
		Sedan aSedan = new Sedan(_aSedan[0],_aSedan[1],_aSedan[2],Integer.parseInt(_aSedan[3]),
			_aSedan[4],Float.parseFloat(_aSedan[5]),Integer.parseInt(_aSedan[6]));
		aSedan.calculateSCT();
		aSedan.calculatePaidPrice();
		soldSedan.add(aSedan);
	}
	/*
	 * This method fills hatchback objects to its appropriate array list.
	 */
	public void fillSoldHatchback(String[] _aHatchback){
		Hatchback aHatchback = new Hatchback(_aHatchback[0],_aHatchback[1],_aHatchback[2],Integer.parseInt(_aHatchback[3]),
			_aHatchback[4],Float.parseFloat(_aHatchback[5]),Integer.parseInt(_aHatchback[6]));
		aHatchback.calculateSCT();
		aHatchback.calculatePaidPrice();
		soldHatchback.add(aHatchback);
	}
	/*
	 * This method fills minivan objects to its appropriate array list.
	 */
	public void fillSoldMinivan(String[] _aMinivan){
		Minivan aMinivan = new Minivan(_aMinivan[0],_aMinivan[1],_aMinivan[2],Integer.parseInt(_aMinivan[3]),
				Integer.parseInt(_aMinivan[4]),Float.parseFloat(_aMinivan[5]),Integer.parseInt(_aMinivan[6]));
		aMinivan.calculateSCT();
		aMinivan.calculatePaidPrice();
		soldMinivan.add(aMinivan);
	}
	
	/*
	 * This method fills pickup truck objects to its appropriate array list.
	 */
	public void fillSoldPickupTruck(String[] _aPickupTruck){
		PickupTruck aPickupTruck = new PickupTruck(_aPickupTruck[0],_aPickupTruck[1],_aPickupTruck[2],Integer.parseInt(_aPickupTruck[3]),
				_aPickupTruck[4],_aPickupTruck[5],Integer.parseInt(_aPickupTruck[6]));
		aPickupTruck.calculateSCT();
		aPickupTruck.calculatePaidPrice();
		soldPickupTruck.add(aPickupTruck);
	}
	/*
	 * This method fills bicycle objects to its appropriate array list.
	 */
	public void fillSoldBicycles(String[] _aBicycle){
		Bicycle aBicycle = new Bicycle(_aBicycle[0],_aBicycle[1],_aBicycle[2],Integer.parseInt(_aBicycle[3]),
			_aBicycle[4],_aBicycle[5],Integer.parseInt(_aBicycle[6]));
		aBicycle.calculateSCT();
		aBicycle.calculatePaidPrice();
				
		soldBicycle.add(aBicycle);
	}
	
	// Getters
	public ArrayList<Sedan> getSoldSedans(){ return soldSedan;}
	public ArrayList<Hatchback> getSoldHatchbacks(){ return soldHatchback;}
	public ArrayList<Minivan> getSoldMinivans(){ return soldMinivan;}
	public ArrayList<PickupTruck> getSoldPickupTrucks(){ return soldPickupTruck;}
	public ArrayList<Bicycle> getSoldBicycles(){ return soldBicycle;}
	
	public void matchVehicles(){
		for(int i=0; i<soldVehiclesString.size();i++) {
			String[] instanceVariables = soldVehiclesString.get(i).split(",");
			switch (soldVehiclesString.get(i).charAt(0)) {
				case 'B': {
					fillSoldBicycles(instanceVariables);
					break;
				}case 'H': {
					fillSoldHatchback(instanceVariables);
					break;
				}case 'M': {
					fillSoldMinivan(instanceVariables);
					break;
				}case 'P': {
					fillSoldPickupTruck(instanceVariables);
					break;
				}case 'S': {
					fillSoldSedan(instanceVariables);
					break;
				}
			}
		}
	}

	public  void runProgram(){
		fillWithStrings();
		fillSoldVehicles();
		matchVehicles();
		query();
	}
	
	public void query() { 
		Scanner scan = new Scanner(System.in);
		System.out.println("Please press, "+"\n0 to exit."+"\n1 to see all sold vehicles list."+
		"\n2 to see all sold sedan list."+"\n3 to see all sold hatchback list."+"\n4 to see all sold minivan list."+
				"\n5 to see all sold pickup truck list."+"\n6 to see all sold bicycle list.");
		System.out.print("Please enter your choice: ");
		int choosen = scan.nextInt(); // TODO : user can input a letter instead of number, fix later
		while(choosen!=0) {
			switch (choosen) {
				case 1: {
					System.out.println(soldVehicles);
					break;
				}
				case 2: {
					for (Sedan aSedan: soldSedan) {
						System.out.println(aSedan);		
					}
					break;
				}
				case 3: {
					for (Hatchback aHatchback: soldHatchback) {
						System.out.println(aHatchback); 		
					}
					break;
				}
				case 4: {
					for (Minivan aMinivan: soldMinivan) {
						System.out.println(aMinivan); 		
					}
					break;
				}
				case 5: {
					for (PickupTruck aPickupTruck: soldPickupTruck) {
						System.out.println(aPickupTruck); 		
					}
					break;
				}case 6: {
					for (Bicycle aBicycle: soldBicycle) {
						System.out.println(aBicycle); 		
					}
					break;
				}
				default:
					if(choosen>6) {
						System.out.println("invalid input: "+ choosen);
						System.exit(0);
					}
			}
			System.out.println("Please press, "+"\n0 to exit."+"\n1 to see all sold vehicles list."+
					"\n2 to see all sold sedan list."+"\n3 to see all sold hatchback list."+"\n4 to see all sold minivan list."+
							"\n5 to see all sold pickup truck list."+"\n6 to see all sold bicycle list.");
					System.out.print("Please enter your choice: ");
			choosen = scan.nextInt();
		}	
		scan.close();
	}	
}
