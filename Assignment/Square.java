import java.util.Date;
import java.util.List;

public class Square implements Shape {

	private Point origin;
	private double side;
	private final ShapeType type;
	private final Date timestamp;
	private int id;

	public Square(int id, ShapeType type, Point origin, List<Double> parameters) {
		this.origin = origin;
		this.side = parameters.get(0);
		this.type = type;
		this.timestamp = new Date();
		this.id = id;
	}

	@Override
	public double getArea() {

		return (side * side);
	}

	@Override
	public double getPerimeter() {

		return (4 * side);
	}

	@Override
	public Point getOrigin() {

		return origin;
	}

	@Override
	public boolean isPointEnclosed(Point point) {

		if (point.getxCoord() >= 0 && point.getyCoord() >= 0 && point.getxCoord() < origin.getxCoord() + side
				&& point.getyCoord() < origin.getyCoord() + side) {
			return true;
		}
		return false;
	}

	@Override
	public double getDistance() {
		double dist = origin.getxCoord() * origin.getxCoord() + origin.getyCoord() * origin.getyCoord();
		return Math.sqrt(dist);
	}

	@Override
	public ShapeType getType() {
		return type;
	}

	@Override
	public Date getTimestamp() {
		return new Date(timestamp.getTime());
	}

	@Override
	public int getId() {
		return id;
	}

}
