package ui.hooks;

import java.io.File;
import java.nio.file.Files;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import ui.core.DriverFactory;

public class Hooks {

    @Before("@ui")
    public void beforeUiScenario() {
        DriverFactory.initDriver();
    }

    @After("@ui")
    public void afterUiScenario(Scenario scenario) {
        try {
            if (scenario.isFailed()) {
                WebDriver driver = DriverFactory.getDriver();
                if (driver instanceof TakesScreenshot) {
                    byte[] png = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                    scenario.attach(png, "image/png", "screenshot");

                    // Also write a local copy to target/ for convenience
                    File outDir = new File("target/screenshots");
                    outDir.mkdirs();
                    Files.write(new File(outDir, scenario.getName().replaceAll("[^a-zA-Z0-9-_\\.]", "_") + ".png").toPath(), png);
                }
            }
        } catch (Exception ignored) {
            // Don't fail teardown because of screenshot issues
        } finally {
            DriverFactory.quitDriver();
        }
    }
}

