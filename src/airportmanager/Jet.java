package airportmanager;

public class Jet {
	// Fields
	private String model;
	private int speed;
	private int range;
	private double price;
	private Pilot pilot = null;

	// Constructor
	public Jet(String model, int speed, int range, double price) {
		super();
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}

	// Methods
	public double mphToMach() {
		return ((double) this.speed / 767.269);
	}

	public double priceToMils() {
		return (this.price / 1_000_000);
	}

	public boolean hasPilot() {
		if (this.pilot == null) {
			return false;
		} else {
			return true;
		}
	}

	// Getters & Setters
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Pilot getPilot() {
		return pilot;
	}

	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
	}

}
