Feature: Creacion de usuarios

  Yo como usuario
  Deseo poder realizar la creacion de usuarios
  Para poder obtener almacenar los usuarios disponibles

  @CrearUsuario
  Scenario: Crear un nuevo usuario
    Given que Juan puede consumir la API
    When creo un usuario con los siguientes datos
     # | key     | value                |
      | name     | John Doe             |
      | email    | john.doe2@example.com |
      | password | securepassword       |
    Then el código de respuesta debe ser 200
    And validamos que "user.id" no sea nula
