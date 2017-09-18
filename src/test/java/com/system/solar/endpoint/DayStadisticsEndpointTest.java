package com.system.solar.endpoint;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.system.solar.model.DayStadistics;
import com.system.solar.service.DayStadisticsService;

@RunWith(MockitoJUnitRunner.class)
 public class DayStadisticsEndpointTest {

    @Mock
    private DayStadisticsService dayStadisticsService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testForNullDay() {
        when(dayStadisticsService.getStats(10000)).thenReturn(null);
        assertNull(dayStadisticsService.getStats(10000));
    }

    @Test
    public void testForRealDay() {
        when(dayStadisticsService.getStats(10)).thenReturn(new DayStadistics());
        assertNotNull(dayStadisticsService.getStats(10));
    }
 
}
