public class Product {

	private String productName;
	protected double productPrice;
	protected int productQuantity;

	Product(String productName, double productPrice, int productQuantity) {
		this.productName = productName;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
	}

	void productDisplay() {
		System.out.println("--ProductName:" + productName + "	"
				+ "ProductPrice:" + productPrice + "--");

	}
}
