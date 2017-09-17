package solarSystem;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		Planet Vulcanos = new Planet(1000, -5);
		Planet Betasoide = new Planet(2000, 3);
		Planet Ferenigi = new Planet(500, 1);

		List<Planet> planets = new ArrayList<Planet>();
		planets.add(Vulcanos);
		planets.add(Betasoide);
		planets.add(Ferenigi);
		SolarSystem system = new SolarSystem(planets);

		PeriodStadistics period = system.calculateWeather(365*10);
		DayStadistics day = system.calculateDay(100);
		System.out.println(period);
		
	}

}
