package com.system.solar;

import java.util.ArrayList;
import java.util.List;

import com.system.solar.model.DayStadistics;
import com.system.solar.model.PeriodStadistics;
import com.system.solar.model.Planet;
import com.system.solar.model.SolarSystem;

public class Main {

    public static void main(final String[] args) {

	Planet vulcanos = new Planet(1000, -5);
	Planet betasoide = new Planet(2000, 3);
	Planet ferenigi = new Planet(500, 1);

	List<Planet> planets = new ArrayList<Planet>();
	planets.add(vulcanos);
	planets.add(betasoide);
	planets.add(ferenigi);
	SolarSystem system = new SolarSystem(planets);

	PeriodStadistics period = system.calculateWeather(365 * 10);
	DayStadistics day = system.calculateDay(100);
	System.out.println(period);
	System.out.println(day);

    }

}
