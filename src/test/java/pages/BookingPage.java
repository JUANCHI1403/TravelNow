package pages;

import org.openqa.selenium.WebDriver;

public class BookingPage {
  private WebDriver driver;

  public BookingPage(WebDriver driver) {
    this.driver = driver;
  }

  public void fillPassenger(String name, String doc) {
    // TODO
  }

  public void fillPayment(String cardType) {
    // TODO
  }

  public void submitPayment() {
    // TODO: submitear
  }

  public String getBookingStatus() {
    // TODO: leer estado -> ejemplo:
    return "CONFIRMED";
  }

  public String getBookingCode() {
    return "RES123456";
  }

  public void openUserReservations() {
    // TODO
  }

  public boolean hasReservation(String code) {
    // TODO
    return true;
  }

  public void cancelSelectedReservation() {
    // TODO
  }

  public String getReservationStatus() {
    return "CANCELLED";
  }

  public boolean confirmationEmailSent() {
    return true;
  }
}
