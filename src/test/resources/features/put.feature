Feature: Modificacion de objetos
  Como usuario de la API
  Quiero poder modificar objetos
  Para poder obtener almacenar los objetos disponibles

  @Put
  Scenario: Modificar un objeto existente
    Given que Juan puede consumir la API
    When modifico el objeto con ID "ff8081819d82fab6019f2586a1d80fcb" con los siguientes datos
    Then el código de respuesta debe ser 200
    And validamos que "data.year" sea igual a "2023"
    And validamos que "name" sea igual a "Samsung Galaxy S22"
    And validamos que "updatedAt" no sea nula
