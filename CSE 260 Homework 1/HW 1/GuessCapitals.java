//Tian Brown, 111597217
import java.util.*;


import java.io.*;
public class GuessCapitals {
	
	public static void main (String [] args) throws IOException {
		
		Map<String, String> m = new HashMap<String, String>();
		//String csv = "Users/Tian/eclipse-workspace/CSE 260/HW 1/State_Capitals.csv";
		m.put("Alabama", "Montgomery"); m.put("Alaska", "Juneau"); m.put("Arizona", "Phoenix"); m.put("Arkansas", "Little Rock");
		m.put("California", "Sacramento"); m.put("Colorado", "Denver"); m.put("Connecticut", "Hartford");
		m.put("Delaware", "Dover"); m.put("Florida", "Tallahassee"); m.put("Georgia", "Atlanta");
		m.put("Hawaii", "Honolulu"); m.put("Idaho", "Boise"); m.put("Illinois", "Springfield");
		m.put("Indiana", "Indianapolis"); m.put("Iowa", "Des Moines"); m.put("Kansas", "Topeka");
		m.put("Kentucky", "Frankfort"); m.put("Louisiana", "Baton Rouge"); m.put("Maine", "Augusta");
		m.put("Maryland", "Annapolis"); m.put("Massachusetts", "Boston"); m.put("Michigan", "Lansing");
		m.put("Minnesota", "Saint Paul"); m.put("Mississippi", "Jackson"); m.put("Missouri", "Jefferson City");
		m.put("Montana", "Helena"); m.put("Nebraska", "Lincoln"); m.put("Nevada", "Carson City");
		m.put("New Hampshire", "Concord"); m.put("New Jersey", "Trenton"); m.put("New Mexico", "Santa Fe");
		m.put("New York", "Albany"); m.put("North Carolina", "Raleigh"); m.put("North Dakota", "Bismark");
		m.put("Ohio", "Columbus"); m.put("Oklahoma", "Oklahoma City"); m.put("Oregon", "Salem");
		m.put("Pennsylvania", "Harrisburg"); m.put("Rhode Island", "Providence"); m.put("South Carolina", "Columbia");
		m.put("South Dakota", "Pierre"); m.put("Tennessee", "Nashville"); m.put("Texas", "Austin");
		m.put("Utah", "Salt Lake City"); m.put("Vermont", "Montpelier"); m.put("Virginia", "Richmond");
		m.put("Washington", "Olympia"); m.put("West Virginia", "Charleston"); m.put("Wisconsin", "Madison");
		m.put("Wyoming", "Cheyenne");
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name of a state.");
		String state = sc.nextLine();
		
		sc.close();
		
		if (m.containsKey(state)) {
			Object value = m.get(state);
			System.out.print("The capital of " + state + " is: " + value);
		}
		else
			System.out.println("Invalid state name.");
		
		
		
		
		
		
	}
	
	
	
	

}
