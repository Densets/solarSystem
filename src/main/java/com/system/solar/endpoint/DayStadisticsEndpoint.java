package com.system.solar.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.system.solar.model.DayStadistics;
import com.system.solar.service.DayStadisticsService;

@RestController
public class DayStadisticsEndpoint {

    @Autowired
    private DayStadisticsService dayStadisticsService;

    @RequestMapping("/weather")
    public final DayStadistics climaParaDia(@RequestParam final Integer day) {
	return dayStadisticsService.getStats(day);
    }

}
