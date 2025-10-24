package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import pages.HomePage;

public class SearchSteps {
  private HomePage homePage = new HomePage();
  private List<String> resultados;

  @Given("que estoy en la página principal de TravelNow")
  public void estoy_en_pagina_principal() {
    System.out.println("Simulando estar en la página principal de TravelNow");
  }

  @When("ingreso origen {string} y destino {string} y fecha {string}")
  public void ingreso_origen_y_destino_y_fecha(
    String origen,
    String destino,
    String fecha
  ) {
    homePage.search(origen, destino, fecha);
  }

  @And("selecciono {string}")
  public void selecciono(String tipoVuelo) {
    homePage.seleccionarSoloIda(tipoVuelo.equalsIgnoreCase("Solo ida"));
  }

  @Then("veo resultados de vuelos disponibles")
  public void veo_resultados() {
    resultados = homePage.getVuelosDisponibles();
    if (resultados.isEmpty()) {
      throw new RuntimeException("No se encontraron vuelos simulados.");
    }
  }

  @And("cada resultado muestra aerolínea, hora y precio")
  public void cada_resultado_muestra_aerolinea_hora_precio() {
    for (String vuelo : resultados) {
      if (!vuelo.matches(".+ - \\d{2}:\\d{2} - \\$\\d+")) {
        throw new RuntimeException("Formato de vuelo incorrecto: " + vuelo);
      }
    }
    System.out.println("Todos los resultados están correctamente formateados.");
  }
}
