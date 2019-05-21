package gradle.cucumber;

public class PoderSaltarMuros implements Poder {

    public PoderSaltarMuros(){}

    public void sueltaUnaBomba(Tablero tablero, Integer posicionX, Integer posicionY,Bomberman bomberman){
        new PoderNormal().sueltaUnaBomba(tablero,posicionX,posicionY,bomberman);
    };

    public boolean soyPoderParaLanzarBomba(){ return false;}

    @Override
    public boolean puedoSaltarMuro() {
        return true;
    }

    ;
}
