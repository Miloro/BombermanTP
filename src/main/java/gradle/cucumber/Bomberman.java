package gradle.cucumber;

public class Bomberman {
    private Integer posicionX;
    private Integer posicionY;
    private boolean estaVivo;

    public Bomberman(){
        this.posicionX = 0;
        this.posicionY = 0;
        this.estaVivo = true;
    }

    public Bomberman(Integer posicionX, Integer posicionY){
        this.posicionX=posicionX;
        this.posicionY=posicionY;
        this.estaVivo= true;
    }

    public Integer getPosicionX() {
        return posicionX;
    }

    public Integer getPosicionY() {
        return posicionY;
    }

    public void moverUnaCeldaALaDerecha(Tablero tablero) {
        if(this.puedoMovermeALaDerecha(tablero)){
            this.movermeUnaCeldaALaDerecha(tablero);
        }
    }

    public void moverUnaCeldaALaDerecha() {
        if(this.puedoMovermeALaDerecha()){
            this.movermeUnaCeldaALaDerecha();
        }
    }

    private void movermeUnaCeldaALaDerecha(){
        this.posicionX ++;
    }

    private void movermeUnaCeldaALaDerecha(Tablero tablero) {
        if(!tablero.celdaALaDerechaEsCeldaConEnemigo(this.posicionX, this.posicionY)){
            this.posicionX++;
        } else {
            this.marcarComoMuerto();
        }
    }

    private void marcarComoMuerto() {
        this.estaVivo = false;
    }

    private boolean puedoMovermeALaDerecha(Tablero tablero){
        return tablero.celdaALaDerechaEsCeldaVacia(this.posicionX,this.posicionY);
    }

    private boolean puedoMovermeALaDerecha(){
        return true;
    }

    public boolean estaMuerto() {
        return !this.estaVivo;
    }

    public void sueltaUnaBomba(Tablero tablero) {
        new Bomba().estallarEn(tablero, this.posicionX, this.posicionY);
    }
}
