/**
 * This class coontains the information of a point such as its x and
 * y-coordinates
 * 
 * @author Anmol mehta
 *
 */
public class Point {

	private double xCoord;
	private double yCoord;

	Point(double xCoord, double yCoord) {
		this.xCoord = xCoord;
		this.yCoord = yCoord;
	}

	public double getxCoord() {
		return xCoord;
	}

	public double getyCoord() {
		return yCoord;
	}

}
