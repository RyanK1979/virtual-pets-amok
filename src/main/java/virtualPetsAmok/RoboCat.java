package virtualPetsAmok;

public class RoboCat extends VirtualPet implements Robot{
	
	private int oilLevel;

	public RoboCat(String name, String description, int health, int happiness, int oilLevel) {
		super(name, description, health, happiness);
		this.oilLevel = oilLevel;
	}

	public RoboCat(String name, String description) {
		super(name, description);
		this.oilLevel = 10;
	}

	@Override
	public void fillOil() {
		oilLevel = 10;
	}

	@Override
	public void tick() {
		oilLevel -= 1;
		oilLevel = Math.max(0, oilLevel);
		int currentHealth = super.getHealth();
		if (oilLevel <= 3) {
			super.setHealth(currentHealth - 1);
		}
		super.tick();
	}

	@Override
	public int getOilLevel() {
		return oilLevel;
	}

}


