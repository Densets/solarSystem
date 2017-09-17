package com.system.solar.weather;

import java.awt.Point;

public interface WeatherCalculator {

    Boolean rainyDay(final Integer day, final Point a, final Point b, final Point c);

    Boolean dryDay(final Integer day, final Point a, final Point b, final Point c);

    Boolean optimalDay(final Integer day, final Point a, final Point b, final Point c);

}
