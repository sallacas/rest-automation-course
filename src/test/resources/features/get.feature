Feature: Consulta de objetos
  Como usuario de la API
  Quiero poder consultar objetos
  Para poder obtener información sobre los objetos disponibles

  @GetByID
  Scenario: Consultar un objeto existente por ID
    Given que Juan puede consumir la API
    When consultar el objeto con ID "7"
    Then el código de respuesta debe ser 200
    And validamos que "name" sea igual a "Apple MacBook Pro 16"

  @GetByID
  Scenario: Consultar un objeto existente por ID
    Given que Juan puede consumir la API
    When consultar el objeto con ID "8"
    Then el código de respuesta debe ser 201
    And validamos que "name" sea igual a "Apple Watch Series 8"

  @ProductNotFound
  Scenario: Consultar un objeto no existente por ID
    Given que Juan puede consumir la API
    When consultar el objeto con ID "ff8081819d82fab6019f2586a1d80fcb"
    Then el código de respuesta debe ser 404
    And validamos que "error" contenga el siguiente texto "was not found."
