package com.saucedemo.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {
    private static final String PROPERTY_FILE = "app.properties";
    private static final Properties PROPERTIES = new Properties();

    public static String getProperty(String propertyName){
        try {
            InputStream reader = PropertyLoader.class.getClassLoader().getResourceAsStream(PROPERTY_FILE);
            PROPERTIES.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return PROPERTIES.getProperty(propertyName);
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println();
        System.out.println(PropertyLoader.getProperty("user.password"));

    }

}
