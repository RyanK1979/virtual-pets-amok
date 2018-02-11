package virtualPetsAmok;

public class OrganicCat extends VirtualPet implements Organic {

	private int hunger;
	private int thirst;
	private int poopMade = 0;

	public OrganicCat(String name, String description, int health, int happiness, int hunger, int thirst) {
		super(name, description, health, happiness);
		this.hunger = hunger;
		this.thirst = thirst;
	}

	public OrganicCat(String name, String description) {
		super(name, description);
		hunger = 0;
		thirst = 0;
	}

	@Override
	public void tick() {
		hunger += 1;
		thirst += 1;
		poopMade += 1;
		if (hunger >= 10) {
			int currentHealth = super.getHealth();
			super.setHealth(currentHealth - 1);
			super.setHappiness(0);
		}

		if (thirst >= 10) {
			int currentHealth = super.getHealth();
			super.setHealth(currentHealth - 1);
			super.setHappiness(0);
		}
		super.tick();
	}

	public int getPoopLevels() {
		return poopMade;
	}

	public void resetWasteCreated() {
		poopMade = 0;
	}

	@Override
	public void water() {
		thirst = 0;
	}

	@Override
	public int getHunger() {
		return hunger;
	}

	@Override
	public void feed() {
		hunger = 0;
	}

	@Override
	public int getThirst() {
		return thirst;
	}

}
