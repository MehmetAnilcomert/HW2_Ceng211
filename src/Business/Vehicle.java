package Business;

enum vehicleTypes {Sedan,Hatchback,Minivan,Pickup,Bicycle};

public class Vehicle {
	private String vehicleId;
	private String monthOfSale;
	private String cityOfSale;
	private int productionYear;
	private int vat;
	private vehicleTypes vehicleType;
	
	
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
		
		// make sure we have vehicleID String that has at least 1 char
		if (_vehicleId==null || _vehicleId.length()==0) {
			System.out.println("ERROR: Vehicle ID field is empty.");
			System.exit(1);
		}
		
		// assign vehicle type depend on first letter of vehicle ID
		switch(vehicleId.charAt(0)) {
			case 'B': vehicleType = vehicleTypes.Bicycle; break;
			case 'H': vehicleType = vehicleTypes.Hatchback; break;
			case 'M': vehicleType = vehicleTypes.Minivan; break;
			case 'P': vehicleType = vehicleTypes.Pickup; break;
			case 'S': vehicleType = vehicleTypes.Sedan; break;
			default: System.out.println("Invalid field: vehicleID"); System.exit(1);
		}
	}
	 
	/**
     * Copy constructor for preventing privacy-leak
     * @param vehicle object that we will make a new copy of its properties.
     */
	public Vehicle(Vehicle _vehicle) {
		vehicleId = _vehicle.getVehicleId();
		monthOfSale = _vehicle.getMonthOfSale();
		cityOfSale = _vehicle.getCityOfSale();
		productionYear = _vehicle.getProductionYear();
		vat = _vehicle.getVat();
		vehicleType = _vehicle.getVehicleType();
	}
    
	
	//  Getters and setters for instance variables.
	public String getVehicleId() { return vehicleId;}
	public String getCityOfSale() { return cityOfSale;}
	public String getMonthOfSale() { return monthOfSale;}
	public int getProductionYear() { return productionYear;}
	public int getVat() { return vat;}
	public vehicleTypes getVehicleType() { return vehicleType;}
	
	public void setVehicleId(String vehicleId) { this.vehicleId = vehicleId;}
	public void setCityOfSale(String cityOfSale) { this.cityOfSale = cityOfSale;}
	public void setMonthOfSale(String monthOfSale) { this.monthOfSale = monthOfSale;}
	public void setProductionYear(int productionYear) { this.productionYear = productionYear;}
	public void setVat(int vat) { this.vat = vat;}
	
	/*
	 * This method is overriden and written accurately in each subclasses.
	 */
	public void calculateSCT() {
	}
	/*
	 * This method is overriden and written accurately in each subclasses.
	 */
	public void calculatePaidPrice() {
		
	}
	/*
	 * This method calculates and returns SCT value due to production year of vehicles.
	 * So it can be used to calculate SCT values of vehicles
	 */
	public double calculateProductionYearSCT(int _productionYear) {
		double productionYearSCT =0;
		if(2001<= _productionYear&& _productionYear<=2008) { productionYearSCT = 1;}
		else if(2012<= _productionYear&& _productionYear<=2017) { productionYearSCT = 1.2;}
		else { productionYearSCT = 1.6;}
		return productionYearSCT;
	}
	/*
	 * This method calculates and returns SCT value due to month of sale of vehicles.
	 * So it can be used to calculate SCT values of vehicles
	 */
	public double calculateMonthOfSaleSCT(String _monthOfSale) {
		double monthOfSaleSCT =0;
		if(_monthOfSale.equals("January")) { monthOfSaleSCT = 0.3;}
		else if(_monthOfSale.equals("May")) { monthOfSaleSCT = 0.4;}
		else if(_monthOfSale.equals("August")) { monthOfSaleSCT = 0.5;}
		else if(_monthOfSale.equals("October")) { monthOfSaleSCT = 0.6;}
		else { monthOfSaleSCT = 0.7;}
		return monthOfSaleSCT;
	}
	
	/**
	 * This method is overridden method to check whether two vehicles are equal or not.
	 * @param _aVehicle
	 * @return boolean
	 */
	public boolean equals(Vehicle _aVehicle) {
		if(_aVehicle == null) {
			System.out.println("There is no such a Vehicle.");
			return false;
		}else {
			return (getVehicleId().equals(_aVehicle.getVehicleId())  && 
					getMonthOfSale().equals(_aVehicle.getMonthOfSale()) && 
					getCityOfSale().equals(_aVehicle.getCityOfSale()) &&
					getProductionYear() == _aVehicle.getProductionYear());
		}
	}
	/**
	 * This method is overridden method to convert string format of vehicle's attributes.
	 * @return String
	 */
	public String toString() {
		String[] fields = new String[6];
		fields[0] = String.format("Vehicle: %-9s", vehicleType);
		fields[1] = "Vehicle Id: "+ vehicleId;
		fields[2] = String.format("Month of sale: %-8s", monthOfSale);
		fields[3] = String.format("City of Sale: %-8s", cityOfSale);
		fields[4] = "Production year: "+ productionYear;
		fields[5] = "Value added tax: "+ vat;
		return String.join(" | ", fields);
	}
}
