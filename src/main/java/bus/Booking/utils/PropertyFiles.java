package bus.Booking.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFiles {
	
	public static String getProperty_Value(String key) {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("./config.properties"));
			String Val = prop.getProperty(key);
			return Val;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
