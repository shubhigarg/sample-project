package businesstier;


import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Validator {
	 
	//private List<City> cities2;

	public void validate(State state) throws ForwardException {
		City c = new City();
		isValidStateName(state.getStateName());
		isValidFormationDate(state.getFormationDate());
		isDuplicateCityEntry(c.getCityName(),state.getListOfCities());
	}

	public boolean isValidFormationDate(Date date) throws ForwardException {
	
		if (date.compareTo(new Date()) <= 0) {
			return true;
		}
			else
			throw new ForwardException("Validator.INVALID_FORMATION_DATE");
	}

	public boolean isValidStateName(String stateName) throws ForwardException {
		
		if (stateName.matches("[a-zA-Z\\s]*") && Character.isUpperCase(stateName.charAt(0))) {
			return true;
		}
		else
			throw new ForwardException("Validator.INVALID_STATE_NAME");
	}

	public boolean isDuplicateCityEntry(String cityName, List<City> cities) throws ForwardException {
		
		for (int i = 0; i < cities.size(); i++) {
			for (int j = i+1; j < cities.size(); j++) {
				String str1=cities.get(i).toString();
				String str2=cities.get(j).toString();
		
    			if(str1.equalsIgnoreCase(str2)){
					throw new ForwardException("Validator.DUPLICATE_CITY_NAME");
				}
			}
		}
		return true;
	}

}
