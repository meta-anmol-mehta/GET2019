package Assignment8;

import java.util.Date;


/**
 * 
 * @author Anmol mehta
 * 
 * @param anmimalIDstart,name,age birthtime,ageLimit,weight,type,category,speiality that store their respective animal data values
 *
 *
 *@class animal is an bstract class that shows some general charactestics of animal
 */

abstract class Animal
{
	public static int animalIDStart = 1000;
	public String name;
	public int age;
	public long birthTime;
	public long ageLimit;
	public int weight;
	public String type;
	public String category;
	public String speciality;
	
	/**
	 * 
	 * getSound() method what sound does an animal make 
	 * 
	 * @return string value that shows sound of an animal
	 */
	public abstract String getSound();
	
	
	/**
	 * this method is used to display the general charactestics of animal
	 */
	public void display()
	{
		System.out.println("Name : "+name);
		System.out.println("Age : "+age);
		System.out.println("Weight : "+weight);
		System.out.println("Birth Date : "+new Date(birthTime).toString());
		System.out.println("Speciality : "+speciality);
	}
	
}