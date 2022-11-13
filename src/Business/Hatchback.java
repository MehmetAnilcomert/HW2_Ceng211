package Business;

public class Hatchback extends Automobile{
	private String cityMode;
	private double sct;
	private double paidPrice;
	// No-argument constructor
	public Hatchback(){
		
	}
	// Full-argument constructor
	public Hatchback(String _vehicleId,String _monthOfSale,String _cityOfSale,int _productionYear,String _cityMode,float _engineVolume,int _vat){
		super(_vehicleId,_monthOfSale,_cityOfSale,_productionYear,_engineVolume,_vat);
		this.cityMode = _cityMode;
	}
	/**
     * Copy constructor for preventing privacy-leak
     * @param hatchback object that we will make a new copy of its properties.
     */
	public Hatchback(Hatchback _aHatchback){
		super(_aHatchback);
		this.cityMode = _aHatchback.getCityMode();
	}
	// Getter and a setter
	public String getCityMode() { return cityMode;}
	public double getSCT() { return sct;}
	public double getPaidPrice() { return paidPrice;}
	public void setCityMode(String _cityMode) { this.cityMode = _cityMode;}
	
	/* This method calculates the special consumer tax of hatchback
	 * 
	 */
	public void calculateSCT() {
		sct = (getEngineVolume()*0.3*calculateProductionYearSCT(getProductionYear()))+calculateCityModeSCT();
	}
	/* This method calculates the total paid amount of hatchback
	 * 
	 */
	public void calculatePaidPrice() {
		paidPrice = getBasePrice()*(1+getSCT()*0.8)+(1+(getVat()/100));
	}
	/*
	 * This method is a helper method to calculate sct value due to city mode. 
	 */
	private double calculateCityModeSCT() {
		double cityModeSCT = 0;
		if(getCityMode().equals("yes")) cityModeSCT = 0.15;
		else { cityModeSCT = 0.1;}
		return cityModeSCT;
	}
	/**
	 * This method is overriden method to check whether two hatchback type automobiles are equal or not.
	 * @param _aHatchback
	 * @return boolean
	 */
	public boolean equals(Hatchback _aHatchback) {
		if(_aHatchback == null) {
			System.out.println("There is no such a Hatchback type automobile.");
			return false;
		}else {
			return(super.equals(_aHatchback) && this.cityMode == _aHatchback.getCityMode());
		}
	}
	
	/*	Hatchback toString method has additional city mode attribute.
	 * 
	 */
	public String toString() {
		return("Vehicle Id: "+  getVehicleId()+"\tMonth of sale: "+ getMonthOfSale()+"\tCity of Sale: "+ getCityOfSale() 
	  +"\tProduction year: "+ getProductionYear()+"\tCity mode: "+getCityMode()+"\tEngine volume: "+ getEngineVolume()+"\tValue added tax: "+ getVat()+
	  "\tPaid price by buyer: "+Math.round(getPaidPrice()));
	}
}
