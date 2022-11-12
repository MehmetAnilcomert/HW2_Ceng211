package Business;

public class PickupTruck extends Vehicle {
	private String cabType;
	private String truckBedType;
	
	//No argument constructor
	public PickupTruck() {
		
	}
	// Full argument constructor
	public PickupTruck(String _vehicleId,String _monthOfSale,String _cityOfSale,int _productionYear,int _vat,String _cabType, String _truckBedType) {
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
}
