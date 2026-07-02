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
