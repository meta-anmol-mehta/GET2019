
public class Product {

	String product_Name;
	double product_Price;
	int product_Quantity;
	
	void addProduct(String product_Name,double product_Price,int product_Quantity){
		this.product_Name=product_Name;
		this.product_Price=product_Price;
		this.product_Quantity=product_Quantity;
	}
	
	void product_display(){
		System.out.println("--ProductName:"+product_Name+"	"+"ProductPrice:"+product_Price+"--");
	
	}
}
