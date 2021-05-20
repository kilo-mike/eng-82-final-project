package com.sparta.eng82.tests.unit.utility;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Utility {
    public static void loadProperties(Properties properties) {
        try {
            properties.load(new FileReader("src/test/resources/login.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
