package pages;

import org.openqa.selenium.WebDriver;

public class SearchResultsPage {
  WebDriver driver;

  public SearchResultsPage(WebDriver driver) {
    this.driver = driver;
  }

  public boolean resultsDisplayed() {
    // Implementa verificación de resultados
    return true;
  }
}
