package gradle.cucumber;

public class ProtoMaxJr extends Enemigo {

    public ProtoMaxJr(){}

    public void procesarMuerte(Bomberman bomberman) {
        bomberman.recibirHabilidad(new PoderSaltarMuros());
    }
}
