package Business;

public class Bicycle extends Vehicle{
	private String chainType;
	private String seatPost;
	private double sct;
	
	
	// No-argument constructor
	public Bicycle(){
		
	}
	// Full-argument constructor
	public Bicycle(String _vehicleId,String _monthOfSale,String _cityOfSale,int _productionYear,String _chainType,String _seatPost,int _vat){
		super(_vehicleId,_monthOfSale,_cityOfSale,_productionYear,_vat);
		this.chainType = _chainType;
		this.seatPost = _seatPost;
	}
	/**
     * Copy constructor for preventing privacy-leak
     * @param bicycle object that we will make a new copy of its properties.
     */
	public Bicycle(Bicycle _aBicycle){
		super(_aBicycle);
		this.chainType = _aBicycle.getChainType();
		this.seatPost = _aBicycle.getSeatPost();
	}
	
	// Getters and Setters
	public String getSeatPost() { return seatPost;}
	public String getChainType() { return chainType;}
	
	public void setSeatPost(String seatPost) { this.seatPost = seatPost;}
	public void setChainType(String chainType) { this.chainType = chainType;}
	
	public void calculateSCT() {
		sct = (calculateChainTypeSCT()*calculateSeatPostSCT()*0.1)+calculateMonthOfSaleSCT(getMonthOfSale());
	}
	/*
	 * This private method is a helper method to calculate sct value due to chain type.
	 */
	private double calculateChainTypeSCT() {
		double chainTypeSCT = 0;
		if(getChainType() == "derailleur")	chainTypeSCT = 1.1;
		else if(getChainType() == "onechain") chainTypeSCT = 1.2;
		else { chainTypeSCT = 1.3;}
		return chainTypeSCT;
	}
	/*
	 * This private method is a helper method to calculate sct value due to chain type.
	 */
	private double calculateSeatPostSCT() {
		double seatPostSCT = 0;
		if(getSeatPost() == "carbonfiber") seatPostSCT = 0.8;
		else if(getSeatPost() == "steel") seatPostSCT = 0.7;
		else if(getSeatPost() == "aluminum") seatPostSCT = 0.9;
		else{ seatPostSCT = 0.6;}
		return seatPostSCT;
		
	}
	/**
	 * This method is overriden method to check whether two bicycles are equal or not.
	 * @param _aBicycle
	 * @return boolean
	 */
	public boolean equals(Bicycle _aBicycle) {
		if(_aBicycle == null) {
			System.out.println("There is no such a Bicycle.");
			return false;
		}else {
			return (super.equals(_aBicycle) && getChainType() == _aBicycle.getChainType()
					&& getSeatPost() == _aBicycle.getSeatPost());
		}
	}
	/*	Bicycle toString method has additional chain type and seat post attributes.
	 */
	public String toString() {
		return ("Vehicle Id: "+ getVehicleId()+"\nMonth of sale: "+ getMonthOfSale()+"\nCity of Sale: "+ getCityOfSale()+ 
				"\nProduction year: "+ getProductionYear()+"\nChain type: "+getChainType()+"\nSeat post: "+getSeatPost()+"\nValue added tax: "+ getVat());
	}
	
	
	
}