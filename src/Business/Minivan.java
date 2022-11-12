package Business;

public class Minivan extends Automobile{
	private int numberOfSeats;
	private double sct;
	// No-argument constructor
	public Minivan() {
		
	}
	// Full-argument constructor
	public Minivan(String _vehicleId,String _monthOfSale,String _cityOfSale,int _productionYear,int _numberOfSeats,float _engineVolume,int _vat) {
		super(_vehicleId,_monthOfSale,_cityOfSale,_productionYear,_engineVolume,_vat);
		this.numberOfSeats = _numberOfSeats;
	}
	/**
     * Copy constructor for preventing privacy-leak
     * @param minivan object that we will make a new copy of its properties.
     */
	public Minivan(Minivan _aMinivan) {
		super(_aMinivan);
		this.numberOfSeats = _aMinivan.getNumberOfSeats();
	}
	
	//Getter and a setter
	public int getNumberOfSeats() {	return numberOfSeats;}
	public void setNumberOfSeats(int _numberOfSeats) { this.numberOfSeats = _numberOfSeats;}
	
	/* This method calculates the special consumer tax of minivan
	 * 
	 */
	public void calculateSCT() {
		if(getNumberOfSeats() == 4) {
			if(2001<=getProductionYear()&& getProductionYear()<=2008)
				sct = (0.6*1.0)/(getEngineVolume()+0.1);
			else if (2012<=getProductionYear()&& getProductionYear()<=2017) {
				sct = (0.6*1.2)/(getEngineVolume()+0.1);
			}else {
				sct = (0.6*1.6)/(getEngineVolume()+0.1);
			}
		}else if(getNumberOfSeats() == 5) {
			if(2001<=getProductionYear()&& getProductionYear()<=2008)
				sct = (0.6*1.0)/(getEngineVolume()+0.4);
			else if (2012<=getProductionYear()&& getProductionYear()<=2017) {
				sct = (0.6*1.2)/(getEngineVolume()+0.4);
			}else {
				sct = (0.6*1.6)/(getEngineVolume()+0.4);
			}
		}else if(getNumberOfSeats() == 6) {
			if(2001<=getProductionYear()&& getProductionYear()<=2008)
				sct = (0.6*1.0)/(getEngineVolume()+0.6);
			else if (2012<=getProductionYear()&& getProductionYear()<=2017) {
				sct = (0.6*1.2)/(getEngineVolume()+0.6);
			}else {
				sct = (0.6*1.6)/(getEngineVolume()+0.6);
			}
		}else{
			if(2001<=getProductionYear()&& getProductionYear()<=2008)
				sct = (0.6*1.0)/(getEngineVolume()+0.8);
			else if (2012<=getProductionYear()&& getProductionYear()<=2017) {
				sct = (0.6*1.2)/(getEngineVolume()+0.8);
			}else {
				sct = (0.6*1.6)/(getEngineVolume()+0.8);
			}
		}
	}
	
	/**
	 * This method is overriden method to check whether two minivan type automobiles are equal or not.
	 * @param _aMinivan
	 * @return boolean
	 */
	public boolean equals(Minivan _aMinivan) {
		if(_aMinivan == null) {
			System.out.println("There is no such a Minivan type automobile.");
			return false;
		}else {
			return(super.equals(_aMinivan) && this.numberOfSeats == _aMinivan.getNumberOfSeats());
		}
	}
	
	/*	Minivan toString method has additional number of seats attribute.
	 * 
	 */
	public String toString() {
		return("Vehicle Id: "+  getVehicleId()+"\nMonth of sale: "+ getMonthOfSale()+"\nCity of Sale: "+ getCityOfSale() 
	  +"\nProduction year: "+ getProductionYear()+"\nNumber of seats: "+getNumberOfSeats()+"\nEngine volume: "+ getEngineVolume()+"\nValue added tax: "+ getVat());
	}
}
