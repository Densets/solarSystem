package solarSystem;

import java.awt.Point;
import java.util.List;

public class SolarSystem implements WeatherCalculator {

	private List<Planet> planets;

	SolarSystem(List<Planet> planets) {
		this.setPlanets(planets);
	}

	public PeriodStadistics calculateWeather(Integer period) {

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

	private Integer getPerimeter(Point planet, Point planet2, Point planet3) {
		return (int) (planet.distance(planet2) + planet2.distance(planet3) + planet3.distance(planet));
	}

	public DayStadistics calculateDay(Integer day) {
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

	public void setPlanets(List<Planet> planets) {
		this.planets = planets;
	}

	private Boolean pointsAling(Point a, Point b, Point c) {
		return ((b.getY() - a.getY()) * (c.getX() - b.getX())) == ((c.getY() - b.getY()) * (b.getX() - a.getX()));

	}

	@Override
	public Boolean dryDay(Integer day, Point a, Point b, Point c) {
		if (pointsAling(a, b, c)) {
			return pointsAling(new Point(0, 0), b, c);
		}
		return false;
	}

	@Override
	public Boolean rainyDay(Integer day, Point a, Point b, Point c) {
		int as_x = 0 - a.x;
		int as_y = 0 - a.y;
		Boolean s_ab = (b.x - a.x) * as_y - (b.y - a.y) * as_x > 0;
		if ((c.x - a.x) * as_y - (c.y - a.y) * as_x > 0 == s_ab)
			return false;
		if ((c.x - b.x) * (0 - b.y) - (c.y - b.y) * (0 - b.x) > 0 != s_ab)
			return false;
		return true;

	}

	@Override
	public Boolean optimalDay(Integer day, Point a, Point b, Point c) {
		if (pointsAling(a, b, c)) {
			return !pointsAling(new Point(1, 1), b, c);
		}
		return false;
	}
}
