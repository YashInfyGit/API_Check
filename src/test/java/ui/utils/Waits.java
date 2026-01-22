package ui.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class Waits {
    private Waits() {}

    public static WebElement visible(WebDriver driver, By locator, Duration timeout) {
        return new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static boolean urlContains(WebDriver driver, String partial, Duration timeout) {
        return new WebDriverWait(driver, timeout).until(ExpectedConditions.urlContains(partial));
    }

    public static boolean titleContains(WebDriver driver, String partial, Duration timeout) {
        return new WebDriverWait(driver, timeout).until(ExpectedConditions.titleContains(partial));
    }
}

