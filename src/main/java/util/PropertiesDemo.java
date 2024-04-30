package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo {

    public static void main(String[] args) throws IOException {
        // 1. read the file
        FileInputStream fis = new FileInputStream("config/bookings.properties");

        // 2. create the Properties Object
        Properties prop = new Properties();

        // 3. load the file object using properties object
        prop.load(fis);

        // 4. read the value of a key (using loaded properties object)
        System.out.println(prop.getProperty("url"));
        System.out.println(prop.getProperty("username"));
        System.out.println(prop.getProperty("password"));
    }
}
