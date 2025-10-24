package steps;

import static org.junit.Assert.*;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BookingPage;

public class BookingSteps {
  BookingPage booking;

  @Given("que estoy en la página de resultados")
  public void estoy_en_resultados() {
    // simulamos que ya se abrió SearchResultsPage y se seleccionó un vuelo
    booking = new BookingPage(Hooks.driver);
    System.out.println("🟩 Simulación: Página de resultados cargada.");
  }

  @And("selecciono el vuelo con referencia {string}")
  public void selecciono_vuelo(String flightRef) {
    // Lógica de seleccionar vuelo
    System.out.println("✈️ Vuelo seleccionado: " + flightRef);
  }

  @When("completo los datos del pasajero nombre {string} y documento {string}")
  public void completo_datos_pasajero(String nombre, String doc) {
    booking.completePassenger(nombre, doc);
    System.out.println("👤 Datos del pasajero: " + nombre + " - " + doc);
  }

  @And("procedo al pago con tarjeta {string}")
  public void proc_pago(String cardType) {
    booking.pay(cardType);
    System.out.println("💳 Pago procesado con tarjeta: " + cardType);
  }

  @Then("la reserva debe terminar con estado {string}")
  public void ver_estado(String estadoEsperado) {
    String estadoReal = booking.getReservationStatus();
    assertEquals(estadoEsperado, estadoReal);
  }

  @And("recibo un código de reserva")
  public void recibo_codigo_reserva() {
    String codigo = booking.getReservationCode();
    assertNotNull(codigo);
    System.out.println("📄 Código de reserva generado: " + codigo);
  }
}
