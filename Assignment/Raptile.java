package Assignment8;

/**
 * 
 * @author anmol mehta
 * 
 * this class extends the property of animal class and shows this category animal is reptile
 *
 */

public abstract class Raptile extends Animal {

	final int id;
	
	public Raptile() 
	{
		speciality = new String("Scales");
		category = "Raptile";
		id = ++animalIDStart;
	}
}
