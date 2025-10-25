package util;

import java.io.File;

public class Constant {
    // File names
    public static final String PROP_FILE_NAME = "framework.properties";
    public static final String NOT_FOUND_EXCEPTION = "Property '%s' not found in " + PROP_FILE_NAME;

    // Default property values - Driver Settings
    public static final String DEFAULT_BROWSER = "CHROME";
    public static final boolean DEFAULT_HEADLESS = false;
    public static final boolean DEFAULT_WINDOW_MAXIMIZE = true;

    // Default property values - Timeouts (seconds)
    public static final int DEFAULT_IMPLICIT_WAIT = 10;
    public static final int DEFAULT_PAGE_LOAD_TIMEOUT = 30;
    public static final int DEFAULT_SCRIPT_TIMEOUT = 30;
    public static final int DEFAULT_EXPLICIT_WAIT = 10;
    public static final int DEFAULT_FLUENT_WAIT = 10;
    public static final int DEFAULT_FLUENT_POLLING = 1;

    // Default property values - Application
    public static final String DEFAULT_BASE_URL = "https://bitheap.tech";

    // Property keys - Driver Settings
    public static final String KEY_BROWSER = "browser";
    public static final String KEY_HEADLESS = "headless";
    public static final String KEY_WINDOW_MAXIMIZE = "window.maximize";

    // Property keys - Timeouts
    public static final String KEY_IMPLICIT_WAIT = "implicit.wait";
    public static final String KEY_PAGE_LOAD_TIMEOUT = "page.load.timeout";
    public static final String KEY_SCRIPT_TIMEOUT = "script.timeout";
    public static final String KEY_EXPLICIT_WAIT = "explicit.wait";
    public static final String KEY_FLUENT_WAIT = "fluent.wait";
    public static final String KEY_FLUENT_POLLING = "fluent.polling";

    // Property keys - Application
    public static final String KEY_BASE_URL = "base.url";
    public static final CharSequence CART_COUNT_TEXT = "1";
    public static final String SCREENSHOT_FOLDER = "Screenshots\\";
    public static final int SCREENSHOT_NAME_LENGTH = 10;
    public static final String SCREENSHOT_EXTENSION = ".png";
}