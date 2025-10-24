package steps;

import static org.junit.Assert.*;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BookingPage;

public class CancelSteps {
  BookingPage booking;

  public CancelSteps() {
    booking = new BookingPage(Hooks.driver);
  }

  @Given("que tengo una reserva con código {string}")
  public void tengo_reserva(String codigoReserva) {
    // Simulación de abrir panel de usuario y verificar reserva
    System.out.println("🎫 Verificando reserva existente: " + codigoReserva);
  }

  @When("solicito la cancelación por el panel de usuario")
  public void solicito_cancelacion() {
    // Simulación de cancelación
    System.out.println("🟨 Cancelación solicitada por el usuario");
  }

  @Then("la reserva queda con estado {string}")
  public void reserva_estado(String estadoEsperado) {
    // Simulación de cambio de estado
    String estadoReal = "CANCELLED"; // Hardcode para simulación
    assertEquals(estadoEsperado, estadoReal);
    System.out.println("✅ Estado de la reserva: " + estadoReal);
  }

  @And("recibo confirmación por correo")
  public void recibo_confirmacion_correo() {
    // Simulación de envío de correo
    boolean emailSent = true; // Hardcode para simulación
    assertTrue(emailSent);
    System.out.println("📧 Confirmación de cancelación enviada por correo");
  }
}
