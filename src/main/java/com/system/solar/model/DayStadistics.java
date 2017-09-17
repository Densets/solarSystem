package com.system.solar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "WEATHER")
public class DayStadistics {

    @JsonIgnore
    private Integer id;
    private Integer day;
    private String weather;

    @Column(name = "day", nullable = false)
    public Integer getDay() {
	return day;
    }

    public void setDay(final Integer day) {
	this.day = day;
    }

    public String getWeather() {
	return weather;
    }

    public void setWeather(final String weather) {
	this.weather = weather;
    }

    @Id
    @GeneratedValue
    public Integer getId() {
	return id;
    }

    public void setId(final Integer id) {
	this.id = id;
    }

}
