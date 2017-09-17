package com.system.solar.model;

import java.awt.Point;
import java.util.List;

import com.system.solar.weather.WeatherCalculator;

public class SolarSystem implements WeatherCalculator {

    private List<Planet> planets;

    public SolarSystem(final List<Planet> planets) {
	this.setPlanets(planets);
    }

    public PeriodStadistics calculateWeather(final Integer period) {
	// calculator = new WeatherCalculatorImpl();
	PeriodStadistics stats = new PeriodStadistics();
	Integer tempPerimeter = 0;
	Integer longestPerimeter = 0;

	for (int i = 0; i < period; i++) {
	    Point a = planets.get(0).getPosition(i);
	    Point b = planets.get(1).getPosition(i);
	    Point c = planets.get(2).getPosition(i);

	    if (dryDay(i, a, b, c)) {
		stats.addDryDay();
	    } else if (rainyDay(i, a, b, c)) {
		stats.addRainyDay();
		tempPerimeter = getPerimeter(a, b, c);
		if (longestPerimeter < tempPerimeter) {
		    longestPerimeter = tempPerimeter;
		    stats.setRainiestDay(i);
		}
	    } else if (optimalDay(i, a, b, c)) {
		stats.addOptimalDay();
	    } else {
		stats.addOtherDay();
	    }
	}
	return stats;
    }

    private Integer getPerimeter(final Point planet, final Point planet2, final Point planet3) {
	return (int) (planet.distance(planet2) + planet2.distance(planet3) + planet3.distance(planet));
    }

    public DayStadistics calculateDay(final Integer day) {
	DayStadistics stats = new DayStadistics();
	stats.setDay(day);
	Point a = planets.get(0).getPosition(day);
	Point b = planets.get(1).getPosition(day);
	Point c = planets.get(2).getPosition(day);
	if (rainyDay(day, a, b, c)) {
	    stats.setWeather("RAINY");
	} else if (dryDay(day, a, b, c)) {
	    stats.setWeather("DRY");
	} else if (optimalDay(day, a, b, c)) {
	    stats.setWeather("OPTIMAL");
	} else {
	    stats.setWeather("OTHER");
	}
	return stats;
    }

    public List<Planet> getPlanets() {
	return planets;
    }

    public void setPlanets(final List<Planet> planets) {
	this.planets = planets;
    }

    private Boolean pointsAling(final Point a, final Point b, final Point c) {
	return ((b.getY() - a.getY()) * (c.getX() - b.getX())) == ((c.getY() - b.getY()) * (b.getX() - a.getX()));

    }

    @Override
    public Boolean dryDay(final Integer day, final Point a, final Point b, final Point c) {
	if (pointsAling(a, b, c)) {
	    return pointsAling(new Point(0, 0), b, c);
	}
	return false;
    }

    @Override
    public Boolean rainyDay(final Integer day, final Point a, final Point b, final Point c) {
	int asX = 0 - a.x;
	int asY = 0 - a.y;
	Boolean sAB = (b.x - a.x) * asY - (b.y - a.y) * asX > 0;
	if ((c.x - a.x) * asY - (c.y - a.y) * asX > 0 == sAB) {

	    return false;
	}
	if ((c.x - b.x) * (0 - b.y) - (c.y - b.y) * (0 - b.x) > 0 != sAB) {

	    return false;
	}
	return true;

    }

    @Override
    public Boolean optimalDay(final Integer day, final Point a, final Point b, final Point c) {
	if (pointsAling(a, b, c)) {
	    return !pointsAling(new Point(1, 1), b, c);
	}
	return false;
    }

}
