package Business;

import java.util.ArrayList;

// This class has a benefit of creating an ArrayList of different vehicles type. 
public class SalesRecord {
	private ArrayList<Bicycle> soldBicycle;
	private  ArrayList<Hatchback> soldHatchback;
	private  ArrayList<Minivan> soldMinivan;
	private  ArrayList<PickupTruck> soldPickupTruck;
	private  ArrayList<Sedan> soldSedan;
	
	/*
	 * This method fills sedan objects to its appropriate array list.
	 */
	public void fillSoldSedan(String[] _aSedan){
		Sedan aSedan = new Sedan(_aSedan[0],_aSedan[1],_aSedan[2],Integer.parseInt(_aSedan[3]),
			_aSedan[4],Float.parseFloat(_aSedan[5]),Integer.parseInt(_aSedan[6]));
		aSedan.calculateSCT();
		soldSedan.add(aSedan);
	}
	/*
	 * This method fills hatchback objects to its appropriate array list.
	 */
	public void fillSoldHatchback(String[] _aHatchback){
		Hatchback aHatchback = new Hatchback(_aHatchback[0],_aHatchback[1],_aHatchback[2],Integer.parseInt(_aHatchback[3]),
			_aHatchback[4],Float.parseFloat(_aHatchback[5]),Integer.parseInt(_aHatchback[6]));
		aHatchback.calculateSCT();
		soldHatchback.add(aHatchback);
	}
	/*
	 * This method fills minivan objects to its appropriate array list.
	 */
	public void fillSoldMinivan(String[] _aMinivan){
		Minivan aMinivan = new Minivan(_aMinivan[0],_aMinivan[1],_aMinivan[2],Integer.parseInt(_aMinivan[3]),
				Integer.parseInt(_aMinivan[4]),Float.parseFloat(_aMinivan[5]),Integer.parseInt(_aMinivan[6]));
		aMinivan.calculateSCT();
		soldMinivan.add(aMinivan);
	}
	
	/*
	 * This method fills pickup truck objects to its appropriate array list.
	 */
	public void fillSoldPickupTruck(String[] _aPickupTruck){
		PickupTruck aPickupTruck = new PickupTruck(_aPickupTruck[0],_aPickupTruck[1],_aPickupTruck[2],Integer.parseInt(_aPickupTruck[3]),
				_aPickupTruck[4],_aPickupTruck[5],Integer.parseInt(_aPickupTruck[6]));
		aPickupTruck.calculateSCT();
		soldPickupTruck.add(aPickupTruck);
	}
	/*
	 * This method fills bicycle objects to its appropriate array list.
	 */
	public void fillSoldBicycles(String[] _aBicycle){
		Bicycle aBicycle = new Bicycle(_aBicycle[0],_aBicycle[1],_aBicycle[2],Integer.parseInt(_aBicycle[3]),
			_aBicycle[4],_aBicycle[5],Integer.parseInt(_aBicycle[6]));
		aBicycle.calculateSCT();
		soldBicycle.add(aBicycle);
	}
	
	// Getters
	public ArrayList<Sedan> getSoldSedans(){ return soldSedan;}
	public ArrayList<Hatchback> getSoldHatchbacks(){ return soldHatchback;}
	public ArrayList<Minivan> getSoldMinivans(){ return soldMinivan;}
	public ArrayList<PickupTruck> getSoldPickupTrucks(){ return soldPickupTruck;}
	public ArrayList<Bicycle> getSoldBicycles(){ return soldBicycle;}
	
	public void matchVehicles(ArrayList<String> _anArrayList){
		for(int i=0; i<_anArrayList.size();i++) {
			String[] instanceVariables = _anArrayList.get(i).split(",");
			switch (_anArrayList.get(i).charAt(0)) {
				case 'B': {
					fillSoldBicycles(instanceVariables);
					break;
				}case 'H': {
					fillSoldHatchback(instanceVariables);
					break;
				}case 'M': {
					fillSoldMinivan(instanceVariables);
				}case 'P': {
					fillSoldPickupTruck(instanceVariables);
				}case 'S': {
					fillSoldSedan(instanceVariables);
				}
			}
		}
	}

	

}
