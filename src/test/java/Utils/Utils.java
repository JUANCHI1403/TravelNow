package Utils;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {

  public static void waitForElement(WebDriver driver, By locator, int seconds) {
    new WebDriverWait(driver, Duration.ofSeconds(seconds))
    .until(ExpectedConditions.visibilityOfElementLocated(locator));
  }
}
