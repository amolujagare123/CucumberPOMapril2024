package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {


    static Properties getLoadedPropertiesObject() throws IOException {
        // 1. read the file
        FileInputStream fis = new FileInputStream("config/bookings.properties");

        // 2. create the Properties Object
        Properties prop = new Properties();

        // 3. load the file object using properties object
        prop.load(fis);

        return prop;
    }
    public  static String getUrl() throws IOException {
       return getLoadedPropertiesObject().getProperty("url");
    }


}
