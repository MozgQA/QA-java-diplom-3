package model.browser;

import java.io.IOException;
import java.util.Properties;

public class BrowserFactory {
    private static final Properties properties = new Properties();

    static {
        try {
            properties.load(BrowserFactory.class.getClassLoader().getResourceAsStream("application.properties"));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load application.properties", e);
        }
    }

    public static Browser createBrowser() {
        String browserName = getSelectedBrowserName();
        return createBrowser(browserName);
    }

    public static Browser createBrowser(String browserName) {
        String propertyKey = "browser." + browserName.toLowerCase() + ".path";
        String path = getRequiredProperty(propertyKey);
        return new Browser(browserName, path);
    }

    private static String getSelectedBrowserName() {
        return getRequiredProperty("selected.browser");
    }

    private static String getRequiredProperty(String key) {
        String value = properties.getProperty(key);
        if (value == null || value.isEmpty()) {
            throw new IllegalStateException("Missing required property: " + key);
        }
        return value;
    }
}
