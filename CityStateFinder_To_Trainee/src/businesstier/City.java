package businesstier;

public class City {

	private String cityName;
	private long populationCount;

	
	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public long getPopulationCount() {
		return populationCount;
	}

	public void setPopulationCount(long populationCount) {
		this.populationCount = populationCount;
	}

	@Override
	public String toString() {
		return cityName ;
	}


}
