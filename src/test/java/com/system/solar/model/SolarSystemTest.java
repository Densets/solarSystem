package com.system.solar.model;

import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SolarSystemTest {

    @Test
    public void testRainyDay() {

	final Planet vulcanos = new Planet(1000, -5);
	final Planet betasoide = new Planet(2000, 3);
	final Planet ferenigi = new Planet(500, 1);

	final List<Planet> planets = new ArrayList<Planet>();
	planets.add(vulcanos);
	planets.add(betasoide);
	planets.add(ferenigi);
	final SolarSystem system = new SolarSystem(planets);

	final DayStadistics day = system.calculateDay(100);

	assertTrue(day.getDay().equals(100));
	assertTrue(day.getWeather().equals("RAINY"));

    }
    
    @Test
    public void testOtherDay() {

	final Planet vulcanos = new Planet(1000, -5);
	final Planet betasoide = new Planet(2000, 3);
	final Planet ferenigi = new Planet(500, 1);

	final List<Planet> planets = new ArrayList<Planet>();
	planets.add(vulcanos);
	planets.add(betasoide);
	planets.add(ferenigi);
	final SolarSystem system = new SolarSystem(planets);

	final DayStadistics day = system.calculateDay(200);

	assertTrue(day.getDay().equals(200));
	assertTrue(day.getWeather().equals("OTHER"));
    }

}
