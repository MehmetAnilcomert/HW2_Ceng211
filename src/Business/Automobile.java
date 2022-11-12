package Business;

public class Automobile extends Vehicle{
	private float engineVolume;
	
	// No-argument constructor
	public Automobile(){
		super();
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
	


}
