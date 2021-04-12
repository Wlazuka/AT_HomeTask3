package com.amazon.utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;


public class PropertyManager {

    private static final Logger logger = LogManager.getLogger(PropertyManager.class.getSimpleName());
    private static final Properties properties = new Properties();
    private static PropertyManager instance = null;

    public PropertyManager() {
        loadProperties(System.getProperty("testdata.property.path"));
    }

    public static String getProperty(String propertyName) {
        if (instance == null)
            instance = new PropertyManager();
        return properties.getProperty(propertyName);
    }

    private void loadProperties(String filePath) {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filePath);
        try {
            assert inputStream != null;
            try (Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8)) {
                properties.load(reader);
            }
        } catch (IOException | NullPointerException e) {
            LogUtil.logStackTrace(e, logger);
        }
    }
}
