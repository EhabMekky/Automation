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
        properties.setProperty(Constant.KEY_BROWSER, Constant.DEFAULT_BROWSER);
        properties.setProperty(Constant.KEY_HEADLESS, String.valueOf(Constant.DEFAULT_HEADLESS));
        properties.setProperty(Constant.KEY_WINDOW_MAXIMIZE, String.valueOf(Constant.DEFAULT_WINDOW_MAXIMIZE));
        properties.setProperty(Constant.KEY_IMPLICIT_WAIT, String.valueOf(Constant.DEFAULT_IMPLICIT_WAIT));
        properties.setProperty(Constant.KEY_PAGE_LOAD_TIMEOUT, String.valueOf(Constant.DEFAULT_PAGE_LOAD_TIMEOUT));
        properties.setProperty(Constant.KEY_SCRIPT_TIMEOUT, String.valueOf(Constant.DEFAULT_SCRIPT_TIMEOUT));
        properties.setProperty(Constant.KEY_BASE_URL, Constant.DEFAULT_BASE_URL);
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
        return getProperty(Constant.KEY_BROWSER, Constant.DEFAULT_BROWSER).toUpperCase();
    }

    public static boolean isHeadless() {
        return getBooleanProperty(Constant.KEY_HEADLESS, Constant.DEFAULT_HEADLESS);
    }

    public static boolean isWindowMaximize() {
        return getBooleanProperty(Constant.KEY_WINDOW_MAXIMIZE, Constant.DEFAULT_WINDOW_MAXIMIZE);
    }

    public static int getImplicitWait() {
        return getIntProperty(Constant.KEY_IMPLICIT_WAIT, Constant.DEFAULT_IMPLICIT_WAIT);
    }

    public static int getPageLoadTimeout() {
        return getIntProperty(Constant.KEY_PAGE_LOAD_TIMEOUT, Constant.DEFAULT_PAGE_LOAD_TIMEOUT);
    }

    public static int getScriptTimeout() {
        return getIntProperty(Constant.KEY_SCRIPT_TIMEOUT, Constant.DEFAULT_SCRIPT_TIMEOUT);
    }

    public static String getBaseUrl() {
        return getProperty(Constant.KEY_BASE_URL, Constant.DEFAULT_BASE_URL);
    }
}