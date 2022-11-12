package Business;

import java.security.NoSuchProviderException;

public class Automobile extends Vehicle{
	private float engineVolume;
	
	// No-argument constructor
	public Automobile(){
		
	}
	// Full-argument constructor.
	public Automobile(String _vehicleId,String _monthOfSale,String _cityOfSale,int _productionYear,int _vat,float _engineVolume){
		super(_vehicleId,_monthOfSale,_cityOfSale,_productionYear,_vat);
		this.setEngineVolume(_engineVolume);
	}
	
	/**
     * Copy constructor for preventing privacy-leak
     * @param automobile object that we will make a new copy of its properties.
     */
	public Automobile(Automobile _anAutomobile) {
		super(_anAutomobile);
		this.setEngineVolume(_anAutomobile.getEngineVolume());
	}
	
	// Getters and setters
	public float getEngineVolume() { return engineVolume;}
	public void setEngineVolume(float engineVolume) { this.engineVolume = engineVolume;}
	
	/**
	 * This method is overriden method to check whether two automobiles are equal or not.
	 * @param _anAutomobile
	 * @return boolean
	 */
	public boolean equals(Automobile _anAutomobile) {
		if(_anAutomobile == null) {
			System.out.println("There is no such an Automobile.");
			return false;
		}else {
			return(super.equals(_anAutomobile) && this.engineVolume == _anAutomobile.getEngineVolume());
		}
	}
	/*	Automobile toString method has additional engine volume attribute.
	 * 
	 */
	public String toString() {
		return("Vehicle Id: "+  getVehicleId()+"\nMonth of sale: "+ getMonthOfSale()+"\nCity of Sale: "+ getCityOfSale() 
				+"\nProduction year: "+ getProductionYear()+"\nEngine volume: "+ getEngineVolume()+"\nValue added tax: "+ getVat());
	}

}
