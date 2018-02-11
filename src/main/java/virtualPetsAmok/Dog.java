package virtualPetsAmok;

public abstract class Dog extends VirtualPet {
	
	public Dog(String name, String description) {
		super(name, description);
	}

	public Dog(String name, String description, int health, int happiness) {
		super(name, description, health, happiness);
	}

	void walk() {
		super.setHappiness(10);
	}

}


