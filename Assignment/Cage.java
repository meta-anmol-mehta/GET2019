package Assignment8;

import java.util.ArrayList;
import java.util.Date;


/**
 * 
 * @author anmol mehta
 * 
 * this class is used to initialize the cage in zone and add animal in the cage
 *
 */
public class Cage
{
	private ArrayList <Animal> animal;
	public String cageName;
	public String animalType;
	public String categoryType;
	public int animalSpaceAvailable;
	
	
	
	public Cage(int capacity)
	{
		this.animal = new ArrayList<Animal>();
		animalSpaceAvailable = capacity;
	}
	
	/**
	 * 
	 * this method add animal add animal to cage 
	 * 
	 * @param animal
	 * @return true if animal get added else false
	 */
	
	public boolean addAnimal(Animal animal)
	{  
		if(animalType == null)
		{
			animalType = animal.type;
			categoryType = animal.category;
			cageName = animal.type + " Cage";
		}
		
		if(animalSpaceAvailable > 0 && animalType.equals(animal.type))
		{		
			this.animal.add(animal);
			animalSpaceAvailable--;
			return true;
		}
		
		else
		{
			return false;
		}
	}
	
	/**
	 * 
	 * @return arrayList of animal that are already placed in cage
	 */
	public ArrayList<Animal> getAnimals()
	{
		return animal;
	}
	
	/**
	 * display all the animal in the cage 
	 */
	public void displayCage()
	{
		if(categoryType != null)
		{
		System.out.println(" ----------"+cageName+"----------");
		System.out.println("|"+" "+"No. of "+animalType+"s"+" = "+animal.size());
		System.out.println("|"+" "+"Type of animal is : "+animalType);
		System.out.println("|"+" "+"Category of animal is : "+categoryType);
		System.out.println("|"+" "+"Space left : "+animalSpaceAvailable);
		System.out.println(" --------------------------------");
		}
		else
		{
			System.out.println("No animal added yet! Nothing to display");
		}
	}
	
	
	/**
	 * checkCage function if animal is dead 
	 * @return animal that is dead
	 */
	public Animal checkCage()
	{
		int i = 0;
		Animal animal = null;
		
		for(Animal animals : this.animal)
		{
		    
			if((new Date().getTime() - animals.birthTime) >= animals.ageLimit)
			{
			    animal = this.animal.get(i);
				this.animal.remove(i);
				animalSpaceAvailable++;	
				break;
			}
			i++;
		}
		
		return animal;
	}
}
