package gradle.cucumber;

import java.util.HashMap;
import java.util.Map;

public class Tablero {
    private HashMap<Integer,HashMap<Integer,Celda>> celdas;

    public Tablero(Integer cantidadFilas, Integer  cantidadColumnas){
        this.celdas = new HashMap<Integer,HashMap<Integer,Celda>>();

        for (int i=0; i<cantidadColumnas; i++){
            this.celdas.put(i,this.mapaDeFilas(cantidadFilas));
        }

    }

    private HashMap<Integer,Celda> mapaDeFilas(Integer cantidadFilas) {
        HashMap<Integer,Celda> filaCeldas = new HashMap<Integer,Celda>();
        for (int i=0; i<cantidadFilas; i++){
            filaCeldas.put(i,new Celda());
        }
        return filaCeldas;
    }

    public void setearMuroEnCelda(Integer posicionX, Integer posicionY) {
        this.dameLaCelda(posicionX,posicionY).setearMuro();
    }

    private Celda dameLaCelda(Integer posicionX, Integer posicionY) {
        return this.celdas.get(posicionX).get(posicionY);
    }

    public boolean celdaALaDerechaEsCeldaVacia(Integer posicionX, Integer posicionY) {
        return !this.dameLaCelda(posicionX+1,posicionY).tieneMuro();
    }

    public void setearEnemigoEnCelda(Integer posicionX, Integer posicionY) {
        this.dameLaCelda(posicionX,posicionY).setearEnemigo();
    }

    public boolean celdaALaDerechaEsCeldaConEnemigo(Integer posicionX, Integer posicionY) {
        return this.dameLaCelda(posicionX+1,posicionY).tieneEnemigo();
    }
}
