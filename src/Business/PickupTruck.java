package Business;

public class PickupTruck extends Vehicle {
	private String cabType;
	private String truckBedType;
	
	//No argument constructor
	public PickupTruck() {
		
	}
	// Full argument constructor
	public PickupTruck(String _vehicleId,String _monthOfSale,String _cityOfSale,int _productionYear,String _cabType, String _truckBedType,int _vat) {
		super(_vehicleId,_monthOfSale,_cityOfSale,_productionYear,_vat);
		this.cabType = _cabType;
		this.truckBedType = _truckBedType;
	}
	
	/**
     * Copy constructor for preventing privacy-leak
     * @param pickUpTruck object that we will make a new copy of its properties.
     */
	public PickupTruck(PickupTruck _pickupTruck) {
		super(_pickupTruck.getVehicleId(), _pickupTruck.getMonthOfSale(), _pickupTruck.getCityOfSale(), _pickupTruck.getProductionYear(),_pickupTruck.getVat());
		this.cabType = _pickupTruck.getCabType();
		this.truckBedType = _pickupTruck.truckBedType;
	}
	
	// Getters and setters
	public String getCabType() { return cabType;}
	public String getTruckBedType() { return truckBedType;}
	
	public void setCabType(String cabType) { this.cabType = cabType;}
	public void setTruckBedType(String truckBedType) { this.truckBedType = truckBedType;}
	
	/* This method calculates the special consumer tax of pickup truck
	 * 
	 */
	public void calculateSCT() {
		if(getNumberOfSeats() == 4)
			sct = (0.6*getProductionYear())/(getEngineVolume()+0.1);
		else if(getNumberOfSeats() == 5)
			sct = (0.6*getProductionYear())/(getEngineVolume()+0.4);
		else if(getNumberOfSeats() == 6)
			sct = (0.6*getProductionYear())/(getEngineVolume()+0.6);
		else {
			sct = (0.6*getProductionYear())/(getEngineVolume()+0.8);
		}
	}
	/**
	 * This method is overriden method to check whether two pickups are equal or not.
	 * @param _apickUpTruck
	 * @return boolean
	 */
	public boolean equals(PickupTruck _aPickup) {
		if(_aPickup == null) {
			System.out.println("There is no such a Pickup truck.");
			return false;
		}else {
			return (super.equals(_aPickup)&&
					getCabType() ==_aPickup.getCabType()&&
					getTruckBedType() == _aPickup.getTruckBedType());
		}
	}
	
	/*	Pickup truck toString method has additional cab type and truck bed type attributes.
	 */
	public String toString(){
		return("Vehicle Id: "+ getVehicleId()+"\nMonth of sale: "+ getMonthOfSale()+
				"\nCity of Sale: "+ getCityOfSale()+ "\nProduction year: "+ getProductionYear()+
				"\nCab type: "+ getCabType() +"\nTruck bed type: "+getTruckBedType() +"\nValue added tax: "+ getVat());
	}

	//to test 
		public static void main(String[] args) {
			PickupTruck an = new PickupTruck("B154","June","İzmir",2020,"regular","tank",8);
			PickupTruck an2 = new PickupTruck("B154","January","İzmir",2020,"regula","tanker",8);
			System.out.println(an.equals(an2));
			System.out.println(an.toString());
		}

}
