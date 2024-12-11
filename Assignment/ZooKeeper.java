package Assignment8;
import java.util.ArrayList;
import java.util.Scanner;

public class ZooKeeper {

	public ArrayList<Zone> zones;
	public int zoneIndex = 0;
	public int cageIndex =0;
	static Scanner in = new Scanner(System.in);

	/**
	 * 
	 * constructor of zookeeper first inialize fisrt zone and cage in that zone
	 * 
	 */
	ZooKeeper() {
		this.zones = new ArrayList<Zone>();
		System.out.println("Please enter a primary zone as no zone is defined : ");
		addZone();
		System.out.println("Please enter a primary cage as no cages are there : ");
		System.out.println("Enter the capacity for the cage : ");
		zones.get(0).addEmptyCage(Integer.parseInt(in.nextLine()));
	}

	/**
	 * 
	 * add animal in the cage suitable to the animal
	 * 
	 * @param animal animal thart nweed to be added in the cage
	 * 
	 * 
	 */
	public void placeAnimal(Animal animal) {
		
		int i = 0 ,j = 0;
		
		for(Zone zone : zones)
		{
			if(zone.cageSpaceAvailable > 0 || zones.size() == 1)
			{
				zoneIndex = j;
				for(Cage cage : zone.getCages())
				{
					if(cage.addAnimal(animal))
					{
						cageIndex = i;
						zones.get(zoneIndex).categoryType = animal.category;
						zones.get(zoneIndex).zoneName = animal.category+" Zone";
						break;
					}
					else if(zone.getCages().size()-1 != cageIndex )
					{
						i++;
					}
					else
					{	
						System.out.println("Old cages full, Please give capacity for new cage : ");
						Cage tempCage = new Cage(Integer.parseInt(in.nextLine()));
						tempCage.addAnimal(animal);
						if(!zone.addCage(tempCage))
						{
							System.out.println("Old Zone full! Making a new one : ");
							addZone();
							break;
						}
						else
						cageIndex = i;i++;
						break;
					}
				}
				break;
			}
			else if(zones.size()-1 != zoneIndex)
			{
				j++;
			}
			else
			{
				System.out.println("Old Zone full! Making a new zone now : ");
				addZone();
				zoneIndex = zones.size()-1;j++;
				placeAnimal(animal);
				break;
			}
		}
	}
	
	public void addAnimal()
	{
		String choice,name;
		int weight=0,age=0;
		boolean result=false;
		String tempWeight,tempAge;
		
		System.out.println("Please select the animal you want to add : ");
		System.out.println("1. Lion");
		System.out.println("2. Owl");
		System.out.println("3. Snake");
		choice = in.nextLine();
		System.out.println("Enter name of the animal : ");
		name = in.nextLine();
		System.out.println("Enter age of "+name+" : ");
		tempAge=in.nextLine();
		do{
			result=false;
			
			if(tempAge.matches("[0-9]+")){
				result=true;

				age = Integer.parseInt(tempAge);

				if(age<0){
					result=false;
				}
					}
			else{
				System.out.println("Re-enter correct age of "+name+" : ");
				tempAge = in.nextLine();
			}
		}while(!result);
		
		System.out.println("Enter weight of "+name+" : ");
		tempWeight=in.nextLine();
		do{
			result=false;
			if(tempWeight.matches("[0-9]+")){
				result=true;

				weight = Integer.parseInt(tempWeight);

				if(weight<0){
					result=false;
				}
					}
			else{
				System.out.println("Re-enter correct weight of "+name+" : ");
				tempWeight = in.nextLine();
			}
		}while(!result);
		
		switch (choice) {
		case "1" : 
					
					placeAnimal(new Lion(name,age,weight));
					
					System.out.println( "New Lion Added!");break;
		
		case "2" : 	
		
					placeAnimal(new Owl(name,age,weight));
		
					System.out.println("New Owl Added!");break;
		
		case "3" : 	
					placeAnimal(new Snake(name,age,weight));

					System.out.println("New Snake Added!");break;
	
		default: System.out.println("Please enter a valid animal from list");break;
		}
	}

	/**
	 * checkcage checks every cage in which the animal is dead or not
	 */
	public void checkCage() {

	    for(Zone zone : zones)
	    {
	        for(Cage cage : zone.getCages())  
	        {
	            Animal animal = cage.checkCage();
	            if(animal == null)
	            {
	                System.out.println("All animals are alive!");
	            }
	            else
	            {
	                System.out.println(animal.name+" Died! Animal is removed now...");
	            }
	        }
	    }
	    
	}

	/**
	 * to create new zone in the zoo
	 */
	public void addZone() {
		int capacity = 0;
		String tempCapacity;
		boolean result=false;
		
		System.out.println("Please enter capacity of the new zone : ");
		tempCapacity=in.nextLine();
		do{
			result=false;
			if(tempCapacity.matches("[0-9]+")){
				result=true;

				capacity = Integer.parseInt(tempCapacity);
				
				if(capacity<0){
					result=false;
				}
				
					}
			else{
				System.out.println("Re-enter correct capacity : ");
				tempCapacity = in.nextLine();
			}
		}while(!result);
		
		zones.add(new Zone(capacity,false,false,false));
	}

	public void zooOverview()
	{
		for(Zone zone : zones)
	    {
			zone.displayZone();
	        for(Cage cage : zone.getCages())  
	        {
	            cage.displayCage();
	            for(Animal animal : cage.getAnimals())
	            {
	            	animal.display();
	            }
	        }
	    }
	}
	
	public static void main(String list[]) {
		String choice;

		ZooKeeper keeper = new ZooKeeper();

		do {
			System.out.println("Menu");
			System.out.println("1. Add an animal.");
			System.out.println("2. Check Cage");
			System.out.println("3. Add Zone");
			System.out.println("4. Zoo Overview");
			System.out.println("5. EXIT ->()");

			System.out.println("Enter your choice please : ");
			choice = in.nextLine();

			switch (choice) 
			{
				case "1" :	keeper.addAnimal();break;
			
				case "2" :	keeper.checkCage();break;
			
				case "3" :	keeper.addZone();break;
			
				case "4" :	keeper.zooOverview();break;
					
				case "5" :	System.exit(0);
			
				default: 	System.out.println("Wrong selection!");
			}
			
		} while (!choice.equals("5"));
	}

}
