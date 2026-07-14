Feature: Modificacion de objetos
  Como usuario de la API
  Quiero poder modificar objetos
  Para poder obtener almacenar los objetos disponibles

  @ModificacionDeObjetos
  Scenario Outline: Modificar un objeto existente
    Given que Juan puede consumir la API
    When modifico el objeto con ID "<id>" con los siguientes datos
      | name     | <name>     |
      | year     | <year>     |
      | price    | <price>    |
      | cpuModel | <cpuModel> |
      | hardDisk | <hardDisk> |
    Then el código de respuesta debe ser <statusCode>
    And validamos que "data.year" sea igual a "<year>"
    And validamos que "name" sea igual a "<name>"
    And validamos que "updatedAt" no sea nula

    Examples:
      | id                               | name               | year | price  | cpuModel    | hardDisk | statusCode |
      | ff8081819d82fab6019f62042e545fb4 | Samsung Galaxy S22 | 2023 | 799.99 | Exynos 2100 | 256GB    | 200        |