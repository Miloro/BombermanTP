package gradle.cucumber;

public class Bomberman {
    private Celda celda;

    public Bomberman(Celda celda){
        celda = celda;
    }

    public Celda celda() {
        return celda;
    }

    public void setCelda(Celda celda) {
        this.celda = celda;
    }

    public Integer posicionX() {
        return this.celda.posicionX();
    }

    public Integer posicionY() {
        return this.celda.posicionY();
    }

    public void moverDerecha() {
        celda = this.celda.celdaDeLaDerecha();
    }

    public void moverIzquierda() {
        celda = this.celda.celdaDeLaIzquierda();
    }

    public void moverArriba() {
        celda = this.celda.celdaDeArriba();
    }

    public void moverAbajo() {
        celda = this.celda.celdaDeAbajo();
    }

}
