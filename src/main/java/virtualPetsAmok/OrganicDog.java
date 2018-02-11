package virtualPetsAmok;

public class OrganicDog extends Dog implements Organic {

	private int hunger;
	private int thirst;
	private int poopInDogCrate;
	private int needToPoop;

	public OrganicDog(String name, String description, int health, int happiness, int hunger, int thirst) {
		super(name, description, health, happiness);
		this.hunger = hunger;
		this.thirst = thirst;
		poopInDogCrate = 0;
		needToPoop = 0;
	}

	public OrganicDog(String name, String description) {
		super(name, description);
	}

	public int getWasteLevelInDogCage() {
		return poopInDogCrate;
	}

	public void setWasteLevelInDogCage(int poopLevelInCrate) {
		this.poopInDogCrate = poopLevelInCrate;
	}

	@Override
	public void walk() {
		super.walk();
		needToPoop = 0;
	}

	@Override
	public void tick() {
		hunger += 1;
		thirst += 1;
		needToPoop += 1;
		if (needToPoop >= 4) {
			poopInDogCrate += 1;
			needToPoop = 0;
		}
		if (poopInDogCrate >= 2) {
			int currentHealth = super.getHealth();
			super.setHealth(currentHealth - 1);
			int currentHappiness = super.getHappiness();
			super.setHappiness(currentHappiness - 1);
			;
		}
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

	public void setNeedToPoop(int needToPoop) {
		this.needToPoop = needToPoop;
	}

	public int getNeedToPoop() {
		return needToPoop;
	}

	@Override
	public void feed() {
		hunger = 0;
	}

	@Override
	public int getHunger() {
		return hunger;
	}

	@Override
	public void water() {
		thirst = 0;
	}

	@Override
	public int getThirst() {
		return thirst;
	}
}