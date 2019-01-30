import java.util.List;

/**
 * Factory class which returns the object of the shape created on the basis of
 * the type specified
 * 
 * @author Anmol mehta
 *
 */
public class Factory {

	/**
	 * Method to return the object of the shape created
	 * 
	 * @param type,
	 *            type of the shape such as rectangle, square
	 * @param point,
	 *            origin of the shape
	 * @param parameters,
	 *            list of parameters of the shape such as its length, width
	 *            depends upon the type of the shape
	 * @return shape, object of the created shape
	 */
	public static Shape createShape(int id, ShapeType type, Point point, List<Double> parameters) {

		Shape shape = null;
		switch (type) {
		case RECTANGLE:
			shape = new Rectangle(id, type, point, parameters);
			break;
		case CIRCLE:
			shape = new Circle(id, type, point, parameters);
			break;

		case SQUARE:
			shape = new Square(id, type, point, parameters);
			break;

		case TRIANGLE:
			shape = new Triangle(id, type, point, parameters);
			break;

		default:
			throw new AssertionError(" Enter correct shape type !!");
		}
		return shape;
	}

}
