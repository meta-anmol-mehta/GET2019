import java.util.Date;
import java.util.List;

public class Circle implements Shape {

	private final Point origin;
	private final double radius;
	private final ShapeType type;
	private final Date timestamp;
	private int id;

	public Circle(int id, ShapeType type, Point origin, List<Double> parameters) {
		this.type = type;
		this.origin = origin;
		this.radius = parameters.get(0);
		this.timestamp = new Date();
		this.id = id;
	}

	@Override
	public double getArea() {

		return (Math.PI) * radius * radius;
	}

	@Override
	public double getPerimeter() {

		return 2 * Math.PI * radius;
	}

	@Override
	public Point getOrigin() {

		return origin;
	}

	private Point getCenter() {

		double slope = Math.atan(origin.getyCoord() / origin.getxCoord());

		double distOfOrigin = Math
				.sqrt(origin.getyCoord() * origin.getyCoord() + origin.getxCoord() * origin.getxCoord());

		double distOfCenter = radius + distOfOrigin;

		double xCoord = distOfCenter * Math.cos(slope);
		double yCoord = distOfCenter * Math.sin(slope);
		Point center = new Point(xCoord, yCoord);

		return center;
	}

	@Override
	public boolean isPointEnclosed(Point point) {

		Point center = getCenter();
		double xCenter = center.getxCoord();
		double yCenter = center.getyCoord();

		double pointX = point.getxCoord();
		double pointY = point.getyCoord();

		if (Math.sqrt((pointY - yCenter) * (pointY - yCenter) + (pointX - xCenter) * (pointX - xCenter)) < radius) {
			return true;
		}
		return false;
	}

	@Override
	public double getDistance() {
		double dist = origin.getxCoord() * origin.getxCoord() + origin.getyCoord() * origin.getyCoord();
		return Math.sqrt(dist);
	}

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
