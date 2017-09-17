package solarSystem;

import java.awt.Point;

public class Planet {

	private Integer distanceFromSun;
	private Integer velocity;

	Planet(Integer distanceFromSun, Integer velocity) {

		this.velocity = velocity;
		this.distanceFromSun = distanceFromSun;

	}

	public Point getPosition(Integer day) {

		int newPosition = (day * velocity )% 360;

		if (newPosition < 0) {
			newPosition = 360 + newPosition;
		}

		Point xy = new Point() ;
			double x=	(distanceFromSun * Math.cos(Math.toRadians(newPosition)));
 			double y= (distanceFromSun * Math.sin(Math.toRadians(newPosition)));
		xy.setLocation(x, y);
//		Point xy = new Point((int) (distanceFromSun * Math.cos(Math.toRadians(newPosition))),
//				(int) (distanceFromSun * Math.sin(Math.toRadians(newPosition))));

		return xy;
	}

	public Integer getDistanceFromSun() {
		return distanceFromSun;
	}

	public void setDistanceFromSun(Integer distanceFromSun) {
		this.distanceFromSun = distanceFromSun;
	}

	public Integer getVelocity() {
		return velocity;
	}

	public void setVelocity(Integer velocity) {
		this.velocity = velocity;
	}

}
