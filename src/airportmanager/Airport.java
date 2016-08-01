package airportmanager;

public class Airport {
	// Fields
	private Jet[] jets;

	// Constructor
	public Airport() {
		this(new Jet[0]);
	}

	public Airport(Jet[] jets) {
		this.jets = jets;
	}

	// Methods
	public void startAirportTracker(Airport airport) {
		
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
	
	
	public Jet getLongestRange() {
		int longestRange = 0;
		Jet longRangeJet = null;

		for (Jet jet : getJets()) {
			if (jet.getRange() > longestRange) {
				longestRange = jet.getRange();
				longRangeJet = jet;
			}
		}

		return longRangeJet;
	}

	public Jet getFastestJet() {
		int highestSpeed = 0;
		Jet fastestJet = null;

		for (Jet jet : getJets()) {
			if (jet.getSpeed() > highestSpeed) {
				highestSpeed = jet.getSpeed();
				fastestJet = jet;
			}
		}

		return fastestJet;
	}

	public void addJet(Jet j) {
		Jet[] newArray = new Jet[jets.length + 1];
		for (int i = 0; i < jets.length; i++) {
			newArray[i] = jets[i];
		}
		newArray[newArray.length - 1] = j;
		setJets(newArray);
	}

	// Getters & Setters
	public Jet[] getJets() {
		return jets;
	}

	public void setJets(Jet[] jets) {
		this.jets = jets;
	}

}
