package gradle.cucumber;

public class ProtoMaxUnits extends Enemigo {

    public ProtoMaxUnits(){}

    public void procesarMuerte(Bomberman bomberman) {
        bomberman.recibirHabilidad(new PoderSaltarMurosYLanzarBomba());
    }
}
