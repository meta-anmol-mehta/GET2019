package Assignment8;
import java.util.Date;

/**
 * 
 * @author anmol mehta
 * 
 * this class extends the property of animal class and shows this category of mammal is Lion
 *
 */
public class Snake extends Raptile {

	
	public Snake(String name,int age,int weight)
	{
		this.name = name;
		this.age = age;
		this.weight = weight;
		ageLimit = 25000;
		type = "Snake";
		birthTime = new Date().getTime();
	}
	/**
	 * here we overide function getSound of animal class
	 */
	@Override
	public String getSound()
	{
		return "Hisses!";
	}
	
}
