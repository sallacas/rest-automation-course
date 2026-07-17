Feature: Inicio de sesión

  @InicioSesion
  Scenario: Inicio de sesión exitoso
    Given que Juan puede consumir la API
    When el va a iniciar sesion con el correo "john.doe@example.com" y la contraseña "securepassword"
    Then el código de respuesta debe ser 200
    And validamos que "token" no sea nula

