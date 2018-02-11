package virtualPetsAmok;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {

	private int litterBoxPoopLevel = 0;

	private Map<String, VirtualPet> pets = new HashMap<String, VirtualPet>();

	public Collection<VirtualPet> petCollection() {
		return pets.values();
	}

	public int getLitterboxWasteLevel() {
		return litterBoxPoopLevel;
	}

	public void cleanLitterbox() {
		litterBoxPoopLevel = 0;
	}

	public VirtualPet getPetByName(String name) {
		return pets.get(name);
	}

	public void intake(VirtualPet pet) {
		pets.put(pet.getName(), pet);
	}

	public void removePetFromShelter(VirtualPet pet) {
		pets.remove(pet.getName());
	}

	public void feedAll() {
		for (VirtualPet i : petCollection()) {
			if (i instanceof Organic) {
				((Organic) i).feed();
			}
		}
	}

	public void waterAll() {
		for (VirtualPet i : petCollection()) {
			if (i instanceof Organic) {
				((Organic) i).water();
			}
		}
	}

	public void play(VirtualPet pet) {
		pet.play();
	}

	public void tick() {
		for (VirtualPet i : petCollection()) {
			i.tick();
		}
		allOrganicCatsPoop();
		ifLitterboxFullDecreaseOrganicCatStats();
	}

	public int getNumberOfPets() {
		return pets.size();
	}

	public boolean petPresent(String name) {
		return (pets.containsKey(name));
	}

	private void allOrganicCatsPoop() {
		int organicCatWasteIncoming = 0;
		for (VirtualPet i : petCollection()) {
			if (i instanceof OrganicCat) {
				organicCatWasteIncoming += ((OrganicCat) i).getPoopLevels();
				((OrganicCat) i).resetWasteCreated();
			}
		}
		this.litterBoxPoopLevel += organicCatWasteIncoming;
	}

	private void ifLitterboxFullDecreaseOrganicCatStats() {
		if (litterBoxPoopLevel >= 20) {
			for (VirtualPet i : petCollection()) {
				if (i instanceof OrganicCat) {
					i.setHealth(i.getHealth() - 1);
					i.setHappiness(i.getHappiness() - 1);
				}
			}
		}
	}

	public void cleanCages() {
		for (VirtualPet i : petCollection()) {
			if (i instanceof OrganicDog) {
				((OrganicDog) i).setWasteLevelInDogCage(0);
			}
		}
	}

	public void oilRobots() {
		for (VirtualPet i : petCollection()) {
			if (i instanceof Robot) {
				((Robot) i).fillOil();
			}
		}
	}

}

