package solarSystem;

import java.awt.Point;

public interface WeatherCalculator {

	public Boolean rainyDay(Integer day, Point a, Point b, Point c);

	public Boolean dryDay(Integer day, Point a, Point b, Point c);

	public Boolean optimalDay(Integer day, Point a, Point b, Point c);

}
