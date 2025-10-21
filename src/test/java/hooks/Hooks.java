package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Hooks {
  private static WebDriver driver;

  @Before
  public void setUp() {
    // Configurar EdgeDriver manualmente
    System.setProperty(
      "webdriver.edge.driver",
      "C:\\drivers\\msedgedriver.exe"
    );
    driver = new EdgeDriver();
    driver.manage().window().maximize();
    System.out.println("=== Navegador Edge iniciado correctamente ===");
  }

  @After
  public void tearDown() {
    if (driver != null) {
      driver.quit();
      System.out.println("=== Navegador cerrado correctamente ===");
    }
  }

  public static WebDriver getDriver() {
    return driver;
  }

  public static void takeScreenshot(String name) {
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
}
