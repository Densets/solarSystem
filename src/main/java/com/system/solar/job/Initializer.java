package com.system.solar.job;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.system.solar.model.DayStadistics;
import com.system.solar.model.Planet;
import com.system.solar.model.SolarSystem;
import com.system.solar.service.DayStadisticsService;

@Component
public class Initializer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Initializer.class);
    private static final Integer CENTURY = 3650;

    @Autowired
    private DayStadisticsService dayStadisticsService;

    @Scheduled(fixedDelay = Long.MAX_VALUE)
    public final void initializeData() {

	LOGGER.info("Database reset");

	dayStadisticsService.reset();

	LOGGER.info("Initialize planets");
	Planet vulcanos = new Planet(1000, -5);
	Planet betasoide = new Planet(2000, 3);
	Planet ferenigi = new Planet(500, 1);

	List<Planet> planets = new ArrayList<Planet>();
	planets.add(vulcanos);
	planets.add(betasoide);
	planets.add(ferenigi);
	SolarSystem system = new SolarSystem(planets);

	LOGGER.info("Calculate weather");
	for (int i = 0; i < CENTURY; i++) {
	    DayStadistics day = system.calculateDay(i);
	    dayStadisticsService.save(day);
	}

	LOGGER.info("Done");

    }
}
