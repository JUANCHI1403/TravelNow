package pages;

import org.openqa.selenium.WebDriver;

public class SearchResultsPage {
  private WebDriver driver;

  public SearchResultsPage(WebDriver driver) {
    this.driver = driver;
  }

  public boolean isLoaded() {
    // TODO
    return true;
  }

  public boolean hasResults() {
    // TODO: verificar lista > 0
    return true;
  }

  public boolean everyResultHas(String field) {
    // TODO: check each result
    return true;
  }

  public BookingPage selectFlightByRef(String ref) {
    // TODO: seleccionar y retornar BookingPage
    return new BookingPage(driver);
  }
}
