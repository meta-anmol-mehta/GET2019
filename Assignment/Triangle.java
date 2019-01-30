import java.util.Date;
import java.util.List;

public class Triangle implements Shape {

	private Point origin;
	private double side1;
	private double side2;
	private double side3;
	private double height;
	private final ShapeType type;
	private final Date timestamp;
	private int id;

	public Triangle(int id, ShapeType type, Point origin, List<Double> parameters) {
		this.origin = origin;
		side1 = parameters.get(0);
		side2 = parameters.get(1);
		side3 = parameters.get(2);
		height = parameters.get(3);
		this.type = type;
		this.timestamp = new Date();
		this.id = id;

	}

	@Override
	public double getArea() {
		double halfOfPerimeter = getPerimeter() / 2;
		double tempArea = halfOfPerimeter * (halfOfPerimeter - side1) * (halfOfPerimeter - side2)
				* (halfOfPerimeter - side3);
		return Math.sqrt(tempArea);
	}

	@Override
	public double getPerimeter() {

		return (side1 + side2 + side3);
	}

	@Override
	public Point getOrigin() {
		return origin;
	}

	private double getAreaByVertices(Point point1, Point point2, Point point3) {
		double area = Math.abs(point1.getxCoord() * (point2.getyCoord() - point3.getyCoord())
				+ point2.getxCoord() * (point3.getyCoord() - point1.getyCoord())
				+ point3.getxCoord() * (point1.getyCoord() - point2.getyCoord())) / 2;
		return area;
	}

	@Override
	public boolean isPointEnclosed(Point point) {

		double pointX1 = origin.getxCoord();
		double pointY1 = origin.getyCoord();
		double pointX2 = pointX1 + side1;
		double pointX3 = Math.sqrt(side3 * side3 - height * height) + pointX1;
		double pointY3 = pointY1 + height;

		Point point1 = new Point(pointX1, pointY1);
		Point point2 = new Point(pointX2, pointY1); // pointY2 is same as
													// pointY1
		Point point3 = new Point(pointX3, pointY3);
		double area1 = getAreaByVertices(point1, point2, point);
		double area2 = getAreaByVertices(point2, point, point3);
		double area3 = getAreaByVertices(point1, point3, point);

		double area = getArea();

		double summedArea = area1 + area2 + area3;
		if (area == summedArea) {
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
