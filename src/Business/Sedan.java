package Business;

public class Sedan extends Automobile{
	private String roofType;
	private double sct;
	private double paidPrice;
	// No-argument constructor
	public Sedan() {
		
	}
	// Full-argument constructor
	public Sedan(String _vehicleId,String _monthOfSale,String _cityOfSale,int _productionYear,String _roofType,float _engineVolume,int _vat) {
		super(_vehicleId,_monthOfSale,_cityOfSale,_productionYear,_engineVolume,_vat);
		this.roofType = _roofType;
	}
	
	/**
     * Copy constructor for preventing privacy-leak
     * @param sedan object that we will make a new copy of its properties.
     */
	public Sedan(Sedan _aSedan) {
		super(_aSedan);
		this.roofType = _aSedan.getRoofType();
	}
	
	// Getter and a setter
	public String getRoofType() { return roofType;}
	public double getSCT() { return sct;}
	public double getPaidPrice() { return paidPrice;}
	public void setRoofType(String _roofType) { this.roofType = _roofType;}
	
	/* This method calculates the special consumer tax of sedan
	 * 
	 */
	public void calculateSCT() {
		sct = (getEngineVolume()*0.2*calculateRoofTypeSCT())/calculateProductionYearSCT(getProductionYear());
	}
	/* This method calculates the total paid amount of sedan
	 * 
	 */
	public void calculatePaidPrice() {
		paidPrice = getBasePrice()*(1+getSCT()*0.8)+(1+(getVat()/100));
	}
	/*
	 * This method is a helper method to calculate sct value due to roof type. 
	 */
	private double calculateRoofTypeSCT(){
		double roofTypeSCT = 0;
		if(getRoofType().equals("regular")) roofTypeSCT = 0.5;
		else if(getRoofType().equals("moonroof")) roofTypeSCT = 0.6;
		else { roofTypeSCT = 0.8;}
		return roofTypeSCT;
	}
	/**
	 * This method is overridden method to check whether two sedan type automobiles are equal or not.
	 * @param _aSedan
	 * @return boolean
	 */
	public boolean equals(Sedan _aSedan) {
		if(_aSedan == null) {
			System.out.println("There is no such a Sedan type automobile.");
			return false;
		}else {
			return(super.equals(_aSedan) && this.roofType.equals( _aSedan.getRoofType()));
		}
	}
	
	/**	Sedan toString method has additional roof type attribute. */
	public String toString() {
		String str = super.toString();
		str += "\tRoof Type: " + getRoofType();
		str += "\tPaid price by buyer: " + Math.round(getPaidPrice());
		return(str);
	}
}
