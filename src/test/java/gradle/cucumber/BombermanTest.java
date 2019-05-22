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

    @Given("^Bomberman se crea en la posicion \\((\\d+),(\\d+)\\) en un tablero de (\\d+) por (\\d+)$")
    public void bombermanSeCreaEnLaPosicionEnUnTableroDePor(int arg0, int arg1, int arg2, int arg3) {
        bomberman= new Bomberman(arg0, arg1);
        tablero= new Tablero(arg2, arg3);
    }

    @Given("^Un muro se encuentra en la posicion uno cero")
    public void seCreaUnMuro() throws Throwable {
        tablero = new Tablero(2, 2);
        tablero.setearMuroEnCelda(1, 0);
    }

    @Given("^Un enemigo se encuentra en la posicion uno cero$")
    public void unEnemigoSeEncuentraEnLaCeldaALaDerecha() {
        tablero = new Tablero(2, 2);
        tablero.setearEnemigoEnCelda(1, 0);
    }

    @Given("^Bomberman se crea en la posicion cuatro cuatro en un tablero de (\\d+) por (\\d+)$")
    public void bombermanSeCreaEnLaPosicionCuatroCuatroEnUnTableroDePor(int arg0, int arg1) {
        tablero= new Tablero(arg0, arg1);
        bomberman= new Bomberman(4,4);
    }

    @Given("^ProtoMax Jr\\. se encuentra en la posicion \\((\\d+),(\\d+)\\)$")
    public void protomaxJrSeEncuentraEnLaPosicion(int arg0, int arg1) {
        this.tablero.ponerUnProtoMaxJrEnCelda(arg0, arg1);

    }

    @Given("^El tablero tiene muros en \\((\\d+),(\\d+)\\)\\((\\d+),(\\d+)\\)\\((\\d+),(\\d+)\\)\\((\\d+),(\\d+)\\)\\((\\d+),(\\d+)\\)\\((\\d+),(\\d+)\\)\\((\\d+),(\\d+)\\)\\((\\d+),(\\d+)\\)$")
    public void elTableroTieneMurosEn(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11, int arg12, int arg13, int arg14, int arg15) {
        this.tablero.setearMuroEnCelda(arg0,arg1);
        this.tablero.setearMuroEnCelda(arg2,arg3);
        this.tablero.setearMuroEnCelda(arg4,arg5);
        this.tablero.setearMuroEnCelda(arg6,arg7);
        this.tablero.setearMuroEnCelda(arg8,arg9);
        this.tablero.setearMuroEnCelda(arg10,arg11);
        this.tablero.setearMuroEnCelda(arg12,arg13);
        this.tablero.setearMuroEnCelda(arg14,arg15);
    }

    @Given("^El tablero tiene un enemigo en \\((\\d+),(\\d+)\\)$")
    public void elTableroTieneUnEnemigoEn(int positionX, int positionY) {
        this.tablero.setearEnemigoEnCelda(positionX, positionY);
    }

    @Given("^El tablero tiene un muro de acero en \\((\\d+),(\\d+)\\)$")
    public void elTableroTieneUnMuroDeAceroEn(Integer posicionX, Integer posicionY) {
        this.tablero.setearMuroDeAceroEnCelda(posicionX, posicionY);
    }

    @Given ("^Bagulaa se encuentra en la posicion \\((\\d+),(\\d+)\\)$")
    public void bagulaSeEncuentraEnLaPosicion(Integer posicionX, Integer posicionY){
        this.tablero.setearBagulaaEnCelda(posicionX,posicionY);
    }
    @Given("^El tablero tiene un muro de melamina en \\((\\d+),(\\d+)\\)$")
    public void elTableroTieneUnMuroDeMelaminaEn(Integer posicionX, Integer posicionY){
        this.tablero.setearMuroEnCelda(posicionX,posicionY);
    }

    @Given("^Proto-Max Units se encuentra en la posicion \\((\\d+),(\\d+)\\)$")
    public void protomaxUnitsSeEncuentraEnLaPosicion(int arg0, int arg1) {
        this.tablero.ponerUnProtoMaxUnitsEnCelda(arg0, arg1);

    }

    @When("^Bomberman se mueve una celda a la derecha")
    public void bombermanSeMueveALaDerecha() throws Throwable {
        bomberman.moverUnaCeldaALaDerecha();
    }

    @When("^Bomberman se mueve en el tablero una celda a la derecha")
    public void bombermanSeMueveALaDerechaEnElTablero() throws Throwable {
        bomberman.moverUnaCeldaALaDerecha(tablero);
    }

    @When("^Bomberman suelta una bomba donde se encuentra$")
    public void bombermanSueltaUnaBombaDondeSeEncuentra() {
        bomberman.sueltaUnaBomba(tablero);
    }

    @When("^Bomberman se mueve en el tablero (\\d+) celdas a la derecha$")
    public void bombermanSeMueveEnElTableroCeldasALaDerecha(int cantidadDeCeldas) {
        for( int i=0; i<cantidadDeCeldas; i++ ){
            bomberman.moverUnaCeldaALaDerecha(tablero);
        }
    }

    @Then("^Bomberman se debe encontrar en la posicion uno cero")
    public void bombermanSeEncuentraEnLaCeldaUnoYCero() throws Throwable {
        assertThat(bomberman.getPosicionX()).isEqualTo(1);
        assertThat(bomberman.getPosicionY()).isEqualTo(0);
    }

    @Then("^Bomberman se debe encontrar en la posicion cero cero")
    public void bombermanSeEncuentraEnLaCeldaCeroYCero() throws Throwable {
        assertThat(bomberman.getPosicionX()).isEqualTo(0);
        assertThat(bomberman.getPosicionY()).isEqualTo(0);
    }


    @Then("^Bomberman esta muerto$")
    public void bombermanEstaMuerto() {
        assertThat(bomberman.estaMuerto()).isEqualTo(true);
    }


    @Then("^Rompio los muros de \\((\\d+),(\\d+)\\) \\((\\d+),(\\d+)\\) \\((\\d+),(\\d+)\\) \\((\\d+),(\\d+)\\)$")
    public void rompioLosMurosDe(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) {
        assertThat(tablero.tieneMuroEnCelda(arg0,arg1)).isEqualTo(false);
        assertThat(tablero.tieneMuroEnCelda(arg2,arg3)).isEqualTo(false);
        assertThat(tablero.tieneMuroEnCelda(arg4,arg5)).isEqualTo(false);
        assertThat(tablero.tieneMuroEnCelda(arg6,arg7)).isEqualTo(false);
    }

    @Then("^Quedaron los muros de \\((\\d+),(\\d+)\\)\\((\\d+),(\\d+)\\)\\((\\d+),(\\d+)\\) \\((\\d+),(\\d+)\\)$")
    public void quedaronLosMurosDe(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) {
        assertThat(tablero.tieneMuroEnCelda(arg0,arg1)).isEqualTo(true);
        assertThat(tablero.tieneMuroEnCelda(arg2,arg3)).isEqualTo(true);
        assertThat(tablero.tieneMuroEnCelda(arg4,arg5)).isEqualTo(true);
        assertThat(tablero.tieneMuroEnCelda(arg6,arg7)).isEqualTo(true);
    }

    @Then("^El enemigo ya no se encuentra en la posicion \\((\\d+),(\\d+)\\)$")
    public void elEnemigoYaNoSeEncuentraEnLaPosicion(int arg0, int arg1) {
        assertThat(tablero.tieneMuroEnCelda(arg0,arg1)).isEqualTo(false);
    }

    @Then("^El muro sigue estando en \\((\\d+),(\\d+)\\)$")
    public void elMuroSigueEstandoEn(Integer posicionX, Integer posicionY) {
        assertThat(tablero.tieneMuroDeAceroEnCelda(posicionX, posicionY)).isEqualTo(true);
    }

    @Then( "^Bomberman tiene superpoder para lanzar bombas$")
    public void bombermanTieneSuperPoderParaLanzarBombas(){
        assertThat(bomberman.tieneHabilidadParaLanzarBomba()).isTrue();
    }
    @Then ("^Rompio el muro de la posicion \\((\\d+),(\\d+)\\)$")
    public void rompioElMuroDeLaPosicion(Integer posicionX, Integer posicionY){
        assertThat(tablero.tieneMuroEnCelda(posicionX,posicionY)).isFalse();
    }

    @Then("^Bomberman se debe encontrar en la posicion \\((\\d+),(\\d+)\\)$")
    public void bombermanSeDebeEncontrarEnLaPosicion(int arg0, int arg1) {
        assertThat(bomberman.getPosicionX()).isEqualTo(arg0);
        assertThat(bomberman.getPosicionY()).isEqualTo(arg1);
    }
}
