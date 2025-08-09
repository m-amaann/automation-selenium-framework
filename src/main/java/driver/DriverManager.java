package driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {
    private static final ThreadLocal<WebDriver> dr = new ThreadLocal<>();

    // constructor
    private DriverManager() {
        // Private constructor to prevent instantiation
    }

    /**
     * This method is used to get the driver instance from the ThreadLocal variable.
     * It should be called to retrieve the WebDriver instance for the current thread.
     *
     * @return The WebDriver instance associated with the current thread.
     */
    public static WebDriver getDriver() {
        return dr.get();
    }

    /**
     * This method is used to set the driver instance to the ThreadLocal variable.
     * It should be called at the beginning of a test to ensure that each thread has its own driver instance.
     *
     * @param driverInstance The WebDriver instance to be set for the current thread.
     */
    static void setDriver(WebDriver driverInstance) {
        dr.set(driverInstance);
    }

    /**
     * This method is used to remove the driver instance from the ThreadLocal variable.
     * It should be called when the driver is no longer needed, typically at the end of a test.
     */
    public static void unload() {
        dr.remove();
    }
}
