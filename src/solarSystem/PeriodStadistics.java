package solarSystem;

public class PeriodStadistics {

	private Integer dryDays = 0;
	private Integer rainyDays = 0;
	private Integer rainiestDay = 0;
	private Integer optimalDays = 0;
	private Integer otherDays = 0;

	public void addDryDay() {
		dryDays++;
	}

	public Integer getDryDays() {
		return dryDays;
	}

	public void addRainyDay() {
		rainyDays++;
	}

	public Integer getRainyDays() {
		return rainyDays;
	}

	public void setRainiestDay(Integer day) {
		rainiestDay = day;
	}

	public Integer getRainiestDay() {
		return rainiestDay;
	}

	public void addOptimalDay() {
		optimalDays++;
	}

	public Integer getOptimalDays() {
		return optimalDays;
	}

	public void addOtherDay() {
		otherDays++;
	}

	public Integer getOtherDays() {
		return otherDays;
	}

	@Override
	public String toString() {

		return "rainyDays=" + rainyDays + " dryDays=" + dryDays + " optimalDays=" + optimalDays + " normalDays="
				+ otherDays + " rainiest day=" + rainiestDay;
	}
}
