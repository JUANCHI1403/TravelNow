package steps;

import hooks.Hooks;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.openqa.selenium.WebDriver;

public class SearchSteps {
  private WebDriver driver;

  public SearchSteps() {
    this.driver = Hooks.getDriver(); // <-- importante
  }

  @Dado("que estoy en la página principal de TravelNow")
  public void estoy_en_pagina_principal() {
    driver.get("https://example.com"); // o la URL de tu app
  }

  @Cuando("realizo una búsqueda de vuelo directo")
  public void realizo_busqueda() {
    System.out.println("Realizando búsqueda...");
  }

  @Entonces("el sistema muestra resultados disponibles")
  public void muestra_resultados() {
    System.out.println("Mostrando resultados.");
    Hooks.takeScreenshot("resultado_busqueda");
  }
}
