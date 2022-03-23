package test.ProofIT;

public class PriceAndTax {
//	public float currentTax;
//	public float ticketPrice;
//	
//	//Constructor
//	public PriceAndTax(float currentTax, float ticketPrice) {
//			this.currentTax = currentTax;
//			this.ticketPrice = ticketPrice;
//		}
	
	//Method for calculating adult ticket price
	public static float adultTicketPrice (float currentTax, float ticketPrice, int adultCount) {
		return adultCount  *ticketPrice + currentTax * adultCount * ticketPrice;
	}
	
	//Method for calculating child ticket price
	public static float childTicketPrice(float currentTax, float ticketPrice, int childCount) {
		return childCount * ticketPrice * 0.5f + currentTax * childCount * ticketPrice * 0.5f;
	}
	
	//Method for calculating adult baggage price
	public static float adultBagCost(float currentTax, float ticketPrice, int adultCount, int bagCount) {
		return adultCount * bagCount * ticketPrice * 0.3f + adultCount * bagCount * ticketPrice * 0.3f * currentTax;
	}
	
	//Method for calculating child baggage price
	public static float childBagCost(float currentTax, float ticketPrice, int childCount, int bagCount) {
			return childCount * bagCount * ticketPrice * 0.3f + childCount * bagCount * ticketPrice * 0.3f * currentTax;
	}
	
}
