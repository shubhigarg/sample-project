package businesstier;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import persistencetier.CityStateFinderService;

public class CityStateFinderManager {
	
	public String addStateDetails(State state) throws ForwardException{
		Validator vn = new Validator();
		vn.validate(state);
		return "Add recorded successfully";
	}

	public List<State> getStateDetails(Date formationDate)throws ForwardException {
		List<State> filteredList = new ArrayList<State>();
		boolean status=new Validator().isValidFormationDate(formationDate);
		if(status){
			List<State>  states = new CityStateFinderService().getStatesDetails();
			for(State state:states){
				if(state.getFormationDate().compareTo(formationDate)==0)
					filteredList.add(state);
			}
			if(!filteredList.isEmpty())
				return filteredList;
			else
				throw new ForwardException("CityStateFinder.NO_RECORDS_FOUND");
		}
		else		
		throw new ForwardException("CityStateFinder.NO_RECORDS_FOUND");

	}

}
