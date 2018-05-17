package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.Logger;

public class Util {

	private static Util converter = new Util();
	final static Logger logger = Logger.getLogger(Util.class);
	private Util() {

	}

	public static Util getInstance() {
		return converter;
	}

	public Date convertStringToDate(String dateInString) {
		Date date = null;
		DateFormat dateFormat = null;
		try {
			dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			date = dateFormat.parse(dateInString);
		} catch (ParseException e) {
			logger.debug(e.toString());
		}
		return date;
	}

	public String convertDateToString(Date date) {
		String dateInString = null;
		DateFormat dateFormat = null;
		dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateInString = dateFormat.format(date);
		return dateInString;
	}

	public  String readKeyValue(String key) {

		String value = null;
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream(new File(
					"configuration.properties")));
			value = properties.getProperty(key);

		} catch (FileNotFoundException e) {
			logger.debug(e.toString());
		} catch (IOException e) {
			logger.debug(e.toString());
		}
		return value;
	}
}
