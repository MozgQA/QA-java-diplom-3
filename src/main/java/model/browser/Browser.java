package model.browser;

public class Browser {
    private final String name;
    private final String driverPath;

    public Browser(String name, String driverPath) {
        this.name = name;
        this.driverPath = driverPath;
    }

    public String getName() {
        return name;
    }

    public String getDriverPath() {
        return driverPath;
    }
}
