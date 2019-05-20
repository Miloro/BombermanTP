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

  Scenario: comportamiento del movimiento de personaje Bomberman
    Given Bomberman se crea en la posicion cero cero
    Given Un enemigo se encuentra en la posicion uno cero
    When Bomberman se mueve en el tablero una celda a la derecha
    Then Bomberman esta muerto

  Scenario: Bomberman suelta una bomba
    Given Bomberman se crea en la posicion cuatro cuatro en un tablero de 10 por 10
    Given El tablero tiene muros en (0,4)(1,4)(4,7)(4,8)(7,4)(8,4)(4,1)(4,0)
    When Bomberman suelta una bomba donde se encuentra
    Then Rompio los muros de (4,1) (1,4) (4,7) (7,4)
    Then Quedaron los muros de (0,4)(4,0)(4,8) (8,4)
