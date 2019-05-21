package gradle.cucumber;

public class PoderLanzaBomba implements Poder {
    @Override
    public void sueltaUnaBomba(Tablero tablero, Integer posicionX, Integer posicionY, Bomberman bomberman) {
        Integer posicionXDeExplosion = posicionX + 2;

        if( posicionXDeExplosion > tablero.getCantidadDeFilas() -1) posicionXDeExplosion = tablero.getCantidadDeFilas() - 1; // Me aseguro de no irme del tablero.

        new Bomba().estallarEn(tablero, posicionXDeExplosion, posicionY,bomberman);

    }

    @Override
    public boolean soyPoderParaLanzarBomba() {
        return true;
    }

    @Override
    public boolean puedoSaltarMuro() {
        return false;
    }
}
