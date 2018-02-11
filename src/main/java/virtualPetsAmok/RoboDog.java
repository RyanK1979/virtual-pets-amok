package virtualPetsAmok;

public class RoboDog extends VirtualPet implements Robot {

	private int oilLevel;

	public RoboDog(String name, String description) {
		super(name, description);
		this.oilLevel = 10;
	}

	public RoboDog(String name, String description, int health, int happiness, int oilLevel) {
		super(name, description, health, happiness);
		this.oilLevel = oilLevel;
	}

	void walk() {
		super.setHappiness(10);
	}

	@Override
	public void fillOil() {
		this.oilLevel = 10;
	}

	@Override
	public int getOilLevel() {
		return this.oilLevel;
	}

	@Override
	public void tick() {
		oilLevel -= 1;
		oilLevel = Math.max(0, oilLevel);
		if (oilLevel <= 3) {
			int currentHealth = super.getHealth();
			super.setHealth(currentHealth - 1);
		}
		super.tick();
	}

}
