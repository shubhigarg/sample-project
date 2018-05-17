package persistencetier;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;

import businesstier.City;
import businesstier.State;

public class CityStateFinderService {

	final static Logger logger = Logger.getLogger(CityStateFinderService.class);

	public String appendStateDetails(State state) {
		String stateDetails = null;
		File file = null;
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter=null;
		stateDetails = ";"+state.getStateName()
				+ ";"
				+ ""
				+ utility.Util.getInstance().convertDateToString(
						state.getFormationDate()) + ";" + ""
				+ state.getCapitalCity() + ";" + ""
				+ state.getChiefMinisterName()+";";

		String cityDetails = "";
		for (City city : state.getListOfCities()) {
			cityDetails = cityDetails + city.getCityName() + ":"
					+ city.getPopulationCount()+"," ;
		}
		stateDetails = stateDetails + cityDetails;
		try {
			file = new File("StateCityDetails.txt");
			fileWriter = new FileWriter(file,true);
			bufferedWriter=new BufferedWriter(fileWriter);
			fileWriter.write(stateDetails.substring(0, stateDetails.length()-1));
			

		} catch (IOException e) {
			logger.debug(e.toString());
		} finally {

			try {
				if(null!=bufferedWriter)
				 bufferedWriter.close();	
				if (null != fileWriter)
					fileWriter.close();
			} catch (IOException e) {
				logger.debug(e.toString());
			}
		}

		return "success";
	}

	public List<State> getStatesDetails() {

		List<State> listOfStates = null;
		File file = null;
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;

		try {
			file = new File("StateCityDetails.txt");
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			String stateDetails = bufferedReader.readLine();
			listOfStates = new ArrayList<State>();
			while (null != stateDetails) {
				StringTokenizer stateDetailsTokens = new StringTokenizer(
						stateDetails, ";");
				while (stateDetailsTokens.hasMoreTokens()) {
					State state = new State();
					state.setStateName(stateDetailsTokens.nextToken());
					state.setFormationDate(utility.Util
							.getInstance()
							.convertStringToDate(stateDetailsTokens.nextToken()));
					state.setCapitalCity(stateDetailsTokens.nextToken());
					state.setChiefMinisterName(stateDetailsTokens.nextToken());
					String cityDetails = stateDetailsTokens.nextToken();
					List<City> cities = new ArrayList<City>();
					StringTokenizer cityDetailsTokens = new StringTokenizer(
							cityDetails, ",");
					while (cityDetailsTokens.hasMoreTokens()) {
						StringTokenizer cityPopulation = new StringTokenizer(
								cityDetailsTokens.nextToken(), ":");
						while (cityPopulation.hasMoreTokens()) {
							City city = new City();
							city.setCityName(cityPopulation.nextToken());
							city.setPopulationCount(Long
									.parseLong(cityPopulation.nextToken()));
							
							cities.add(city);
						}
					}
					state.setListOfCities(cities);
					listOfStates.add(state);
				}
				stateDetails = bufferedReader.readLine();
			}

		} catch (FileNotFoundException e) {
			logger.debug(e.toString());

		} catch (IOException e) {
			logger.debug(e.toString());
		} finally {

			try {
				if (null != fileReader)
					fileReader.close();
				if (null != bufferedReader)
					bufferedReader.close();
			} catch (IOException e) {
				logger.debug(e.toString());
			}
		}

		return listOfStates;
	}

}
