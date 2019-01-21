public class Area {

	private double area;

	/*
	 * find the area of a Triangle
	 * 
	 * @param width width of Triangle in double
	 * 
	 * @param height height of Triangle in double
	 * 
	 * @return area of Triangle
	 */
	protected double triangleArea(double width, double height) {
		try {
			area = (width * height) / 2;
		}

		catch (Exception e) {
			System.out.println(e);
		}
		return area;

	}

	/*
	 * find the area of a Rectangle
	 * 
	 * @param width width of Rectangle in double
	 * 
	 * @param height height of Rectangle in double
	 * 
	 * @return area of Rectangle
	 */
	protected double rectangleArea(double width, double height) {
		try {
			area = width * height;
		}

		catch (Exception e) {
			System.out.println(e);
		}
		return area;

	}

	/*
	 * find the area of a Circle
	 * 
	 * @param radius radius of Circle in double
	 * 
	 * @return area of Circle
	 */
	protected double circleArea(double width) {

		try {
			area = width * width * 3.14;
		}

		catch (Exception e) {
			System.out.println(e);
		}
		return area;

	}

	/*
	 * find the area of a Square
	 * 
	 * @param width width of Square in double
	 * 
	 * @return area of Square
	 */
	protected double squareArea(double width) {
		try {
			area = width * width;
		}

		catch (Exception e) {
			System.out.println(e);
		}
		return area;

	}

	/*
	 * display the area of a Shape given
	 * 
	 * @param type represent what shape it is
	 * 
	 * @return nothing
	 */
	protected void display(String type) {

		System.out.println("Area of" + type + "=" + area);

	}
}
