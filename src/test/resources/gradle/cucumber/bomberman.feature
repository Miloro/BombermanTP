Feature: Bomberman

  Scenario: comportamiento del personaje Bomberman
    Given Se crea un bomberman en la posicion cero y cero
    When Bomberman se mueve a la derecha
    Then Bomberman se encuentra en la celda uno y cero
    When Bomberman se mueve para arriba
    Then Bomberman se encuentra en la celda uno y uno
    When Bomberman se mueve para la izquierda
    Then Bomberman se encuentra en la celda cero y uno
    When Bomberman se mueve para abajo
    Then Bomberman se encuentra en la celda cero y cero
