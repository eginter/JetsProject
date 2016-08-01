package airportmanager;

public class Pilot {
	// Fields
	private String rank;
	private String firstName;
	private String lastName;
	private boolean isAssignedToJet;
	
	// Constructors
	public Pilot(String rank, String firstName, String lastName) {
		super();
		this.rank = rank;
		this.firstName = firstName;
		this.lastName = lastName;
		
	}

	// Methods

	
	// Setters & Getters
	public String getRank() {
		return rank;
	}


	public void setRank(String rank) {
		this.rank = rank;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public boolean isAssignedToJet() {
		return isAssignedToJet;
	}


	public void setAssignedToJet(boolean isAssignedToJet) {
		this.isAssignedToJet = isAssignedToJet;
	}


	@Override
	public String toString() {
		return "Pilot [rank=" + rank + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	
}
