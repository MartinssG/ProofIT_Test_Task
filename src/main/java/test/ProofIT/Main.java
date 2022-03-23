package test.ProofIT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


import org.json.JSONObject;


public class Main {

	private static HttpURLConnection connection;
		
	public static void main(String[] args) {
		BufferedReader reader;
		String line;
		StringBuffer responseContent = new StringBuffer();
		float ticketPrice;
		float currentTax;
		float totalPrice;
		int adultCount = 1;
		int childCount = 1;
		int adultBagCount = 2;
		int childBagCount = 1;
		
		
		//API Web-service initializing
		RestServiceBusCost.main(args);
		
		//API end-point definition and initializing
		try {
			URL url = new URL("http://localhost:8080/busrouteandtax");
			connection = (HttpURLConnection) url.openConnection();
			
			// Request setup
			connection.setRequestMethod("GET"); 
			connection.setConnectTimeout(5000); 
			connection.setReadTimeout(5000); 
			
			
			// Retrieving connection status integer
			int status = connection.getResponseCode(); 
			
			
			// TO DO if connection is not successful
			if (status > 200) { 
				//Reading the error message
				reader = new BufferedReader (new InputStreamReader(connection.getErrorStream())); 
				while((line = reader.readLine()) != null) { 
					responseContent.append(line);
				}
				reader.close();
				
			// TO DO if connection is successful		
			}else { 
				//Retrieving data from API JSON Object
				reader = new BufferedReader(new InputStreamReader(connection.getInputStream())); //dabonam message no API requesta
				while((line = reader.readLine()) != null) { //kamer ir atbilde tikmer lasa to visu
					responseContent.append(line);
				}
				reader.close();
			}
			
			//Creating JSON Object from retrieved API JSon String
			JSONObject jsonObj = new JSONObject(responseContent.toString());
			
			//GET ticket price from API string
			ticketPrice = jsonObj.getFloat("price"); 
			
			//GET current tax rate from API string
			currentTax = jsonObj.getFloat("taxRate");
			
			//Calculating and printing out results
			System.out.println("Adult ticket costs - > "+PriceAndTax.adultTicketPrice(currentTax,ticketPrice,adultCount));
			System.out.println("Adult baggage costs - > "+PriceAndTax.adultBagCost(currentTax,ticketPrice,adultCount,adultBagCount));
			System.out.println("Child ticket costs - > "+PriceAndTax.childTicketPrice(currentTax,ticketPrice,childCount));
			System.out.println("Child baggage costs - > "+PriceAndTax.childBagCost(currentTax,ticketPrice,childCount,childBagCount));
			
			totalPrice = PriceAndTax.adultTicketPrice(currentTax,ticketPrice,adultCount)+ 
					PriceAndTax.adultBagCost(currentTax,ticketPrice,adultCount,adultBagCount)+PriceAndTax.childTicketPrice(currentTax,ticketPrice,childCount)
					+PriceAndTax.childBagCost(currentTax,ticketPrice,childCount,childBagCount);
			System.out.printf("Total price = %.2f", totalPrice);
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connection.disconnect(); //atvienojamies no API
		}
	}
	
}

