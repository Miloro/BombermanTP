package gradle.cucumber;

public class PoderSaltarMuros implements Poder {

    public PoderSaltarMuros(){}

    @Override
    public void sueltaUnaBomba(Tablero tablero, Integer posicionX, Integer posicionY,Bomberman bomberman){
        new PoderNormal().sueltaUnaBomba(tablero,posicionX,posicionY,bomberman);
    };

    @Override
    public boolean soyPoderParaLanzarBomba(){ return false;}

    @Override
    public boolean puedoSaltarMuro() {
        return true;
    }


}
