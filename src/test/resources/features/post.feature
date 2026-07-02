Feature: Creacion de objetos
  Como usuario de la API
  Quiero poder crear objetos
  Para poder obtener almacenar los objetos disponibles

  @Create
  Scenario: Crear un nuevo objeto
    Given que Juan puede consumir la API
    When crear un objeto con los siguientes datos
    Then el código de respuesta debe ser 200
    And validamos que "data.price" sea igual a "99.99"
