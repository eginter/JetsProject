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
