package virtualPetsAmok;

import java.util.Scanner;

public class VirtualPetShelterApp {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		VirtualPetShelter myShelter = new VirtualPetShelter();

		RoboDog defaultPet1 = new RoboDog("Aibo", "An amazingly lifelike puppy");
		myShelter.intake(defaultPet1);
		RoboCat defaultPet2 = new RoboCat("Johnny", "\"Keeps claiming hes Johnny 5, and hes alive, weird\"");
		myShelter.intake(defaultPet2);
		OrganicDog defaultPet3 = new OrganicDog("Zoey", "\"So sweet, and loving, she will make you fall in love\"");
		myShelter.intake(defaultPet3);
		OrganicCat defaultPet4 = new OrganicCat("Shadow", "Will be the king of your house, even if only in his mind");
		myShelter.intake(defaultPet4);

		startupGame();
		System.out.println("\nPress Enter to continue");
		input.nextLine();

		String menuSelection = "";
		while (!menuSelection.equals("quit")) {

			if (myShelter.getNumberOfPets() > 0) {
				displayPetsStats(myShelter);
			} else {
				System.out.println("\nWe are currently out of pets to adopt.\n");
			}

			showMenu();
			menuSelection = input.nextLine();

			if (menuSelection.equals("1")) {
				for (VirtualPet i : myShelter.petCollection()) {
					if (i instanceof Organic) {
						((Organic) i).feed();
					}
				}
				System.out.println("You have fed the animals.\nThey are now your best friends!");
			}

			else if (menuSelection.equals("2")) {
				for (VirtualPet i : myShelter.petCollection()) {
					if (i instanceof Organic) {
						((Organic) i).water();
					}
				}
				System.out.println("You watered the dogs.\nHow did you know they prefer spring water");
			}

			else if (menuSelection.equals("3")) {
				for (VirtualPet i : myShelter.petCollection()) {
					if (i instanceof Robot) {
						((Robot) i).fillOil();
					}
				}
				System.out.println("Thanks for oiling the robots.\nI was tired of hearing them squeak!");
			}

			else if (menuSelection.equals("4")) {
				for (VirtualPet i : myShelter.petCollection()) {
					System.out.println(i.getName() + "\t" + i.getDescription());
				}
				System.out.println("\nWho would you like to play with?\nEnter pet name:");
				String name = input.nextLine();
				if (myShelter.petPresent(name)) {
					myShelter.getPetByName(name).play();
					System.out.println("\nYou played with " + name + ".");
				} else {
					System.out.println("\nPet not found!");
				}
			}

			else if (menuSelection.equals("5")) {
				for (VirtualPet i : myShelter.petCollection()) {
					if (i instanceof Dog) {
						((Dog) i).walk();
					}
				}
				System.out.println("I bet you got a good workout, the children next door always pique there interest.");
			}

			else if (menuSelection.equals("6")) {
				myShelter.cleanLitterbox();
				System.out.println("You cleaned the litterbox.");
				System.out.println("I'm just glad it was you, and not me, eek.");
			}

			else if (menuSelection.equals("7")) {
				for (VirtualPet i : myShelter.petCollection()) {
					if (i instanceof OrganicDog) {
						((OrganicDog) i).setWasteLevelInDogCage(0);
					}
				}
				System.out.println("You cleaned all the organic dog cages.");
				System.out.println("You should take them on walks more often.");
			}

			else if (menuSelection.equals("8")) {

				System.out.println("So, you want to admit a new pet...");
				System.out.println("Enter the new pet's name, limit to 12 characters please");
				String name = input.nextLine();
				System.out.println("Enter a description");
				String description = input.nextLine();
				System.out.println("What kind of pet are we talking about?");
				System.out.println("1 - Organic Dog");
				System.out.println("2 - Organic Cat");
				System.out.println("3 - Robot Dog");
				System.out.println("4 - Robot Cat");
				System.out.println("\nEnter choice");
				String intakeMenuChoice = input.nextLine();
				if (intakeMenuChoice.equals("1")) {

					OrganicDog newPet = new OrganicDog(name, description);
					myShelter.intake(newPet);
				}
				if (intakeMenuChoice.equals("2")) {

					OrganicCat newPet = new OrganicCat(name, description);
					myShelter.intake(newPet);
				}
				if (intakeMenuChoice.equals("3")) {

					RoboDog newPet = new RoboDog(name, description);
					myShelter.intake(newPet);
				}
				if (intakeMenuChoice.equals("4")) {

					RoboCat newPet = new RoboCat(name, description);
					myShelter.intake(newPet);
				}
				System.out.println("\nThanks for surrendering " + name + "we will find them a great home!\n");
			}

			else if (menuSelection.equals("9")) {
				for (VirtualPet i : myShelter.petCollection()) {
					System.out.println(i.getName() + "\t" + i.getDescription());
				}
				System.out.println("\nWhich pet have you fallen in love with? Enter name:");
				String name = input.nextLine();
				if (myShelter.petPresent(name)) {
					VirtualPet pet = myShelter.getPetByName(name);
					myShelter.removePetFromShelter(pet);
					System.out.println("\n" + name + " has been adopted. \nPlease take good care of, " + name + "!");
				} else {
					System.out.println("Sorry we have no pet by that name");
				}
			}

			else if (menuSelection.equals("quit")) {
				break;
			}

			else {
				System.out.println("\nYou didn't make a selection. \nLet's check on the pets...\n\n");
			}

			myShelter.tick();

		}

