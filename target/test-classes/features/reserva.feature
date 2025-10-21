@Reserva
# HU-002: Reserva exitosa
Feature: Reserva de vuelo en TravelNow
  Como cliente
  Quiero reservar un vuelo seleccionado
  Para obtener confirmación y número de reserva

  Scenario Outline: Reserva con distintos tipos de pasajero  # HU-002
    Given que estoy en la página de resultados
    And selecciono el vuelo con referencia "<flightRef>"
    When completo los datos del pasajero nombre "<name>" y documento "<doc>"
    And procedo al pago con tarjeta "<cardType>"
    Then la reserva debe terminar con estado "CONFIRMED"
    And recibo un código de reserva

    Examples:
      | flightRef | name        | doc        | cardType     |
      | FR123     | Juan Perez  | 12345678   | VISA         |
      | FR456     | Maria Diaz  | 87654321   | MASTERCARD   |
      | FR789     | Pedro Gomez | 11223344   | VISA         |
