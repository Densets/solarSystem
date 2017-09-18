package com.system.solar.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.solar.model.DayStadistics;
import com.system.solar.repository.DayStadisticsRepository;

@Service
public class DayStadisticsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DayStadisticsService.class);

    @Autowired
    private DayStadisticsRepository dayStadisticsRepository;

    public DayStadistics getStats(final Integer day) {
	 if (day == null) {
	     return new DayStadistics();
	 }
	LOGGER.info("retriving day " + day);
	return dayStadisticsRepository.findByDay(day);
    }

    public void reset() {
	dayStadisticsRepository.deleteAll();
    }

    public void save(final DayStadistics dayStadistics) {
	dayStadisticsRepository.save(dayStadistics);
    }
}
