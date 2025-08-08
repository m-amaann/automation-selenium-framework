package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.function.Function;

public class WaitUtils {

    public static WebDriverWait getWait(WebDriver driver, int timeoutInSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
    }

    // Display Elements
    public static WebElement waitForVisibility(WebDriver driver, By locator, int timeoutInSeconds) {
        return getWait(driver, timeoutInSeconds).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Display an elements to be clickable
    public static WebElement waitForClickable(WebDriver driver, By locator, int timeoutInSeconds) {
        return getWait(driver, timeoutInSeconds).until(ExpectedConditions.elementToBeClickable(locator));
    }


    // Wait for a text to be present in an element
    public static boolean waitForTextInElement(WebDriver driver, By locator, String text, int timeoutInSeconds) {
        return getWait(driver, timeoutInSeconds).until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    // Custom fluent wait with polling
    public static <T> T fluentWait(WebDriver driver, Function<WebDriver, T> condition, int timeout, int pollingInterval) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(pollingInterval))
                .ignoring(NoSuchElementException.class);

        return wait.until(condition);
    }
}
