package driver;

public class DriverManager {

    public static BrowserManager getBrowserManager(String browser) {

        switch (browser.toLowerCase()) {
            case "chrome":
                return new ChromeManager();
            case "firefox":
                return new FirefoxManager();
            default:
                throw new IllegalArgumentException("no matching browser");
        }

    }
}