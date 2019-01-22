public class Area {

	private double area;

	/*
	 * find the area of a Triangle
	 * 
	 * @param  width of Triangle in double
	 * 
	 * @param  height of Triangle in double
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
	 * @param  width of Rectangle in double
	 * 
	 * @param  height of Rectangle in double
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
	 * @param  radius of Circle in double
	 * 
	 * @return area of Circle
	 */
	protected double circleArea(double radius) {

		try {
			area = radius * radius * 3.14;
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
	protected double squareArea(double side) {
		try {
			area = side * side;
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
