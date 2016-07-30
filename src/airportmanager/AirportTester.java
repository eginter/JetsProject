package airportmanager;

public class AirportTester {
	public static void main(String[] args) {
		
		//Instantiate new Airport object
		Airport airport = new Airport();
		
		//Instantiate new Jet array 
		Jet[] jets = new Jet[5];
		
		//Instantiate 5 Jets to populate Jet array
		jets[0] = new Jet("E8-C JStars", 449, 2700, 244_400_000);
		jets[1] = new Jet("SR-71 Blackbird", 2200, 2900, 34_000_000);
		jets[2] = new Jet("U-2 Dragon Lady", 500, 6400, 320_000_000);
		jets[3] = new Jet("MC-12 Liberty", 333, 2075, 6_000_000);
		jets[4] = new Jet("AC-130H Spectre", 300, 2200, 132_400_000);
		
		//Store Jet array into Airport object
		airport.setJets(jets);
		
		//Instantiate new Prompter to begin display
		AirportPrompter prompter = new AirportPrompter(airport);
		prompter.menu();
	}

}
