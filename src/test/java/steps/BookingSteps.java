package steps;

import io.cucumber.java.es.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import hooks.Hooks;
import pages.BookingPage;
import pages.SearchResultsPage;

public class BookingSteps {
    private WebDriver driver = Hooks.getDriver();
    private SearchResultsPage results = new SearchResultsPage(driver);
    private BookingPage booking;

    @Dado("que estoy en la página de resultados")
    public void estoy_en_resultados() {
        // asumimos que ya estamos en la página de resultados
        Assert.assertTrue(results.isLoaded());
    }

    @Dado("selecciono el vuelo con referencia {string}")
    public void selecciono_vuelo(String ref) {
        booking = results.selectFlightByRef(ref);
        Assert.assertNotNull("No se abrió la página de booking", booking);
    }

    @Cuando("completo los datos del pasajero nombre {string} y documento {string}")
    public void completo_datos_pasajero(String name, String doc) {
        booking.fillPassenger(name, doc);
    }

    @Cuando("procedo al pago con tarjeta {string}")
    public void proc_pago(String cardType) {
        booking.fillPayment(cardType);
        booking.submitPayment();
    }

    @Entonces("la reserva debe terminar con estado {string}")
    public void ver_estado(String estado) {
        Assert.assertEquals(estado, booking.getBookingStatus());
    }

    @Entonces("recibo un código de reserva")
    public void recibo_codigo_reserva() {
        String code = booking.getBookingCode();
        Assert.assertNotNull("No se generó código", code);
        Assert.assertFalse(code.isEmpty());
    }
}
