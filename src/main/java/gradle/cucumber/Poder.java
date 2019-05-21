package gradle.cucumber;

public interface Poder {
    public void sueltaUnaBomba(Tablero tablero, Integer posicionX, Integer posicionY,Bomberman bomberman);

    boolean soyPoderParaLanzarBomba();
}
