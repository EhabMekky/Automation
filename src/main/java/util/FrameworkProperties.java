package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FrameworkProperties {

    private static Properties properties;
    private static final String PROP_FILE_NAME = Constant.PROP_FILE_NAME;

    // Static block - loads properties once when class is loaded
    static {
        loadProperties();
    }

    /**
     * Loads properties from framework.properties file
     */
    private static void loadProperties() {
        properties = new Properties();

        try (InputStream inputStream = FrameworkProperties.class
                .getClassLoader()
                .getResourceAsStream(PROP_FILE_NAME)) {

            if (inputStream == null) {
                System.err.printf((Constant.NOT_FOUND_EXCEPTION) + "%n", PROP_FILE_NAME);
                setDefaultProperties();
                return;
            }

            properties.load(inputStream);
            System.out.println("Framework properties loaded successfully from: " + PROP_FILE_NAME);

        } catch (IOException e) {
            System.err.println("Error loading properties: " + e.getMessage());
            e.printStackTrace();
            setDefaultProperties();
        }
    }

    /**
     * Sets default properties as fallback
     */
    private static void setDefaultProperties() {
        properties.setProperty("browser", "CHROME");
        properties.setProperty("headless", "true");
        properties.setProperty("implicit.wait", "10");
        properties.setProperty("page.load.timeout", "30");
        properties.setProperty("script.timeout", "30");
        properties.setProperty("base.url", "https://bitheap.tech");
        System.out.println("Using default properties");
    }

    /**
     * Gets property value by key
     * Supports system property override (command line -Dkey=value)
     */
    public static String getProperty(String key) {
        // Check system property first (command line override)
        String systemProperty = System.getProperty(key);
        if (systemProperty != null && !systemProperty.isEmpty()) {
            return systemProperty;
        }

        // Return from properties file
        String value = properties.getProperty(key);
        if (value == null) {
            System.err.println("Property '" + key + "' not found, returning null");
        }
        return value;
    }

    /**
     * Gets property with default value
     */
    public static String getProperty(String key, String defaultValue) {
        String value = getProperty(key);
        return (value != null && !value.isEmpty()) ? value : defaultValue;
    }

    /**
     * Gets integer property
     */
    public static int getIntProperty(String key, int defaultValue) {
        try {
            String value = getProperty(key);
            return (value != null) ? Integer.parseInt(value) : defaultValue;
        } catch (NumberFormatException e) {
            System.err.println("Invalid integer for property '" + key + "', using default: " + defaultValue);
            return defaultValue;
        }
    }

    /**
     * Gets boolean property
     */
    public static boolean getBooleanProperty(String key, boolean defaultValue) {
        String value = getProperty(key);
        return (value != null) ? Boolean.parseBoolean(value) : defaultValue;
    }

    // ==========================================
    // Convenience methods for common properties
    // ==========================================

    public static String getBrowser() {
        return getProperty("browser", "CHROME").toUpperCase();
    }

    public static boolean isHeadless() {
        return getBooleanProperty("headless", true);
    }

    public static int getImplicitWait() {
        return getIntProperty("implicit.wait", 10);
    }

    public static int getPageLoadTimeout() {
        return getIntProperty("page.load.timeout", 30);
    }

    public static int getScriptTimeout() {
        return getIntProperty("script.timeout", 30);
    }

    public static String getBaseUrl() {
        return getProperty("base.url", "https://bitheap.tech");
    }
}