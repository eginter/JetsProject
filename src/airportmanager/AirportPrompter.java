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

		/**
		 * User Story #1 Minimum: There is a menu with 5 options: 1. List fleet
		 * 2. View fastest jet 3. View jet with longest range 4. Add a jet to
		 * Fleet 5. Quit
		 */

		int input;
		do {

			System.out.println("\n\n***********************************************");
			System.out.println("*          Airport Inventory Tracker          *");
			System.out.println("*                                             *");
			System.out.println("* 1. List fleet.                              *");
			System.out.println("* 2. View fastest jet.                        *");
			System.out.println("* 3. View jet with longest range.             *");
			System.out.println("* 4. Add a jet to fleet.                      *");
			System.out.println("* 5. Hire a new pilot.                        *");
			System.out.println("* 6. Quit                                     *");
			System.out.println("*                                             *");
			System.out.println("*                                             *");
			System.out.println("*                                             *");
			System.out.println("*                                             *");
			System.out.println("***********************************************");
			input = keyboard.nextInt();

			switch (input) {
			case 1:
				displayFleet(airport);
				break;
			case 2:
				displayFastestJet(airport);
				break;
			case 3:
				displayLongestRange(airport);
				break;
			case 4:
				keyboard.nextLine();
				addJet();
				break;
			case 5:
				keyboard.nextLine();
				hirePilot();
				break;
			default:
				break;
			}

			/**
			 * User Story #4
			 * 
			 * Quit exits the program.
			 */

		} while (input != 6);
	}

	/**
	 * User Story #2
	 *
	 * List fleet prints out the model, speed, range, and price of each jet.
	 * (There must be at least 5 jets stored when the program starts).
	 */

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

	/**
	 * User Story #3
	 * 
	 * The view fastest jet and longest range options both print out all of the
	 * information about their jets.
	 */

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

	/**
	 * User Story #5
	 * 
	 * A user can add custom jets to the fleet.
	 */

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
}
