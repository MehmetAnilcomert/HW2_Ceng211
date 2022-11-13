package Business;

public class Minivan extends Automobile{
	private int numberOfSeats;
	private double sct;
	private double paidPrice;
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
	public double getSCT() { return sct;}
	public double getPaidPrice() { return paidPrice;}
	public void setNumberOfSeats(int _numberOfSeats) { this.numberOfSeats = _numberOfSeats;}
	
	/* This method calculates the special consumer tax of minivan
	 * 
	 */
	public void calculateSCT() {
		sct = (0.6*calculateProductionYearSCT(getProductionYear()))/(getEngineVolume()+calculateNumberOfSeatSCT());
	}
	/* This method calculates the total paid amount of minivan
	 * 
	 */
	public void calculatePaidPrice() {
		paidPrice = (getBasePrice()*(1+getSCT()*0.8)+(1+(getVat()/100)));
	}
	/*
	 * This method is a helper method to calculate sct value due to number of seats. 
	 */
	private double calculateNumberOfSeatSCT() {
		double numberOfSeatSCT = 0;
		if(getNumberOfSeats() == 4) numberOfSeatSCT = 0.1;
		else if(getNumberOfSeats() == 5) numberOfSeatSCT = 0.4;
		else if(getNumberOfSeats() == 6) numberOfSeatSCT = 0.6;
		else { numberOfSeatSCT = 0.8;}
		return numberOfSeatSCT;
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
		return("Vehicle Id: "+  getVehicleId()+"\tMonth of sale: "+ getMonthOfSale()+"\tCity of Sale: "+ getCityOfSale() 
	  +"\tProduction year: "+ getProductionYear()+"\tNumber of seats: "+getNumberOfSeats()+"\tEngine volume: "+ getEngineVolume()+"\tValue added tax: "+ getVat()+
	  "\tPaid price by buyer: "+Math.round(getPaidPrice()));
	}
}
