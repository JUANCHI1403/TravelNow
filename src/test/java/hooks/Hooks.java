package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Hooks {
  public static WebDriver driver;

  @Before
  public void setup() {
    // 1️⃣ Configura la ruta donde colocaste msedgedriver.exe
    System.setProperty(
      "webdriver.edge.driver",
      "C:\\webdriver\\msedgedriver.exe"
    );

    // 2️⃣ Opciones de Edge
    EdgeOptions options = new EdgeOptions();
    options.addArguments("--start-maximized"); // abre maximizado

    // 3️⃣ Inicializa driver
    driver = new EdgeDriver(options);
  }

  @After
  public void teardown() {
    if (driver != null) {
      // 4️⃣ Tomar screenshot solo si driver no es null
      try {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
        .format(new Date());
        File srcFile =
          ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotPath =
          "target/screenshots/screenshot_" + timestamp + ".png";
        Files.createDirectories(Paths.get("target/screenshots"));
        Files.copy(srcFile.toPath(), Paths.get(screenshotPath));
        System.out.println("📸 Screenshot guardado en: " + screenshotPath);
      } catch (IOException e) {
        System.out.println("⚠️ Error al guardar screenshot: " + e.getMessage());
      } catch (Exception e) {
        System.out.println("⚠️ Error al tomar screenshot: " + e.getMessage());
      }

      // 5️⃣ Cierra el navegador
      driver.quit();
      driver = null;
    }
  }
}
