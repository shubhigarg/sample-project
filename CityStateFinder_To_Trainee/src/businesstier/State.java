package businesstier;

import java.util.Date;
import java.util.List;

public class State {

	private String stateName;
	private Date formationDate;
	private String capitalCity;
	private List<City> listOfCities;
	private String chiefMinisterName;

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public List<City> getListOfCities() {
		return listOfCities;
	}

	public void setListOfCities(List<City> listOfCities) {
		this.listOfCities = listOfCities;
	}

	public Date getFormationDate() {
		return formationDate;
	}

	public void setFormationDate(Date formationDate) {
		this.formationDate = formationDate;
	}

	public String getCapitalCity() {
		return capitalCity;
	}

	public void setCapitalCity(String capitalCity) {
		this.capitalCity = capitalCity;
	}

	public String getChiefMinisterName() {
		return chiefMinisterName;
	}

	public void setChiefMinisterName(String chiefMinisterName) {
		this.chiefMinisterName = chiefMinisterName;
	}
	
}
