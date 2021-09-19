package ua.goit.petstore.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {
    private static final String PROPERTIES_FILE_NAME = "app.properties";
    private static final Properties PROPERTIES;

    static {
        PROPERTIES = new Properties();
        try (InputStream inputStream = getInputStream(PROPERTIES_FILE_NAME)) {
            PROPERTIES.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperty (String name){
        return PROPERTIES.getProperty(name);
    }

    public static InputStream getInputStream(String propertiesFileName){
        return PropertiesLoader.class.getClassLoader().getResourceAsStream(propertiesFileName);
    }
}
