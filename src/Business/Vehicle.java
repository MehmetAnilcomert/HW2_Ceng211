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
	
	
	public void calculateSCT() {
		
	}
	public void calculatePaidPrice() {
		
	}
	/*
	 * This method calculates and returns sct value due to production year of vehicles.
	 * So it can be used to calculate sct values of vehicles
	 */
	public double calculateProductionYearSCT(int _productionYear) {
		double productionYearSCT =0;
		if(2001<= _productionYear&& _productionYear<=2008) { productionYearSCT = 1;}
		else if(2012<= _productionYear&& _productionYear<=2017) { productionYearSCT = 1.2;}
		else { productionYearSCT = 1.6;}
		return productionYearSCT;
	}
	/*
	 * This method calculates and returns sct value due to month of sale of vehicles.
	 * So it can be used to calculate sct values of vehicles
	 */
	public double calculateMonthOfSaleSCT(String _monthOfSale) {
		double monthOfSaleSCT =0;
		if(_monthOfSale == "January") { monthOfSaleSCT = 0.3;}
		else if(_monthOfSale == "May") { monthOfSaleSCT = 0.4;}
		else if(_monthOfSale == "August") { monthOfSaleSCT = 0.5;}
		else if(_monthOfSale == "October") { monthOfSaleSCT = 0.6;}
		else { monthOfSaleSCT = 0.7;}
		return monthOfSaleSCT;
	}
	
	/**
	 * This method is overriden method to check whether two vehicles are equal or not.
	 * @param _aVehicle
	 * @return boolean
	 */
	public boolean equals(Vehicle _aVehicle) {
		if(_aVehicle == null) {
			System.out.println("There is no such a Vehicle.");
			return false;
		}else {
			return (getVehicleId() == _aVehicle.getVehicleId() && 
					getMonthOfSale() == _aVehicle.getMonthOfSale()&& 
					getCityOfSale() == _aVehicle.getCityOfSale()&&
					getProductionYear() == _aVehicle.getProductionYear());
		}
	}
	
	public String toString() {
		return ("Vehicle Id: "+ vehicleId+"\nMonth of sale: "+ monthOfSale+"\nCity of Sale: "+ cityOfSale+
				"\nProduction year: "+ productionYear+"\nValue added tax: "+ vat);
	}
	
	
	//to test 
	public static void main(String[] args) {
		Vehicle an = new Vehicle("B154","January","İzmir",2020,8);
		Vehicle an2 = new Vehicle("B154","January","İzmir",2021,8);
		System.out.println(an.equals(an2));
	}
	
}
