package com.system.solar.model;

import static org.junit.Assert.assertTrue;

import java.awt.Point;

import org.junit.Test;

public class PlanetTest {

    @Test
    public void testPlanet() {
	final Planet planet = new Planet(2000, 3);
	assertTrue(planet.getDistanceFromSun() == 2000);
    }

    @Test
    public void testPlanetPosition() {
	final Planet planet = new Planet(500, 1);

	assertTrue(planet.getPosition(0).equals(new Point(500, 0)));
    }
}
