package gradle.cucumber;

public class MuroDeAcero implements Muro{

    public MuroDeAcero(){
    }
    @Override
    public boolean esDeMelamina(){return false;}
    @Override
    public boolean esDeAcero() { return true;}
}
