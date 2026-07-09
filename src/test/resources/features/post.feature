Feature: Creacion de objetos
  Como usuario de la API
  Quiero poder crear objetos
  Para poder obtener almacenar los objetos disponibles

  @Create
  Scenario Outline: Crear un nuevo objeto - <name>
    Given que Juan puede consumir la API
    When crear un objeto con los siguientes datos
      | name   | year   | price   | cpuModel   | hardDisk   |
      | <name> | <year> | <price> | <cpuModel> | <hardDisk> |
    Then el código de respuesta debe ser <statusCode>
    And validamos que "data.price" sea igual a "<price>"

    Examples:
      | name           | year | price  | cpuModel      | hardDisk | statusCode |
      | Zenbook 15     | 2025 | 99.99  | Intel Core i7 | 1TB SSD  | 200        |
      | Samsung Galaxy | 2024 | 799.99 | Exynos 2100   | 256GB    | 200        |
