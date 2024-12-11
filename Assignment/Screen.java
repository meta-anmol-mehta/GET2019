import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Screen class is the main class through which a user will interact and checks
 * the validation of the input points and can perform operations such as create
 * shape, delete specific shape, display shape in the ascending order on the
 * basis of area, perimeter
 * 
 * @author Anmol mehta
 *
 */
public class Screen {

	private List<Shape> listOfShapes;
	private final double xMax;
	private final double yMax;
	private Set<Integer> shapeId;

	
	public Screen(double xMax, double yMax) {
		listOfShapes = new ArrayList<Shape>();
		shapeId = new HashSet<>();
		this.xMax = xMax;
		this.yMax = yMax;
	}

	/**
	 * Method to add shapes to the list if the user has entered correct
	 * coordinates and type of the shape
	 * 
	 * @param type
	 *            represents the type of the shape
	 * @param point
	 *            represents the origin point of the shape
	 * @param parameters
	 *            contains the list of parameters of the shape
	 * @return shapeObject, object of the shape created
	 * @throws Assertion error exception if invalid parameters are given as input
	 */
	Shape addShape(int id, ShapeType type, Point point, List<Double> parameters) {

		Shape shapeObject = null;

		if (!shapeId.contains(id)) {
			shapeId.add(id);
		} else {
			throw new AssertionError("Enter valid id");
		}

		switch (type) {
		case CIRCLE:

			// Check the validation of the input parameters

			double radius = parameters.get(0);
			double slope = Math.atan(point.getyCoord() / point.getxCoord());
			double centerDistance = Math
					.sqrt(point.getxCoord() * point.getxCoord() + point.getyCoord() * point.getyCoord()) + radius;
			double xCenter = centerDistance * Math.cos(slope);
			double yCenter = centerDistance * Math.sin(slope);
			if (point.getxCoord() >= 0 && point.getyCoord() >= 0 && (xCenter + radius) <= xMax
					&& (yCenter + radius <= yMax)) {

				break;
			} else {
				throw new AssertionError("Please enter correct coordinates!!");
			}

		case RECTANGLE:

			// Check the validation of the input parameters

			double length = parameters.get(0);
			double width = parameters.get(1);
			if (point.getxCoord() >= 0 && point.getyCoord() >= 0 && (point.getxCoord() + length <= xMax)
					&& (point.getyCoord() + width <= yMax)) {

				break;
			} else {
				throw new AssertionError("Please enter correct coordinates!!");
			}

		case SQUARE:

			// Check the validation of the input parameters

			double side = parameters.get(0);
			if (point.getxCoord() >= 0 && point.getyCoord() >= 0 && (point.getxCoord() + side <= xMax)
					&& (point.getyCoord() + side <= yMax)) {

				break;
			} else {
				throw new AssertionError("Please enter correct coordinates!!");
			}

		case TRIANGLE:

			// Check the validation of the input parameters

			double side1 = parameters.get(0);
			double side3 = parameters.get(2);
			double height = parameters.get(3);
			if (point.getxCoord() >= 0 && point.getyCoord() >= 0 && (point.getxCoord() + side1 <= xMax)
					&& (point.getxCoord() + Math.sqrt(side3 * side3 - height * height) <= xMax)
					&& (point.getyCoord() + height <= yMax)) {

				break;
			} else {
				throw new AssertionError("Please enter correct coordinates!!");
			}
		default:
			throw new AssertionError("Enter valid shape type");
		}
		shapeObject = Factory.createShape(id, type, point, parameters);
		listOfShapes.add(shapeObject);

		if (shapeObject != null) {
			return shapeObject;
		} else {
			throw new NullPointerException("Empty Shape Object!!");
		}
	}

	/**
	 * Method to delete a particular shape with the given id
	 * 
	 * @param type,
	 *            type of the shape
	 * @param shapeId,
	 *            unique id of the shape
	 * @return id of the deleted shape
	 * @throws Assertion error if id does not exists
	 */
	int deleteShape(ShapeType type, int shapeId) {

		int id = -1;
		System.out.println(shapeId);
		Iterator<Shape> iterator = listOfShapes.iterator();
		while (iterator.hasNext()) {
			Shape shape = iterator.next();
			if (shape.getType().equals(type) && shape.getId() == shapeId) {
				iterator.remove();
				id = shape.getId();
				break;
			}

		}
		if(id == -1){
			throw new AssertionError("Enter valid id of the shape");
		}
		return id;
	}

