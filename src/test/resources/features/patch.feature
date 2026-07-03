Feature: Modificacion parcial de objetos
  Como usuario de la API
  Quiero poder modificar parcialmente objetos
  Para poder obtener almacenar los objetos disponibles

  @Patch
  Scenario: Modificar parcialmente un objeto existente
    Given que Juan puede consumir la API
    When modifico parcialmente el objeto con ID "ff8081819d82fab6019f2586a1d80fcb" con los siguientes datos
    Then el código de respuesta debe ser 200
    And validamos que "data.year" sea igual a "2025"
    And validamos que "name" sea igual a "Zenbook 15"
    And validamos que "updatedAt" no sea nula
