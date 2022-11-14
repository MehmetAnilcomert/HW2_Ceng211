package business;

public class PickupTruck extends Vehicle {
	private String cabType;
	private String truckBedType;
	private double sct;
	private double paidPrice;
	public final int BASE_PRICE = 250000;
	
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
	public double getSCT() { return sct;}
	public double getPaidPrice() { return paidPrice;}
	
	public void setCabType(String cabType) { this.cabType = cabType;}
	public void setTruckBedType(String truckBedType) { this.truckBedType = truckBedType;}
	
	/* This method calculates the special consumer tax of pickup truck
	 * 
	 */
	public void calculateSCT() {
		sct = (calculateTruckBedType()*calculateProductionYearSCT(getProductionYear()) / calculateCabType());
	}
	
	/* This method calculates the total paid amount of pickup truck
	 * 
	 */
	public void calculatePaidPrice() {
		paidPrice = BASE_PRICE*(1+(getSCT()*0.6))+(1+(getVat()/100));
	}
	//Helper method to calculateSCT()
	private double calculateTruckBedType() {
		double truckBedType = 0;
		if(getTruckBedType().equals("regular"))
			truckBedType = 0.5;
		else if(getTruckBedType().equals("tanker"))
			truckBedType = 0.8;
		else {
			truckBedType = 1.0;
		}
		return truckBedType;
	}
	//Helper method to calculateSCT()
	private double calculateCabType() {
		double cabType = 0;
		if(getCabType().equals("regular"))
			cabType = 2.5;
		else if(getCabType().equals("extended"))
			cabType = 2.8;
		else {
			cabType = 3.0;
		}
		return cabType;
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
					getCabType().equals(_aPickup.getCabType())&&
					getTruckBedType().equals(_aPickup.getTruckBedType()));
		}
	}
	
	/*	Pickup truck toString method has additional cab type and truck bed type attributes. */
	public String toString(){
		String str = super.toString();
		str += String.format(" | Cab type: %-13s", getCabType());
		str += String.format(" | Truck bed type: %-7s", getTruckBedType());
		str += " | Paid price by buyer: " + Math.round(getPaidPrice());
		return(str);
	}
}
