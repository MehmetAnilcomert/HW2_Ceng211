package Business;

public class Hatchback extends Automobile{
	private String cityMode;
	private double sct;
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
	public void setCityMode(String _cityMode) { this.cityMode = _cityMode;}
	
	/* This method calculates the special consumer tax of hatchback
	 * 
	 */
	public void calculateSCT() {
		if(getCityMode() == "yes")
			if(2001<=getProductionYear()&& getProductionYear()<=2008)
				sct = (getEngineVolume()*0.3*1.0)+0.15;
			else if(2012<=getProductionYear()&& getProductionYear()<=2017)
				sct = (getEngineVolume()*0.3*1.2)+0.15;
			else {
				sct = (getEngineVolume()*0.3*1.6)+0.15;
			}
		else {
			if(2001<=getProductionYear()&& getProductionYear()<=2008)
				sct = (getEngineVolume()*0.3*1.0)+0.1;
			else if(2012<=getProductionYear()&& getProductionYear()<=2017)
				sct = (getEngineVolume()*0.3*1.2)+0.1;
			else {
				sct = (getEngineVolume()*0.3*1.6)+0.1;
			}
		}
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
		return("Vehicle Id: "+  getVehicleId()+"\nMonth of sale: "+ getMonthOfSale()+"\nCity of Sale: "+ getCityOfSale() 
	  +"\nProduction year: "+ getProductionYear()+"\nCity mode: "+getCityMode()+"\nEngine volume: "+ getEngineVolume()+"\nValue added tax: "+ getVat());
	}
}
