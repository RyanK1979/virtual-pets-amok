package virtualPetsAmok;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Collection;

import org.junit.Test;

public class VirtualPetTest {

	@Test
	public void shouldShowPets() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		Collection<VirtualPet> result = underTest.petCollection();
		assertNotNull(result);
	}

	@Test
	public void shouldAddOrganicDog() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		OrganicDog adoptablePet = new OrganicDog("Zoey", "Something fun", 10, 10, 10, 10);
		underTest.intake(adoptablePet);
		assertNotNull(underTest);
	}

	@Test
	public void shouldAddOrganicCat() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		OrganicCat adoptablePet = new OrganicCat("Bob", "Something not fun", 10, 10, 10, 10);
		underTest.intake(adoptablePet);
		assertNotNull(underTest);
	}

	@Test
	public void oilLevelShouldGoUpAfterFill() {
		RoboDog underTest = new RoboDog("", "", 10, 10, 2);
		underTest.fillOil();
		int check = 10;
		assertEquals(check, underTest.getOilLevel());
	}

	@Test
	public void needToPoopRestsAfterWalk() {
		OrganicDog underTest = new OrganicDog("", "", 8, 3, 0, 0);
		underTest.setNeedToPoop(4);
		underTest.walk();
		int check = 0;
		assertEquals(check, underTest.getNeedToPoop());
	}

	@Test
	public void needToMakeSureCratesGetCleaned() {
		VirtualPetShelter shelter = new VirtualPetShelter();
		OrganicDog underTest = new OrganicDog("", "");
		shelter.intake(underTest);
		underTest.setWasteLevelInDogCage(1);
		shelter.cleanCages();
		int check = 0;
		assertEquals(underTest.getWasteLevelInDogCage(), check);
	}

	@Test
	public void makeSureTickMakesDogHaveToPoop() {
		OrganicDog underTest = new OrganicDog("", "", 5, 5, 0, 0);
		underTest.tick();
		int check = 1;
		assertEquals(check, underTest.getNeedToPoop());
	}

	@Test
	public void makeSureTickLowersHappiness() {
		OrganicCat underTest = new OrganicCat("", "", 8, 8, 3, 3);
		underTest.tick();
		int check = 7;
		assertEquals(check, underTest.getHappiness());
	}

	@Test
	public void seeIfWalkResetsHappiness() {
		RoboDog underTest = new RoboDog("", "", 10, 6, 3);
		underTest.walk();
		int check = 10;
		assertEquals(check, underTest.getHappiness());
	}

	@Test
	public void makeSureLitterBoxEmpties() {
		VirtualPetShelter shelter = new VirtualPetShelter();
		OrganicCat underTest = new OrganicCat("Cat1", "");
		shelter.intake(underTest);
		OrganicCat underTest2 = new OrganicCat("Cat2", "");
		shelter.intake(underTest2);
		shelter.tick();
		shelter.tick();
		shelter.cleanLitterbox();
		int check = 0;
		assertEquals(check, shelter.getLitterboxWasteLevel());

	}

}
