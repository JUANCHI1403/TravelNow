package pages;

import org.openqa.selenium.WebDriver;

public class HomePage {
  private WebDriver driver;

  public HomePage(WebDriver driver) {
    this.driver = driver;
  }

  public boolean isLoaded() {
    // validación simple; en real usar WebDriverWait y localizador
    return (
      driver.getTitle().contains("TravelNow") ||
      driver.getCurrentUrl().contains("travelnow")
    );
  }

  public void enterOrigin(String origin) {
    // TODO: locate input and send keys
  }

  public void enterDestination(String dest) {
    // TODO
  }

  public void selectDate(String date) {
    // TODO
  }

  public void selectTripType(String type) {
    // TODO
  }

  public SearchResultsPage search() {
    // TODO: click buscar
    return new SearchResultsPage(driver);
  }
}
