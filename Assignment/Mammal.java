package Assignment8;

/**
 * 
 * @author anmol mehta
 * 
 * this class extends the property of animal class and shows this category animal is mammal
 *
 */

public abstract class Mammal extends Animal {

	final int id;
	
	public Mammal() 
	{
		speciality = new String("Being Mammal");
		category = "Mammal";
		id = ++animalIDStart;
	}
}
