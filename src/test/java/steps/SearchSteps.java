package steps;

import hooks.Hooks;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.SearchResultsPage;

public class SearchSteps {
  private WebDriver driver = Hooks.getDriver();
  private HomePage home;
  private SearchResultsPage results;

  @Dado("que estoy en la página principal de TravelNow")
  public void estoy_en_pagina_principal() {
    driver.get("https://demo.travelnow.example/"); // URL demo — reemplazar por SUT real
    home = new HomePage(driver);
    Assert.assertTrue("Home page no cargó", home.isLoaded());
  }

  @Cuando("ingreso origen {string} y destino {string} y fecha {string}")
  public void ingreso_origen_destino_fecha(
    String origen,
    String destino,
    String fecha
  ) {
    home.enterOrigin(origen);
    home.enterDestination(destino);
    home.selectDate(fecha);
  }

  @Cuando("selecciono {string}")
  public void selecciono_tipo(String tipo) {
    home.selectTripType(tipo);
  }

  @Entonces("veo resultados de vuelos disponibles")
  public void veo_resultados() {
    results = home.search();
    Assert.assertTrue("No hay resultados", results.hasResults());
  }

  @Entonces("cada resultado muestra aerolínea, hora y precio")
  public void verifico_campos_resultado() {
    Assert.assertTrue(results.everyResultHas("airline"));
    Assert.assertTrue(results.everyResultHas("time"));
    Assert.assertTrue(results.everyResultHas("price"));
  }
}
