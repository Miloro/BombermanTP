package gradle.cucumber;

public class Bomberman {
    private Integer posicionX;
    private Integer posicionY;
    private boolean estaVivo;
    private Poder poder;

    public Bomberman(){
        this.posicionX = 0;
        this.posicionY = 0;
        this.estaVivo = true;
        this.poder = new PoderNormal();
    }

    public Bomberman(Integer posicionX, Integer posicionY){
        this.posicionX=posicionX;
        this.posicionY=posicionY;
        this.estaVivo= true;
        this.poder = new PoderNormal();
    }

    public Integer getPosicionX() {
        return posicionX;
    }

    public Integer getPosicionY() {
        return posicionY;
    }

    //No contempla que haya dos muros seguidos.
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
        if(tablero.celdaALaDerechaEsCeldaConEnemigo(this.posicionX, this.posicionY)){
            this.marcarComoMuerto();
        } else {
            this.moverALaDerechaSegunTipoDeCelda(tablero);
        }
    }

    private void moverALaDerechaSegunTipoDeCelda(Tablero tablero) {
        if (!tablero.celdaALaDerechaEsCeldaConMuro(this.posicionX, this.posicionY)){
            this.posicionX++;
        }else{
            this.posicionX+=2;
        }
    }

    private void marcarComoMuerto() {
        this.estaVivo = false;
    }

    private boolean puedoMovermeALaDerecha(Tablero tablero){
        if(this.posicionX == tablero.getCantidadDeColumnas())return false;
        return tablero.celdaALaDerechaEsCeldaVacia(this.posicionX,this.posicionY) ||
                (tablero.celdaALaDerechaEsCeldaConMuro(this.posicionX, this.posicionY) && this.poder.puedoSaltarMuro());

    }

    private boolean puedoMovermeALaDerecha(){
        return true;
    }

    public boolean estaMuerto() {
        return !this.estaVivo;
    }

    public void sueltaUnaBomba(Tablero tablero) {
        this.poder.sueltaUnaBomba(tablero, this.posicionX, this.posicionY,this);

    }

    public void recibirHabilidad(Poder poderLanzaBomba){
        this.poder = poderLanzaBomba;
    }

    public boolean tieneHabilidadParaLanzarBomba() {
        return this.poder.soyPoderParaLanzarBomba();
    }
}
