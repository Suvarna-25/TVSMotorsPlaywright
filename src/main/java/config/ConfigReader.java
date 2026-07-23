package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    // Create a Properties object to store key-value pairs
    // Example:
    // base.url=https://www.tvsmotor.com/
    // browser=chromium
    private static final Properties properties = new Properties();
    // Static block
    // Executes ONLY ONCE when the ConfigReader class is loaded.
    // This loads config.properties into memory.
    static {
        // Try-with-resources automatically closes the InputStream.
        try (InputStream input = ConfigReader.class
                .getClassLoader()
                .getResourceAsStream("config.properties")) {
            // If config.properties is not found inside src/main/resources, throw an exception.
            if (input == null) {
                throw new RuntimeException("config.properties file not found in src/main/resources");
            }
            // Load all properties into the Properties object.
            // Example:
            // base.url -> https://www.tvsmotor.com/
            // browser -> chromium
            properties.load(input);
        }
        // Handle any IOException while reading the file.
        catch (IOException e) {

            // Stop execution and throw a RuntimeException.
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }
        // Generic method to fetch any property value.
        // Example:
        // ConfigReader.getProperty("base.url")
        // returns https://www.tvsmotor.com/
       public static String getProperty(String key){
            return properties.getProperty(key);
        }
    }


