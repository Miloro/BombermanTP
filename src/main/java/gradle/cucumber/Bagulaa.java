package gradle.cucumber;

public class Bagulaa extends Enemigo {

    public Bagulaa(){

    }

    @Override
    public void procesarMuerte(Bomberman bomberman) {
        bomberman.recibirHabilidad(new PoderLanzaBomba());

    }
}
