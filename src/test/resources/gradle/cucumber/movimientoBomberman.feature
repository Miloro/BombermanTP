Feature: movimientoBomberman

  Scenario: comportamiento del movimiento de personaje Bomberman
    Given Bomberman se crea en la posicion cero cero
    When Bomberman se mueve una celda a la derecha
    Then Bomberman se debe encontrar en la posicion uno cero

  Scenario: comportamiento del movimiento de personaje Bomberman
    Given Bomberman se crea en la posicion cero cero
    Given Un muro se encuentra en la posicion uno cero
    When Bomberman se mueve en el tablero una celda a la derecha
    Then Bomberman se debe encontrar en la posicion cero cero
