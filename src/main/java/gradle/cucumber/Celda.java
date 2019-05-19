package gradle.cucumber;

public class Celda {
    private final Integer posicionX;
    private final Integer posicionY;

    public Celda(Integer x, Integer y){
        posicionX = x;
        posicionY = y;
    }


    public Integer posicionX() {
        return posicionX;
    }

    public Integer posicionY() {
        return posicionY;
    }

    public Celda celdaDeLaDerecha() {
        return new Celda(this.posicionX + 1,this.posicionY);
    }

    public Celda celdaDeArriba() {
        return new Celda(this.posicionX ,this.posicionY + 1);
    }

    public Celda celdaDeLaIzquierda() {
        return new Celda(this.posicionX - 1 ,this.posicionY);
    }

    public Celda celdaDeAbajo() {
        return new Celda(this.posicionX, this.posicionY - 1);
    }
}
