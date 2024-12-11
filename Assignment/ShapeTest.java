import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ShapeTest {

	Screen screen = new Screen(100, 100);

	@Test
	public void testCreateShapeCircle() {

		Shape shape = screen.addShape(1, ShapeType.CIRCLE, new Point(3, 4), new ArrayList<Double>(Arrays.asList(5.0)));
		double area = shape.getArea();
		assertEquals(Math.PI * 5 * 5, area, 0);
	}
	
	@Test(expected = AssertionError.class)
	public void testCreateShapeCircleInvalidOrigin()  {

		Shape shape = screen.addShape(1, ShapeType.CIRCLE, new Point(-3, -4), new ArrayList<Double>(Arrays.asList(5.0)));
	}


	@Test
	public void testCreateShapeSquare() {
		Shape shape = screen.addShape(2, ShapeType.SQUARE, new Point(2, 1), new ArrayList<Double>(Arrays.asList(4.0)));
		double area = shape.getPerimeter();
		assertEquals(16, area, 0);
	}
	
	@Test(expected = AssertionError.class)
	public void testCreateShapeSquareInvalidCoordinates() {
		Shape shape = screen.addShape(2, ShapeType.SQUARE, new Point(2, 1), new ArrayList<Double>(Arrays.asList(140.0)));
	}

	@Test
	public void testCreateShapeRectangle() {
		Shape shape = screen.addShape(1, ShapeType.RECTANGLE, new Point(2.0, 2.0),
				new ArrayList<Double>(Arrays.asList(3.0, 4.0)));
		assertEquals(1, shape.getId());
	}
	

	@Test
	public void testCreateShapeTriangle() {

		Shape shape = screen.addShape(1, ShapeType.TRIANGLE, new Point(0, 0),
				new ArrayList<Double>(Arrays.asList(3.0, 4.0, 5.0, 5.0)));
		double area = shape.getArea();
		assertEquals(6, area, 0);
	}
	
	@Test(expected = AssertionError.class)
	public void testCreateShapeTriangleInvalidId()  {

		Shape shape1 = screen.addShape(1, ShapeType.TRIANGLE, new Point(0, 0),
				new ArrayList<Double>(Arrays.asList(3.0, 4.0, 5.0, 5.0)));
		Shape shape2 = screen.addShape(1, ShapeType.TRIANGLE, new Point(0, 0),
				new ArrayList<Double>(Arrays.asList(3.0, 4.0, 5.0, 5.0)));
	}

	@Test
	public void testDeleteAllShape() {

		Shape shape1 = screen.addShape(1, ShapeType.RECTANGLE, new Point(2, 1),
				new ArrayList<Double>(Arrays.asList(3.0, 4.0)));
		Shape shape2 = screen.addShape(2, ShapeType.RECTANGLE, new Point(3, 2),
				new ArrayList<Double>(Arrays.asList(3.0, 4.0)));
		Shape shape3 = screen.addShape(3, ShapeType.RECTANGLE, new Point(2, 2),
				new ArrayList<Double>(Arrays.asList(3.0, 4.0)));
		Shape shape4 = screen.addShape(4, ShapeType.SQUARE, new Point(2, 1), new ArrayList<Double>(Arrays.asList(4.0)));
		boolean result = screen.deleteAllShapeType(ShapeType.RECTANGLE);
		assertEquals(true, result);

	}

	@Test
	public void testDeleteShape(){

		Shape shape1 = screen.addShape(1, ShapeType.RECTANGLE, new Point(2, 1),
				new ArrayList<Double>(Arrays.asList(3.0, 4.0)));
		Shape shape2 = screen.addShape(2, ShapeType.RECTANGLE, new Point(3, 2),
				new ArrayList<Double>(Arrays.asList(3.0, 4.0)));
		Shape shape3 = screen.addShape(3, ShapeType.RECTANGLE, new Point(2, 2),
				new ArrayList<Double>(Arrays.asList(3.0, 4.0)));
		Shape shape4 = screen.addShape(4, ShapeType.SQUARE, new Point(2, 1), new ArrayList<Double>(Arrays.asList(4.0)));
		int result = screen.deleteShape(ShapeType.RECTANGLE, 3);
		assertEquals(3, result);
	}
	

	@Test(expected = AssertionError.class)
	public void testDeleteShapeInvalidId()  {

		Shape shape1 = screen.addShape(1, ShapeType.RECTANGLE, new Point(2, 1),
				new ArrayList<Double>(Arrays.asList(3.0, 4.0)));
		Shape shape2 = screen.addShape(2, ShapeType.RECTANGLE, new Point(3, 2),
				new ArrayList<Double>(Arrays.asList(3.0, 4.0)));
		Shape shape3 = screen.addShape(3, ShapeType.RECTANGLE, new Point(2, 2),
				new ArrayList<Double>(Arrays.asList(3.0, 4.0)));
		Shape shape4 = screen.addShape(4, ShapeType.SQUARE, new Point(2, 1), new ArrayList<Double>(Arrays.asList(4.0)));
		int result = screen.deleteShape(ShapeType.RECTANGLE, 4);
	}

	@Test
	public void testSortByArea()  {

		ShapeType type1 = ShapeType.CIRCLE;
		Point point1 = new Point(1, 1);
		List<Double> parameters1 = new ArrayList<Double>(Arrays.asList(1.0));
		Shape shape1 = screen.addShape(1, type1, point1, parameters1);

		ShapeType type2 = ShapeType.CIRCLE;
		Point point2 = new Point(1, 1);
		List<Double> parameters2 = new ArrayList<Double>(Arrays.asList(2.0));
		Shape shape2 = screen.addShape(2, type2, point2, parameters2);

		List<Shape> expectedresult = new ArrayList<Shape>(Arrays.asList(shape1, shape2));
		List<Shape> actualresult = new ArrayList<Shape>();
		actualresult = screen.sortAccordingToArea();
		assertEquals(expectedresult, actualresult);
	}

	@Test
	public void testSortByDistance()  {

		ShapeType type1 = ShapeType.CIRCLE;
		Point point1 = new Point(1, 1);
		List<Double> parameters1 = new ArrayList<Double>(Arrays.asList(1.0));
		Shape shape1 = screen.addShape(1, type1, point1, parameters1);

		ShapeType type2 = ShapeType.CIRCLE;
		Point point2 = new Point(2, 2);
		List<Double> parameters2 = new ArrayList<Double>(Arrays.asList(2.0));
		Shape shape2 = screen.addShape(2, type2, point2, parameters2);

		List<Shape> expectedresult = new ArrayList<Shape>(Arrays.asList(shape1, shape2));
		List<Shape> actualresult = new ArrayList<Shape>();
		actualresult = screen.sortAccordingToDistance();
		assertEquals(expectedresult, actualresult);
	}

	@Test
	public void testSortByPerimeter()  {

		ShapeType type1 = ShapeType.CIRCLE;
		Point point1 = new Point(1, 1);
		List<Double> parameters1 = new ArrayList<Double>(Arrays.asList(1.0));
		Shape shape1 = screen.addShape(1, type1, point1, parameters1);

		ShapeType type2 = ShapeType.CIRCLE;
		Point point2 = new Point(1, 1);
		List<Double> parameters2 = new ArrayList<Double>(Arrays.asList(2.0));
		Shape shape2 = screen.addShape(2, type2, point2, parameters2);

		List<Shape> expectedresult = new ArrayList<Shape>(Arrays.asList(shape1, shape2));
		List<Shape> actualresult = new ArrayList<Shape>();
		actualresult = screen.sortAccordingToPerimeter();
		assertEquals(expectedresult, actualresult);
	}

	@Test
	public void testSortByTimestamp()  {

		ShapeType type1 = ShapeType.CIRCLE;
		Point point1 = new Point(1, 1);
		List<Double> parameters1 = new ArrayList<Double>(Arrays.asList(1.0));
		Shape shape1 = screen.addShape(1, type1, point1, parameters1);

		ShapeType type2 = ShapeType.CIRCLE;
		Point point2 = new Point(1, 1);
		List<Double> parameters2 = new ArrayList<Double>(Arrays.asList(2.0));
		Shape shape2 = screen.addShape(2, type2, point2, parameters2);

		List<Shape> expectedresult = new ArrayList<Shape>(Arrays.asList(shape1, shape2));
		List<Shape> actualresult = new ArrayList<Shape>();
		actualresult = screen.sortAccordingToTime();
		assertEquals(expectedresult, actualresult);
	}
	
	@Test
	public void testShapesEnclosingPoint()  {

	Shape shape1 = screen.addShape(1,ShapeType.RECTANGLE, new Point(50, 50),
			new ArrayList<Double>(Arrays.asList(6.0, 4.0)));
	System.out.println(shape1.getId());
	Shape shape2 = screen.addShape(2,ShapeType.RECTANGLE, new Point(5, 5),
			new ArrayList<Double>(Arrays.asList(10.0, 14.0)));
	System.out.println(shape2.getId());
	Shape shape3 = screen.addShape(3,ShapeType.RECTANGLE, new Point(2, 2),
			new ArrayList<Double>(Arrays.asList(3.0, 4.0)));
	System.out.println(shape3.getId());
	Shape shape4 = screen.addShape(4,ShapeType.SQUARE, new Point(10, 10),
			new ArrayList<Double>(Arrays.asList(4.0)));
	List<Shape> actualResult = new ArrayList<Shape>();
	actualResult = screen.getShapesEnclosingPoint(new Point(3.0, 4.0));
	List<Shape> expectedResult = new ArrayList<Shape>(Arrays.asList(shape3, shape4));
	assertEquals(expectedResult, actualResult);
	}

}