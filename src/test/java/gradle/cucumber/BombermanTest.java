package gradle.cucumber;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import static org.assertj.core.api.Assertions.assertThat;

public class BombermanTest {
    private Bomberman bomberman;
    private Celda celda;

    @Given("^Se crea un bomberman en la posicion cero y cero")
    public void seCreaUnBomberman() throws Throwable {
        celda = new Celda(0,0);
        bomberman = new Bomberman(celda);
        bomberman.setCelda(celda);
    }

    @When("^Bomberman se mueve a la derecha")
    public void bombermanSeMueveALaDerecha() throws Throwable{
        bomberman.moverDerecha();
    }

    @Then("^Bomberman se encuentra en la celda uno y cero")
    public void bombermanSeEncuentraEnLaCeldaUnoYCero() throws  Throwable{
        assertThat(bomberman.posicionX()).isEqualTo(1);
        assertThat(bomberman.posicionY()).isEqualTo(0);
    }

    @When("^Bomberman se mueve para arriba")
    public void bombermanSeMueveParaArriba() throws Throwable{
        bomberman.moverArriba();
    }

    @Then("^Bomberman se encuentra en la celda uno y uno")
    public void bombermanSeEncuentraEnLaCeldaUnoYUno() throws  Throwable{
        assertThat(bomberman.posicionX()).isEqualTo(1);
        assertThat(bomberman.posicionY()).isEqualTo(1);
    }

    @When("^Bomberman se mueve para la izquierda")
    public void bombermanSeMueveParaLaIzquierda() throws Throwable{
        bomberman.moverIzquierda();
    }

    @Then("^Bomberman se encuentra en la celda cero y uno")
    public void bombermanSeEncuentraEnLaCeldaCeroYUno() throws  Throwable{
        assertThat(bomberman.posicionX()).isEqualTo(0);
        assertThat(bomberman.posicionY()).isEqualTo(1);
    }

    @When("^Bomberman se mueve para abajo")
    public void bombermanSeMueveParaAbajo() throws Throwable{
        bomberman.moverAbajo();
    }

    @Then("^Bomberman se encuentra en la celda cero y cero")
    public void bombermanSeEncuentraEnLaCeldaCeroYCero() throws  Throwable{
        assertThat(bomberman.posicionX()).isEqualTo(0);
        assertThat(bomberman.posicionY()).isEqualTo(0);
    }






}
