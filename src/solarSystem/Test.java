package solarSystem;

import java.awt.Point;
import java.awt.geom.Point2D;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int f=5*9%360;
//		int f=0;
		if(f<0) {
			f=360+ f ;
		} 
//        int e =  Math.abs(d % 360);
//        int f =360+ d % 360;

//        System.out.println(e);
//        System.out.println(f);

        
        int day =100;
        int velocity = 1;
        int distanceFromSun =500;
        
		int newPosition = day * velocity % 360;

		if (newPosition < 0) {
			newPosition = 360 + newPosition;
		}

		Point xy = new Point((int) (distanceFromSun * Math.cos(Math.toRadians(newPosition))),
				(int) (distanceFromSun * Math.sin(Math.toRadians(newPosition))));
		Point doublePoint = new Point();
		doublePoint.setLocation(distanceFromSun * Math.cos(Math.toRadians(newPosition)), distanceFromSun * Math.sin(Math.toRadians(newPosition)));
		System.out.println(distanceFromSun * Math.cos(Math.toRadians(newPosition)));
		System.out.println(distanceFromSun * Math.sin(Math.toRadians(newPosition)));
		
		System.out.println(doublePoint.distance(new Point()));

	}

}
