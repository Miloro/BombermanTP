package gradle.cucumber;

public class Celda {
    private Muro muro;
    private Enemigo enemigo;


    public Celda(){
        this.muro = null;
    }

    public void setearMuro() {
        this.muro = new MuroDeMelamina();
    }

    public boolean tieneMuro(){
        return this.muro != null;
    }

    public void setearEnemigo() { this.enemigo = new Enemigo(); }

    public boolean tieneEnemigo() {return this.enemigo != null; }

    public void quitarMuroDeMelamina() {
        if(this.muro != null &&this.muro.esDeMelamina()){
            this.muro=null;
        }
    }

    public void quitarEnemigo(Bomberman bomberman) {
        if(this.enemigo!=null) this.enemigo.procesarMuerte(bomberman);
        this.enemigo=null;
    }

    public void setearMuroDeAcero() { this.muro= new MuroDeAcero();}

    public boolean tieneMuroDeAcero() {
        if(this.muro != null) return this.muro.esDeAcero();
        return false;
    }

    public void setearBagulaa() {
        this.enemigo = new Bagulaa();
    }
}
