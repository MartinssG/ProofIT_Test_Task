package test.ProofIT;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BusRouteController {

	private static final String busRoute = "Riga-Lithuania";
	private final AtomicLong counter = new AtomicLong(); 
	private final float ticketPrice = 10;
	private final float curTaxRate = 0.21f;
	
	
	//Information for API JSON
	@GetMapping("/busrouteandtax")
	public BusRouteAndTax busrouteandtax () {
		return new BusRouteAndTax (counter.getAndIncrement(), busRoute, ticketPrice, curTaxRate);
	}
}

