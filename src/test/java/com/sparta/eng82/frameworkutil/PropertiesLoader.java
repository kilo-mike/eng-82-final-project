package com.sparta.eng82.frameworkutil;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {

    static {
        loadProperties();
    }

    public static final Properties USER_PROPERTIES = new Properties();

    private static void loadProperties() {
        try {
            USER_PROPERTIES.load(new FileReader("src/test/resources/login.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getName(String user) {
        return USER_PROPERTIES.getProperty(user + "_name");
    }

    public static String getEmail(String user) {
        return USER_PROPERTIES.getProperty(user + "_username");
    }

    public static String getPassword(String user) {
        return USER_PROPERTIES.getProperty(user + "_password");
    }


}
