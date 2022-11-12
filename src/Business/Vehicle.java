package Business;

public class Vehicle {
	private String vehicleId;
	private String monthOfSale;
	private String cityOfSale;
	private int productionYear;
	private int vat;
	
	// No-argument constructor
	public Vehicle() {
	}
	
	// Full-argument constructor.
	public Vehicle(String _vehicleId,String _monthOfSale,String _cityOfSale,int _productionYear,int _vat) {
		this.vehicleId = _vehicleId;
		this.monthOfSale = _monthOfSale;
		this.cityOfSale = _cityOfSale;
		this.productionYear = _productionYear;
		this.vat = _vat;
	}
	 
	/**
     * Copy constructor for preventing privacy-leak
     * @param vehicle object that we will make a new copy of its properties.
     */
	public Vehicle(Vehicle _aVehicle) {
		this.vehicleId = _aVehicle.getVehicleId();
		this.monthOfSale = _aVehicle.getMonthOfSale();
		this.cityOfSale = _aVehicle.getCityOfSale();
		this.productionYear = _aVehicle.getProductionYear();
		this.vat = _aVehicle.getVat();
	}
    
	
	//  Getters and setters for instance variables.
	public String getVehicleId() { return vehicleId;}
	public String getCityOfSale() { return cityOfSale;}
	public String getMonthOfSale() { return monthOfSale;}
	public int getProductionYear() { return productionYear;}
	public int getVat() { return vat;}
	
	public void setVehicleId(String vehicleId) { this.vehicleId = vehicleId;}
	public void setCityOfSale(String cityOfSale) { this.cityOfSale = cityOfSale;}
	public void setMonthOfSale(String monthOfSale) { this.monthOfSale = monthOfSale;}
	public void setProductionYear(int productionYear) { this.productionYear = productionYear;}
	public void setVat(int vat) { this.vat = vat;}
	
	
	
	
}
