package com.metacube.training.soap;

public class TriangleArea{

	public double area(double side1,double side2,double side3){
		double perimeter=(side1+side2+side3)/2;
		double result=Math.sqrt((perimeter)*(perimeter-side1)*(perimeter-side2)*(perimeter-side3));
		return result;
	}
}