		System.out.println("Thanks for coming!");

		input.close();

	}

	private static void startupGame() {
		System.out.println("Welcome to Ryan's amazing pet rescue, we have real animals, and robotic ones.\n\n");
	}

	private static void displayPetsStats(VirtualPetShelter shelter) {
		System.out.println();
		System.out.println("            |             |        |           |        |        | Oil   | Waste\r\n"
				+ "Name        | Type        | Health | Happiness | Hunger | Thirst | Level | In Cage\r\n"
				+ "------------|-------------|--------|-----------|--------|--------|-------|--------");
		for (VirtualPet i : shelter.petCollection()) {
			if (i instanceof RoboCat) {
				System.out.printf("%-12s", i.getName());
				System.out.print("| ");
				System.out.printf("%-12s", "Robot Cat");
				System.out.print("| ");
				System.out.printf("%-7s", i.getHealth());
				System.out.print("| ");
				System.out.printf("%-10s", i.getHappiness());
				System.out.print("| ");
				System.out.printf("%-7s", "n/a"); // hunger
				System.out.print("| ");
				System.out.printf("%-7s", "n/a"); // thirst
				System.out.print("| ");
				System.out.printf("%-6s", ((RoboCat) i).getOilLevel());
				System.out.print("| ");
				System.out.println("n/a"); // poop in the cage

			}
			if (i instanceof OrganicCat) {
				System.out.printf("%-12s", i.getName());
				System.out.print("| ");
				System.out.printf("%-12s", "Organic Cat");
				System.out.print("| ");
				System.out.printf("%-7s", i.getHealth());
				System.out.print("| ");
				System.out.printf("%-10s", i.getHappiness());
				System.out.print("| ");
				System.out.printf("%-7s", ((OrganicCat) i).getHunger());
				System.out.print("| ");
				System.out.printf("%-7s", ((OrganicCat) i).getThirst());
				System.out.print("| ");
				System.out.printf("%-6s", "n/a"); // oil level
				System.out.print("| ");
				System.out.println("n/a"); // poop in the cage
			}
			if (i instanceof RoboDog) {
				System.out.printf("%-12s", i.getName());
				System.out.print("| ");
				System.out.printf("%-12s", "Robot Dog");
				System.out.print("| ");
				System.out.printf("%-7s", i.getHealth());
				System.out.print("| ");
				System.out.printf("%-10s", i.getHappiness());
				System.out.print("| ");
				System.out.printf("%-7s", "n/a"); // hunger
				System.out.print("| ");
				System.out.printf("%-7s", "n/a"); // thirst
				System.out.print("| ");
				System.out.printf("%-6s", ((RoboDog) i).getOilLevel());
				System.out.print("| ");
				System.out.println("n/a"); // poop in the cage
			}
			if (i instanceof OrganicDog) {
				System.out.printf("%-12s", i.getName());
				System.out.print("| ");
				System.out.printf("%-12s", "Organic Dog");
				System.out.print("| ");
				System.out.printf("%-7s", i.getHealth());
				System.out.print("| ");
				System.out.printf("%-10s", i.getHappiness());
				System.out.print("| ");
				System.out.printf("%-7s", ((OrganicDog) i).getHunger());
				System.out.print("| ");
				System.out.printf("%-7s", ((OrganicDog) i).getThirst());
				System.out.print("| ");
				System.out.printf("%-6s", "n/a"); // oil level
				System.out.print("| ");
				System.out.println(((OrganicDog) i).getWasteLevelInDogCage());
			}

		}
		System.out.println("\nLitterbox poop level: " + shelter.getLitterboxWasteLevel());
	}

	private static void showMenu() {
		System.out.println();
		System.out.println("What would you like to do?\n");
		System.out.println("1 - feed all organic pets");
		System.out.println("2 - water all organic pets");
		System.out.println("3 - oil all robot pets");
		System.out.println("4 - play with a pet");
		System.out.println("5 - walk all dogs");
		System.out.println("6 - empty litterbox");
		System.out.println("7 - clean all organic dog crates");
		System.out.println("8 - new pet surrender");
		System.out.println("9 - rescue a pet");
		System.out.println();
		System.out.println("Enter \"quit\" to quit");
		System.out.println("\nChoose an action: ");
	}

}
