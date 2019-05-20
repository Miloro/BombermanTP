package gradle.cucumber;

public class Celda {
    private Muro muro;


    public Celda(){
        this.muro = null;
    }

    public void setearMuro() {
        this.muro = new Muro();
    }

    public boolean tieneMuro(){
        return this.muro != null;
    }
}
