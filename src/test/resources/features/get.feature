Feature: Consulta de objetos
  Como usuario de la API
  Quiero poder consultar objetos
  Para poder obtener información sobre los objetos disponibles

  @ConsultaDeObjetos
  Scenario Outline: Consulta de objetos por el id - <id>
    Given que Juan puede consumir la API
    When consultar el objeto con ID "<id>"
    Then el código de respuesta debe ser <statusCode>
    And validamos que "<path>" contenga el siguiente texto "<value>"

    Examples:
      | id                               | statusCode | value                | path  |
      | 7                                | 200        | Apple MacBook Pro 16 | name  |
      | 8                                | 200        | Apple Watch Series 8 | name  |
      | ff8081819d82fab6019f62042e545fb4 | 200        | Zenbook 15           | name  |
      | invalid-id                       | 404        | was not found.       | error |
