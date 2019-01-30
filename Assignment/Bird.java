package Assignment8;

/**
 * 
 * @author anmol mehta
 * 
 * this class extends the property of animal class and shows this category animal is bird
 *
 */


public abstract class Bird extends Animal {

	final int id;
	
	public Bird()
	{
		speciality = new String("Flying");
		category = "Bird";
		id = ++animalIDStart;
	}
}
