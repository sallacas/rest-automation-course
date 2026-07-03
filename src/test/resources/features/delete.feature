Feature: Eliminacion de objetos
  Como usuario de la API
  Quiero poder eliminar objetos
  Para poder obtener información sobre los objetos disponibles

  @Delete
  Scenario: Eliminar un objeto existente por ID
    Given que Juan puede consumir la API
    When elimino el objeto con ID "ff8081819d82fab6019f2586a1d80fcb"
    Then el código de respuesta debe ser 200
    And validamos que "message" contenga el siguiente texto "has been deleted."
