package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
  private static WebDriver driver;

  @Before(order = 0)
  public void setUp() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    // timeout y otros settings aquí
  }

  @After(order = 0)
  public void tearDown(Scenario scenario) {
    if (scenario.isFailed()) {
      takeScreenshot(scenario.getName());
    }
    if (driver != null) {
      driver.quit();
    }
  }

  private void takeScreenshot(String name) {
    try {
      File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      Path dest = Path.of(
        "target",
        "screenshots",
        name.replaceAll("[^a-zA-Z0-9.-]", "_") + ".png"
      );
      Files.createDirectories(dest.getParent());
      Files.copy(scr.toPath(), dest, StandardCopyOption.REPLACE_EXISTING);
    } catch (Exception e) {
      System.err.println("No se pudo tomar screenshot: " + e.getMessage());
    }
  }

  public static WebDriver getDriver() {
    return driver;
  }
}
