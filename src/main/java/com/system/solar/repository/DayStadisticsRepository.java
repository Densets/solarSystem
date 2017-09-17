package com.system.solar.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.system.solar.model.DayStadistics;

@Repository
public interface DayStadisticsRepository extends CrudRepository<DayStadistics, Integer> {

    DayStadistics findByDay(final Integer day);
}
