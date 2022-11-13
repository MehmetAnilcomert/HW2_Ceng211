package Business;

public class Automobile extends Vehicle{
	private float engineVolume;
	public final int BASE_PRICE = 200000;
	// No-argument constructor
	public Automobile(){
		
	}
	// Full-argument constructor.
	public Automobile(String _vehicleId,String _monthOfSale,String _cityOfSale,int _productionYear,float _engineVolume,int _vat){
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
	public double getBasePrice() { return BASE_PRICE;}
	public void setEngineVolume(float engineVolume) { this.engineVolume = engineVolume;}
	
	
	public void calculateSCT() {
		
	}
	public void calculatePaidPrice() {
		
	}
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
		
		return(super.toString()+"\tEngine volume: "+ getEngineVolume()+"\tValue added tax: "+ getVat());
	}

}
