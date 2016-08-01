package airportmanager;

import java.util.Scanner;

public class AirportPrompter {
	// Fields
	private Airport airport;

	// Constructor
	public AirportPrompter(Airport airport) {
		this.airport = airport;
	}

	Scanner keyboard = new Scanner(System.in);

	// Methods
	public void menu() {

		int input;
		do {

			System.out.println("\n***********************************************");
			System.out.println("|          Airport Inventory Tracker \u2708        |");
			System.out.println("|                                             |");
			System.out.println("| \u2708 1. List fleet.                            |");
			System.out.println("| \u2708 2. View fastest jet.                      |");
			System.out.println("| \u2708 3. View jet with longest range.           |");
			System.out.println("| \u2708 4. Add a jet to fleet.                    |");
			System.out.println("| \u2708 5. Hire a new pilot.                      |");
			System.out.println("| \u2708 6. Quit                                   |");
			System.out.println("|                                             |");
			System.out.println("***********************************************");
			input = keyboard.nextInt();

			switch (input) {
			case 1:
				displayFleet(airport);
				enterToContinue();
				break;
			case 2:
				displayFastestJet(airport);
				enterToContinue();
				break;
			case 3:
				displayLongestRange(airport);
				enterToContinue();
				break;
			case 4:
				keyboard.nextLine();
				addJet();
				enterToContinue();
				break;
			case 5:
				keyboard.nextLine();
				hirePilot();
				enterToContinue();
				break;
			default:
				break;
			}

		} while (input != 6);
		System.out.println("Exiting program.");
	}

	public void displayFleet(Airport a) {
		System.out.println("Current Fleet: \n");
		for (Jet jet : a.getJets()) {
			showJetDetails(jet);
		}
	}

	public void showJetDetails(Jet jet) {
		System.out.printf(jet.getModel() + "\tSpeed: Mach " + "%.2f" + "\tRange: " + jet.getRange() + "\tPrice: "
				+ jet.priceToMils() + "M \n", jet.mphToMach());
		if (jet.hasPilot()) {
			System.out.println("Piloted by " + jet.getPilot().getRank() + " " + jet.getPilot().getFirstName() + " "
					+ jet.getPilot().getLastName());

		} else {
			System.out.println("Currently no pilot assigned.");
		}
	}

	public void displayLongestRange(Airport a) {
		Jet longRangeJet = a.getLongestRange();
		System.out.println("The jet with the longest range is " + longRangeJet.getModel() + " at "
				+ longRangeJet.getRange() + " miles.\n");
		showJetDetails(longRangeJet);
	}

	public void displayFastestJet(Airport a) {
		Jet fastestJet = a.getFastestJet();
		System.out.println("The fastest jet is the " + fastestJet.getModel() + " at " + fastestJet.getSpeed()
				+ " miles per hour.\n");
		showJetDetails(fastestJet);
	}

	public void addJet() {
		System.out.print("    Input jet model: ");
		String model = keyboard.nextLine();
		System.out.print("  Input speed (mph): ");
		int speed = keyboard.nextInt();
		System.out.print("Input range (miles): ");
		int range = keyboard.nextInt();
		System.out.print("    Input Price ($): ");
		double price = keyboard.nextDouble();
		airport.addJet(new Jet(model, speed, range, price));
		Jet[] updatedJets = airport.getJets();
		System.out.println(updatedJets[updatedJets.length - 1].getModel() + " added to airport.");
	}

	public void hirePilot() {
		System.out.println("Input new pilot's rank: ");
		String rank = keyboard.nextLine();
		System.out.println("Input pilot's first name: ");
		String firstName = keyboard.nextLine();
		System.out.println("Input pilot's last name: ");
		String lastName = keyboard.nextLine();
		Pilot pilot = new Pilot(rank, firstName, lastName);
		airport.addPilot(pilot);
		Pilot[] updatedPilots = airport.getPilots();
		Pilot newPilot = updatedPilots[updatedPilots.length - 1];
		System.out.println(newPilot.getRank() + " " + newPilot.getFirstName() + " " + newPilot.getLastName()
				+ " added to airport.");
	}

	public void enterToContinue() {
		System.out.println("\nPress enter to continue...");
		try {
			System.in.read();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
