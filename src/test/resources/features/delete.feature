Feature: Eliminacion de objetos
  Como usuario de la API
  Quiero poder eliminar objetos
  Para poder obtener información sobre los objetos disponibles

  @EliminacionDeObjetos
  Scenario Outline: Eliminar un objeto existente por ID
    Given que Juan puede consumir la API
    When elimino el objeto con ID "<id>"
    Then el código de respuesta debe ser <statusCode>
    And validamos que "message" contenga el siguiente texto "<value>"

    Examples:
      | id                               | statusCode | value             | path    |
      | ff8081819d82fab6019f62042e545fb4 | 200        | has been deleted. | message |
      | invalid-id                       | 404        | doesn't exist.    | error   |
