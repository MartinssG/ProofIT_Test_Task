package test.ProofIT;


//class for API (Bus route price and current Tax rate combined)
public class BusRouteAndTax {
	
	private final long id;
	private final String route;
	private final float price;
	private final float taxRate;
	
	public BusRouteAndTax(long id, String route, float price, float taxRate) { //constructor
		this.id = id;
		this.route = route;
		this.price = price;
		this.taxRate = taxRate;
	}
	
	public long getId() { //GET
		return id;
	}
	
	public String getRoute() { //GET
		return route;
	}
	
	public float getPrice() { //GET
		return price;
	}
	
	public float getTaxRate() { //GET
		return taxRate;
	}
}
