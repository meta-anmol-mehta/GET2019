import java.util.Date;
import java.util.List;

/**
 * This class extends Shape class and implements functions such as getArea(), getPerimeter(),
 * getOrigin(), isPointEnclosed() for rectangular shape
 * @author Anmol mehta
 *
 */
public class Rectangle implements Shape {

	private Point origin;
	private double length;
	private double width;
	private final ShapeType type;
	private final Date timestamp;
	private int id;

	public Rectangle(int id, ShapeType type, Point origin, List<Double> parameters) {
		this.origin = origin;
		this.length = parameters.get(0);
		this.width = parameters.get(1);
		this.type = type;
		this.timestamp = new Date();
		this.id = id;
	}

	@Override
	public double getArea() {

		return length * width;
	}

	@Override
	public double getPerimeter() {

		return (2 * length * width);
	}

	@Override
	public Point getOrigin() {

		return origin;
	}

	@Override
	public boolean isPointEnclosed(Point point) {

		if (point.getxCoord() >= origin.getxCoord() && point.getyCoord() >= origin.getyCoord()
				&& point.getxCoord() < origin.getxCoord() + length
				&& point.getyCoord() < origin.getyCoord() + width) {
			return true;
		}

		return false;
	}

	@Override
	public double getDistance() {
		double dist = origin.getxCoord() * origin.getxCoord()
				+ origin.getyCoord() * origin.getyCoord();
		return Math.sqrt(dist);
	}
	

	@Override
	public Date getTimestamp() {
		return new Date(timestamp.getTime());
	}

	@Override
	public ShapeType getType() {
		return type;
	}

	@Override
	public int getId() {
		return id;
	}
}
