package virtualPetsAmok;

public abstract class VirtualPet {

	private String name;
	private String description;
	private int health;
	private int happiness;

	public VirtualPet(String name, String description, int health, int happiness) {
		super();
		this.name = name;
		this.description = description;
		this.health = health;
		this.happiness = happiness;
	}

	public VirtualPet(String name, String description) {
		super();
		this.name = name;
		this.description = description;
		this.health = 10;
		this.happiness = 10;
	}

	public void play() {
		happiness = 10;
	}

	public void tick() {

		happiness -= 1;
		if (happiness == 0) {
			health -= 1;
		}
		if (health < 5) {
			happiness -= 1;
		}
		happiness = Math.max(0, happiness);
		health = Math.max(0, health);

	}

	public int getHealth() {
		return health;
	}

	protected void setHealth(int health) {
		this.health = health;
	}

	public int getHappiness() {
		return happiness;
	}

	protected void setHappiness(int happiness) {
		this.happiness = happiness;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

}
