@SmokeTest @Busqueda
# HU-001: Buscar vuelos
Feature: Búsqueda de vuelos en TravelNow
  Como usuario de TravelNow
  Quiero buscar vuelos por origen, destino y fecha
  Para encontrar opciones disponibles y precios

  Scenario: Búsqueda simple de vuelo (vuelo directo). # HU-001
    Given que estoy en la página principal de TravelNow
    When ingreso origen "Santiago" y destino "Buenos Aires" y fecha "2025-11-15"
    And selecciono "Solo ida"
    Then veo resultados de vuelos disponibles
    And cada resultado muestra aerolínea, hora y precio