	/**
	 * Method to return the list of all shapes enclosing the given point
	 * 
	 * @param point,
	 *            input point for which to check
	 * @return shapesEnclosingPointList, list of all the shapes enclosing the
	 *         point
	 */
	List<Shape> getShapesEnclosingPoint(Point point) {
		List<Shape> shapesEnclosingPointList = new ArrayList<>();
		listOfShapes.forEach(shapeObject -> {
			if (shapeObject.isPointEnclosed(point)) {
				shapesEnclosingPointList.add(shapeObject);
			}
		});

		return shapesEnclosingPointList;
	}

	/**
	 * Function to delete all the shapes of a given particular shape type
	 * 
	 * @param type,
	 *            type of the shape to be deleted
	 * @return true if all the shape objects have been deleted else false
	 */
	boolean deleteAllShapeType(ShapeType type) {

		boolean status = false;
		Iterator<Shape> iterator = listOfShapes.iterator();
		while (iterator.hasNext()) {
			Shape shapeObject = iterator.next();
			if (shapeObject.getType().equals(type)) {
				iterator.remove();
				status = true;
			}
		}
		return status;
	}

	/**
	 * Function to sort the shapes object in the ascending order on the basis of
	 * their area
	 * 
	 * @return areaList, list in the sorted order
	 */
	public List<Shape> sortAccordingToArea() {
		List<Shape> areaList = new ArrayList<Shape>(listOfShapes);

		int size = areaList.size();
		for (int i = 0; i < size - 1; i++)
			for (int j = 0; j < size - i - 1; j++)
				if (areaList.get(j).getArea() > areaList.get(j + 1).getArea()) {
					Shape tempShape = areaList.get(j);
					areaList.set(j, areaList.get(j + 1));
					areaList.set(j + 1, tempShape);
				}
		return areaList;
	}

	/**
	 * Function to sort the shapes object in the ascending order on the basis of
	 * their perimeter
	 * 
	 * @return perimeterList, list in the sorted order
	 */
	public List<Shape> sortAccordingToPerimeter() {
		List<Shape> perimeterList = new ArrayList<Shape>(listOfShapes);

		int size = perimeterList.size();
		for (int i = 0; i < size - 1; i++)
			for (int j = 0; j < size - i - 1; j++)
				if (perimeterList.get(j).getPerimeter() > perimeterList.get(j + 1).getPerimeter()) {
					Shape tempShape = perimeterList.get(j);
					perimeterList.set(j, perimeterList.get(j + 1));
					perimeterList.set(j + 1, tempShape);
				}
		return perimeterList;
	}

	/**
	 * Function to sort the shapes object in the ascending order on the basis of
	 * their distance from the origin of the screen
	 * 
	 * @return distanceList, list in the sorted order
	 */
	public List<Shape> sortAccordingToDistance() {
		List<Shape> distanceList = new ArrayList<Shape>(listOfShapes);

		int size = distanceList.size();
		for (int i = 0; i < size - 1; i++)
			for (int j = 0; j < size - i - 1; j++)
				if (distanceList.get(j).getDistance() > distanceList.get(j + 1).getDistance()) {
					Shape tempShape = distanceList.get(j);
					distanceList.set(j, distanceList.get(j + 1));
					distanceList.set(j + 1, tempShape);
				}
		return distanceList;
	}

	/**
	 * Function to sort the shapes object in the ascending order on the basis of
	 * their created time
	 * 
	 * @return timeList, list in the sorted order
	 */
	public List<Shape> sortAccordingToTime() {
		List<Shape> timeList = new ArrayList<Shape>(listOfShapes);

		int size = timeList.size();
		for (int i = 0; i < size - 1; i++)
			for (int j = 0; j < size - i - 1; j++)
				if (timeList.get(j).getTimestamp().after(timeList.get(j + 1).getTimestamp())) {
					Shape tempShape = timeList.get(j);
					timeList.set(j, timeList.get(j + 1));
					timeList.set(j + 1, tempShape);
				}
		return timeList;
	}
}
