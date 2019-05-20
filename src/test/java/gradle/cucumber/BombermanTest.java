package gradle.cucumber;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import static org.assertj.core.api.Assertions.assertThat;

public class BombermanTest {
    private Tablero tablero;
    private Bomberman bomberman;

    @Given("^Bomberman se crea en la posicion cero cero")
    public void seCreaUnBomberman() throws Throwable {
        bomberman = new Bomberman();
    }

    @Given("^Un muro se encuentra en la posicion uno cero")
    public void seCreaUnMuro() throws Throwable {
        tablero = new Tablero(2,2);
        tablero.setearMuroEnCelda(1,0);
    }

    @Given("^Un enemigo se encuentra en la posicion uno cero$")
    public void unEnemigoSeEncuentraEnLaCeldaALaDerecha() {
        tablero= new Tablero( 2,2);
        tablero.setearEnemigoEnCelda(1,0);
    }

    @When("^Bomberman se mueve una celda a la derecha")
    public void bombermanSeMueveALaDerecha() throws Throwable{
        bomberman.moverUnaCeldaALaDerecha();
    }

    @When("^Bomberman se mueve en el tablero una celda a la derecha")
    public void bombermanSeMueveALaDerechaEnElTablero() throws Throwable{
        bomberman.moverUnaCeldaALaDerecha(tablero);
    }

    @Then("^Bomberman se debe encontrar en la posicion uno cero")
    public void bombermanSeEncuentraEnLaCeldaUnoYCero() throws  Throwable{
        assertThat(bomberman.getPosicionX()).isEqualTo(1);
        assertThat(bomberman.getPosicionY()).isEqualTo(0);
    }

    @Then("^Bomberman se debe encontrar en la posicion cero cero")
    public void bombermanSeEncuentraEnLaCeldaCeroYCero() throws  Throwable{
        assertThat(bomberman.getPosicionX()).isEqualTo(0);
        assertThat(bomberman.getPosicionY()).isEqualTo(0);
    }


    @Then("^Bomberman esta muerto$")
    public void bombermanEstaMuerto() {
        assertThat(bomberman.estaMuerto()).isEqualTo(true);
    }
}
