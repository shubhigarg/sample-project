package presentationtier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import businesstier.City;
import businesstier.CityStateFinderManager;
import businesstier.ForwardException;
import businesstier.State;

public class CityStateFinderTester {

	final static Logger logger = Logger.getLogger(CityStateFinderTester.class);

	public static void main(String args[]) {

		//while (true) {
			BufferedReader bufferedReader=null;
			try {
				System.out.println("1. Add States");
				System.out.println("2. Get State Details ");

				 bufferedReader = new BufferedReader(
						new InputStreamReader(System.in));
				System.out.println("Enter your choice : ");
				int choice = Integer.parseInt(bufferedReader.readLine());

				switch (choice) {
				case 1:
					State state = new State();
					System.out.println("Enter the name of the state  : ");
					state.setStateName(bufferedReader.readLine());
					System.out
							.println("Enter formation date of the state (dd-MM-yyyy) ");
					state.setFormationDate(utility.Util.getInstance()
							.convertStringToDate(bufferedReader.readLine()));
					System.out.println("Enter the capital city  : ");
					state.setCapitalCity(bufferedReader.readLine());
					System.out.println("Enter the chief minister name : ");
					state.setChiefMinisterName(bufferedReader.readLine());

					System.out
							.println("Enter number of cities you want to enter : ");
					int count = Integer.parseInt(bufferedReader.readLine());

					ArrayList<City> cities = new ArrayList<City>();
					for (int i = 1; i <= count; i++) {
						City city = new City();
						System.out.println("Enter name of the city : ");
						city.setCityName(bufferedReader.readLine());
						System.out
								.println("Enter the population count of the city : ");
						city.setPopulationCount(Long.parseLong(bufferedReader
								.readLine()));
						cities.add(city);
					}
					state.setListOfCities(cities);
					String message = new CityStateFinderManager()
							.addStateDetails(state);
					System.out.println(message);
					break;
				case 2:
					System.out.println("Enter formation date of the state (dd-MM-yyyy) ");
					List<State> states = new CityStateFinderManager()
							.getStateDetails(utility.Util.getInstance()
									.convertStringToDate(
											bufferedReader.readLine()));
					for (State s : states) {
						System.out.println(s.getStateName()
								+ "\t"
								+ utility.Util.getInstance()
										.convertDateToString(
												s.getFormationDate()) + "\t"
								+ s.getCapitalCity() + "\t"
								+ s.getChiefMinisterName());

						System.out.println("Cities : ");
						for (City city : s.getListOfCities()) {
							System.out.println(city.getCityName() + "\t"
									+ city.getPopulationCount());
						}
					}

					break;
				default:
					System.out.println("Invalid Option !!! ");
					System.exit(0);
				}

			} catch (IOException e) {
				logger.debug(e.toString());
			} catch (ForwardException e) {
				logger.debug(e.toString());
				System.out.println(utility.Util.getInstance().readKeyValue(
						e.toString()));
			}
			finally{
				try {
					if(null!=bufferedReader)
					bufferedReader.close();
				} catch (IOException e) {
					logger.debug(e.toString());
					System.out.println(utility.Util.getInstance().readKeyValue(
							e.toString()));
				}
			}
		}

	//}

}
