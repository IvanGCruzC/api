# language: es
Característica: Automatización Rest API

  Escenario: Consultar servicio System - Public Users con usuario válido y contraseña válida e inválida
    Cuando consulto POST "/login" con parametros
      | username             | password   |
      | pruebau202@gmail.com | usuario321 |
    Entonces el status es 200
    Y en el body el "token" es "99b9768c-70a6-4fd8-90a5-2d532273ea7f"

  Escenario: Consultar servicio System - Public Users con usuario válido y contraseña inválida
    Cuando consulto POST "/login" con parametros
      | username             | password   |
      | pruebau202@gmail.com | usuario456 |
    Entonces el status es 404
    Y en el body el "message" es "The requested Item has not been found"
    Y en el body el "type" es "ItemNotFoundException"
