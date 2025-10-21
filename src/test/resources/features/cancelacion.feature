@Cancelacion @Reserva
# HU-003: Cancelación de reserva
Feature: Cancelación de reserva en TravelNow
  Como usuario que posee una reserva
  Quiero poder cancelar la reserva y recibir confirmación
  Para recuperar el estado y posibles reembolsos

  Scenario: Cancelación de reserva válida # HU-003
    Given que tengo una reserva con código "ABC123"
    When solicito la cancelación por el panel de usuario
    Then la reserva queda con estado "CANCELLED"
    And recibo confirmación por correo
