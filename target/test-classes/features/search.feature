Feature: Login en clickink

  @SmokeTest
  Scenario: Inicio de sesion en clickink
    Given Estoy en la pagina de inicio de clikink
    When Realizo el login en clikink
    And Realizara el login en Auth0
    And Realizara el login en Gmail
    Then Deberian aparecer los resultados de la busqueda

  #Scenario: Busqueda de Eduardo en google
  #  Given Estoy en la pagina de inicio de google
  #  When Realizo la busqueda de Eduardo en google // accion
  #  Then Deberian aparecer los resultados de la busqueda