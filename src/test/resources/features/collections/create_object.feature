Feature: Creacion de objetos en coleccion

  Yo como usuario
  Deseo poder realizar la creacion de objetos en coleccion
  Para poder obtener almacenar los objetos disponibles

  Background:
    Given que Juan puede consumir la API
    When el va a iniciar sesion con el correo "john.doe@example.com" y la contraseña "securepassword"

  @CrearObjetos
  Scenario Outline: Crear un nuevo objeto en coleccion
    When creo un objeto con los siguientes datos en la coleccion "<collection>"
      | name   | year   | price   | cpuModel   | hardDisk   |
      | <name> | <year> | <price> | <cpuModel> | <hardDisk> |
    Then el código de respuesta debe ser <statusCode>
    And validamos que "data.price" sea igual a "<price>"

    Examples:
      | collection  | name           | year | price  | cpuModel      | hardDisk | statusCode |
      | laptops     | Zenbook 15     | 2025 | 99.99  | Intel Core i7 | 1TB SSD  | 200        |
      | smartphones | Samsung Galaxy | 2024 | 799.99 | Exynos 2100   | 256GB    | 200        |
