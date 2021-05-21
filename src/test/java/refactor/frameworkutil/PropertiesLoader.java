package refactor.frameworkutil;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {

    static {
        userProperties = new Properties();
        loadProperties();
    }

    public static Properties userProperties;

    private static void loadProperties() {
        try {
            userProperties.load(new FileReader("src/test/resources/login.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getName(String user) {
        return userProperties.getProperty(user + "_name");
    }

    public static String getEmail(String user) {
        return userProperties.getProperty(user + "_username");
    }

    public static String getPassword(String user) {
        return userProperties.getProperty(user + "_password");
    }
}
