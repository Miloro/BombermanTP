package gradle.cucumber;

public class Bomberman {
    private Integer posicionX;
    private Integer posicionY;

    public Bomberman(){
        this.posicionX = 0;
        this.posicionY = 0;

    }

    public Integer getPosicionX() {
        return posicionX;
    }

    public Integer getPosicionY() {
        return posicionY;
    }

    public void moverUnaCeldaALaDerecha(Tablero tablero) {
        if(this.puedoMovermeALaDerecha(tablero)){
            this.movermeUnaCeldaALaDerecha();
        }
    }

    public void moverUnaCeldaALaDerecha() {
        if(this.puedoMovermeALaDerecha()){
            this.movermeUnaCeldaALaDerecha();
        }
    }

    private void movermeUnaCeldaALaDerecha() {
        this.posicionX++;
    }

    private boolean puedoMovermeALaDerecha(Tablero tablero){
        return tablero.celdaALaDerechaEsCeldaVacia(this.posicionX,this.posicionY);
    }

    private boolean puedoMovermeALaDerecha(){
        return true;
    }

}
