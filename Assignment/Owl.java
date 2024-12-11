package Assignment8;
import java.util.Date;

/**
 * 
 * @author anmol mehta
 * 
 * this class extends the property of animal class and shows this category of bird is owl
 *
 */
public class Owl extends Bird {
	
	
	
	public Owl(String name,int age,int weight) 
	{
		this.name = name;
		this.age = age;
		this.weight = weight;
		ageLimit = 10000;
		type = "Owl";
		birthTime = new Date().getTime();
	}
	/**
	 * here we overide function getSound of animal class
	 */
	@Override
	public String getSound()
	{
		return "Hoots";
	}
}
