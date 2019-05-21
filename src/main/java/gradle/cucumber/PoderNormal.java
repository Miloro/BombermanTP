package gradle.cucumber;

public class PoderNormal implements Poder {

    public void sueltaUnaBomba(Tablero tablero, Integer posicionX, Integer posicionY,Bomberman bomberman) {
        new Bomba().estallarEn(tablero, posicionX, posicionY,bomberman);

    }

    @Override
    public boolean soyPoderParaLanzarBomba() {
        return false;
    }

    @Override
    public boolean puedoSaltarMuro() {
        return false;
    }
}
