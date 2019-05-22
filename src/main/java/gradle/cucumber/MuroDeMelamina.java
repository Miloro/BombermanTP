package gradle.cucumber;

public class MuroDeMelamina implements Muro {
    public MuroDeMelamina(){
    }
    @Override
    public boolean esDeMelamina(){return true;}
    @Override
    public boolean esDeAcero() {return false;}
}
