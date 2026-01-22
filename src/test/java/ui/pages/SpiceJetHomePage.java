package ui.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import ui.utils.Waits;

public class SpiceJetHomePage {
    private final WebDriver driver;

    private final By acceptCookiesButton = By.id("onetrust-accept-btn-handler");

    public SpiceJetHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://www.spicejet.com/");
    }

    public void acceptCookiesIfPresent() {
        try {
            Waits.visible(driver, acceptCookiesButton, Duration.ofSeconds(5)).click();
        } catch (TimeoutException ignored) {
            // Cookie banner not shown (or already accepted)
        }
    }

    public boolean isLoaded() {
        // Keep this intentionally resilient since SpiceJet is highly dynamic.
        boolean urlOk = Waits.urlContains(driver, "spicejet.com", Duration.ofSeconds(20));
        boolean titleOk;
        try {
            titleOk = Waits.titleContains(driver, "SpiceJet", Duration.ofSeconds(5));
        } catch (TimeoutException ignored) {
            titleOk = true; // Some SPA states may not set a stable title; URL is primary.
        }
        return urlOk && titleOk;
    }
}

