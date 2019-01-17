import java.util.ArrayList;
import java.util.Scanner;


public class Cart {

	static ArrayList<Product> Product_List=new ArrayList<Product>();
	ArrayList<Product> ShoppingList=new ArrayList<Product>();
	Cart(){
		
		Product product=new Product();
		product.addProduct("Soap", 25.0, 0);
		Product_List.add(product);
		product=new Product();
		product.addProduct("Brush", 20.0, 0);
		Product_List.add(product);
		product=new Product();
		product.addProduct("Paste", 40.0, 0);
		Product_List.add(product);
		product=new Product();
		product.addProduct("Lotion", 50.0, 0);
		Product_List.add(product);
		product=new Product();
		product.addProduct("Oil", 95.0, 0);
		Product_List.add(product);
		
	}
	
	
	public static void main(String []args){
		
			System.out.println("Welcome to the Cart");
			int choice;	
			String Product_choice;
			Scanner s=new Scanner(System.in);
		
			Cart newUser=new Cart();
			
			System.out.println("Available Products!");
			int index=1;
			for(Product product:Product_List)
			{
				System.out.print(index);product.product_display();
				index++;
			}
			
			do{
				
				System.out.println("Enter your choice ");
				System.out.println("Enter 1 for AddToCart");
				System.out.println("Enter 2 for UpdateCart");
				System.out.println("Enter 3 for RemoveCart");
				System.out.println("Enter 4 for Billing");
				System.out.println("Exit Application");
				choice=s.nextInt();
				
				switch(choice)
				{
				case 1:	newUser.AddToCart();
						break;
				case 2:newUser.UpdateToCart();
						break;
				case 3:newUser.RemoveFromCart();
						break;
				case 4:newUser.Billing();
						break;
				case 5:break;		
				}
				
			}while(choice>=1&&choice<4);
	}
	
	void AddToCart(){
		
		System.out.println("Enter your choice for purchasing");
		int index=1;
		for(Product product:Product_List)
		{
			System.out.print(index);product.product_display();
			index++;
		}
		
		Scanner s=new Scanner(System.in);
		int choice=s.nextInt();
		
		System.out.println("Enter the quantity you want to add");
		int quantity=s.nextInt();
		Product_List.get(choice-1).product_Quantity=quantity;
				
		ShoppingList.add(Product_List.get(choice-1));
		
		System.out.println("Item Added");
		
		
	}
	
	void RemoveFromCart(){
		if(!ShoppingList.isEmpty())
		{
		System.out.println("Enter your choice for remove");
		int index=1;
		for(Product product:ShoppingList)
		{
			System.out.print(index);product.product_display();
			index++;
		}
		
		Scanner s=new Scanner(System.in);
		int choice=s.nextInt();
		
		ShoppingList.remove(choice-1);
		System.out.println("Item removed");
		}
		else{
			System.out.println("Cart is empty");
		}
		
			
		}
		
	
	void UpdateToCart(){
		if(!ShoppingList.isEmpty())
		{
		System.out.println("Enter your choice for update");
	
		for(Product product:ShoppingList){
			product.product_display();
		}
		
		Scanner s=new Scanner(System.in);
		int choice=s.nextInt();
		
		System.out.println("Enter the quantity you want to update");
		int quantity=s.nextInt();
		ShoppingList.get(choice-1).product_Quantity=quantity;
		System.out.println("Item Updated");
		}
		else{
			System.out.println("Cart is empty");
		}
	
	}
	
	void Billing(){
		if(!ShoppingList.isEmpty())
		{
		User user=new User();
		double total=0;
		System.out.println("Generating bill!");
		user.User_display();
		
		for(Product product:ShoppingList){
			total+=product.product_Quantity*product.product_Price;
		}
		System.out.println("Total amount="+total);
	}
	else{
		System.out.println("Cart is empty");
	}
	}
	
}
