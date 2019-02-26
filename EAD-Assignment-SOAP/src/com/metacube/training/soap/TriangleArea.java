package com.metacube.training.soap;

public class TriangleArea{

	public String area(String side1,String side2,String side3){
		
		if((side1 != null && side1.matches("[0-9]+"))||(side2 != null && side2.matches("[0-9]+"))||(side3 != null && side3.matches("[0-9]+"))){
			return "enter valid positive side.";
		}
		else{
			Double parseSide1=Double.parseDouble(side1);
			Double parseSide2=Double.parseDouble(side2);
			Double parseSide3=Double.parseDouble(side3);
			double perimeter=(parseSide1+parseSide2+parseSide3)/2;
			double result=Math.sqrt((perimeter)*(perimeter-parseSide1)*(perimeter-parseSide2)*(perimeter-parseSide3));
			return String.valueOf(result);
		}
	}
}
