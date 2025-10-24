package pages;

import org.openqa.selenium.WebDriver;

public class BookingPage {
  WebDriver driver;

  public BookingPage(WebDriver driver) {
    this.driver = driver;
  }

  public void completePassenger(String name, String doc) {
    // Implementa completar datos
  }

  public void pay(String cardType) {
    // Implementa pago
  }

  public String getReservationStatus() {
    return "CONFIRMED";
  }

  public String getReservationCode() {
    return "FR123-123456";
  }
}
