package property;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PropertyLoader {

    private static final String CONFIGURATION_PROPERTY_FILE = "configuration.properties";

    public static String getProperty(String propertyName) {
        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            Properties props = new Properties();
            InputStream resourceStream = loader.getResourceAsStream(CONFIGURATION_PROPERTY_FILE);
            props.load(resourceStream);
            return (String) props.get(propertyName);
        } catch (IOException e) {
            throw new RuntimeException("Couldn't load property file " + e);
        }
    }
}
