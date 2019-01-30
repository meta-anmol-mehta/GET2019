package Assignment8;
import java.util.ArrayList;

/**
 * 
 * @author anmol mehta
 * 
 * this class is used to initialize the zone in zoo and add cage in the zone
 *
 */


public class Zone {
	
	private ArrayList<Cage> cage;
	public String zoneName;
	public int cageSpaceAvailable;
	public String categoryType;

	
	public boolean hasPark;
	public boolean hasCanteen;
	public boolean hasTrain;
	
	public Zone(int capacity, boolean hasPark,boolean hasCanteen,boolean hasTrain)
	{
		this.cage = new ArrayList<Cage>();
		this.cageSpaceAvailable = capacity;
		this.hasPark = hasPark;
		this.hasCanteen = hasCanteen;
		this.hasTrain = hasTrain;
	}
	
	/**
	 * create new cage if zone has no cage
	 * @param capacity denote number of animal that can be kept in zoo
	 */
	
	public void addEmptyCage(int capacity)
	{
		cage.add(new Cage(capacity));
		cageSpaceAvailable--;
	}
	/**
	 * to create new cage in zone
	 * @param cage which type of add is to add in zoo
	 * @return true if addeded succesfully
	 */
	public boolean addCage(Cage cage)
	{
		
		if(categoryType == null)
		{
			categoryType = cage.categoryType;
			zoneName = cage.categoryType + " Zone";
			
		}
		
		if(cageSpaceAvailable > 0 && categoryType.equals(cage.categoryType))
		{
			this.cage.add(cage);
			cageSpaceAvailable--;
			return true;
		}
		
		else
		{
			return false;
		}
	}
	/**
	 * 
	 * @return arrayList of cage that are already placed in zone
	 */
	public ArrayList<Cage> getCages()
	{
		return cage;
	}
	/**
	 * display all the cage in the zone 
	 */
	public void displayZone()
	{
		if(categoryType != null)
		{
		System.out.println(" ----------"+zoneName+"----------");
		System.out.println("|"+" "+"No. of "+categoryType+" Cages"+" = "+cage.size());
		System.out.println("|"+" "+"Category of zone is : "+categoryType);
		System.out.println("|"+" "+"Cage Space left : "+cageSpaceAvailable);
		System.out.println(" --------------------------------");
		}
		else
		{
			System.out.println("No cage added yet! Nothing to display");
		}
	}
}
