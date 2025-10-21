package steps;

import hooks.Hooks;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.BookingPage;

public class CancelSteps {
  private WebDriver driver = Hooks.getDriver();
  private BookingPage booking = new BookingPage(driver);

  @Dado("que tengo una reserva con código {string}")
  public void tengo_reserva(String code) {
    booking.openUserReservations();
    Assert.assertTrue(booking.hasReservation(code));
  }

  @Cuando("solicito la cancelación por el panel de usuario")
  public void solicito_cancelacion() {
    booking.cancelSelectedReservation();
  }

  @Entonces("la reserva queda con estado {string}")
  public void reserva_estado(String estado) {
    Assert.assertEquals(estado, booking.getReservationStatus());
  }

  @Entonces("recibo confirmación por correo")
  public void recibo_confirmacion_correo() {
    Assert.assertTrue(booking.confirmationEmailSent());
  }
}
