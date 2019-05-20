package gradle.cucumber;

public class Celda {
    private Muro muro;
    private Enemigo enemigo;


    public Celda(){
        this.muro = null;
    }

    public void setearMuro() {
        this.muro = new Muro();
    }

    public boolean tieneMuro(){
        return this.muro != null;
    }

    public void setearEnemigo() { this.enemigo = new Enemigo(); }

    public boolean tieneEnemigo() {return this.enemigo != null; }
}