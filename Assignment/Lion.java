package Assignment8;
import java.util.Date;

/**
 * 
 * @author anmol mehta
 * 
 * this class extends the property of animal class and shows this category of mammal is Lion
 *
 */

public class Lion extends Mammal{

	
	
	public Lion(String name,int age,int weight) 
	{
		this.name = name;
		this.age = age;
		this.weight = weight;
		ageLimit = 3000;
		type = "Lion";
		birthTime = new Date().getTime();
	}
	
	/**
	 * here we overide function getSound of animal class
	 */
	@Override
	public String getSound()
	{
		return "Roar";
	}
}
