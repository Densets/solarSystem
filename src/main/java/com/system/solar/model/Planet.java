package com.system.solar.model;

import java.awt.Point;

public class Planet {

    private Integer distanceFromSun;
    private Integer velocity;

    public Planet(final Integer distanceFromSun, final Integer velocity) {

	this.velocity = velocity;
	this.distanceFromSun = distanceFromSun;

    }

    public Point getPosition(final Integer day) {

	int newPosition = (day * velocity) % 360;

	if (newPosition < 0) {
	    newPosition = 360 + newPosition;
	}

	Point xy = new Point();
	double x = (distanceFromSun * Math.cos(Math.toRadians(newPosition)));
	double y = (distanceFromSun * Math.sin(Math.toRadians(newPosition)));
	xy.setLocation(x, y);

	return xy;
    }

    public Integer getDistanceFromSun() {
	return distanceFromSun;
    }

    public void setDistanceFromSun(final Integer distanceFromSun) {
	this.distanceFromSun = distanceFromSun;
    }

    public Integer getVelocity() {
	return velocity;
    }

    public void setVelocity(final Integer velocity) {
	this.velocity = velocity;
    }

}
