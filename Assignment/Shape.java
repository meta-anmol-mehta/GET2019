import java.util.Date;

/**
 * Interface Shape containing declarations of methods getArea(), getPerimeter(),
 * getOrigin(), isPointEnclosed(), getTimestamp() etc
 * 
 * @author Richa Jain
 *
 */
public interface Shape {
	/**
	 * Method to calculate the area enclosed by the shape
	 * 
	 * @return area, enclosed by the shape
	 */
	public double getArea();

	/**
	 * Method to calculate the perimeter of the shape
	 * 
	 * @return perimeter of the shape
	 */
	public double getPerimeter();

	/**
	 * Method to return the origin of the shape i.e., the leftmost point of the
	 * shape
	 * 
	 * @return origin, coordinates of the leftmost point
	 */
	public Point getOrigin();

	/**
	 * Method to find if a point is enclosed by the shape or not
	 * 
	 * @param point,
	 *            point for which to check
	 * @return true if the given point lies inside the shape else false
	 */
	public boolean isPointEnclosed(Point point);

	/**
	 * Method to return the type of the shape such as rectangle, square etc
	 * 
	 * @return type of the shape
	 */
	public ShapeType getType();

	/**
	 * Method to return the unique id of the object
	 * 
	 * @return id of the object
	 */
	public int getId();

	/**
	 * Method to return the timestamp of the object created
	 * 
	 * @return the copy of the date object
	 */
	public Date getTimestamp();

	/**
	 * Method to calculate the distance between the origin of the screen and
	 * origin of the shape
	 * 
	 * @return distance between the two points
	 */
	public double getDistance();

}
