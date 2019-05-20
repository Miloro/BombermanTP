package gradle.cucumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Tablero {
    private HashMap<Integer,HashMap<Integer,Celda>> celdas;
    private int cantidadDeFilas;
    private int cantidadDeColumnas;

    public Tablero(Integer cantidadFilas, Integer  cantidadColumnas){
        this.celdas = new HashMap<Integer,HashMap<Integer,Celda>>();

        for (int i=0; i<cantidadColumnas; i++){
            this.celdas.put(i,this.mapaDeFilas(cantidadFilas));
        }
        this.cantidadDeFilas = cantidadFilas;
        this.cantidadDeColumnas = cantidadColumnas;
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

    // PRO: Quita muro en posicion de Cruz, como en el juego original.
    public void quitarMuroDeMelaminaEnRadio(Integer radio,Integer posicionX, Integer posicionY) {
        this.quitarMuroDeMelaminaAlNorteEnRadio(radio,posicionX, posicionY);
        this.quitarMuroDeMelaminaAlSurEnRadio(radio,posicionX, posicionY);
        this.quitarMuroDeMelaminaAlOesteEnRadio(radio,posicionX, posicionY);
        this.quitarMuroDeMelaminaAlEsteEnRadio(radio,posicionX, posicionY);
    }

    private void quitarMuroDeMelaminaAlEsteEnRadio(Integer radio, Integer posicionX, Integer posicionY) {
        Integer hasta= posicionX + radio;

        if( hasta > this.cantidadDeFilas-1) hasta = this.cantidadDeFilas - 1; // Me aseguro de no irme del tablero.

        for(int i=posicionX; i<=hasta; i++){
            this.dameLaCelda(i,posicionY).quitarMuroDeMelamina();
        }
    }

    private void quitarMuroDeMelaminaAlOesteEnRadio(Integer radio, Integer posicionX, Integer posicionY) {
        Integer hasta= posicionX - radio;

        if( hasta < 0) hasta = 0; // Me aseguro de no irme del tablero.

        for(int i=posicionX; i>=hasta; i--){
            this.dameLaCelda(i,posicionY).quitarMuroDeMelamina();
        }
    }

    private void quitarMuroDeMelaminaAlSurEnRadio(Integer radio, Integer posicionX, Integer posicionY) {
        Integer hasta= posicionY + radio;

        if( hasta > this.cantidadDeFilas-1) hasta = this.cantidadDeFilas - 1; // Me aseguro de no irme del tablero.

        for(int i=posicionY; i<=hasta; i++){
            this.dameLaCelda(posicionX,i).quitarMuroDeMelamina();
        }
    }

    private void quitarMuroDeMelaminaAlNorteEnRadio(Integer radio, Integer posicionX, Integer posicionY) {
        Integer hasta= posicionY - radio;

        if( hasta < 0) hasta = 0; // Me aseguro de no irme del tablero.

        for(int i=posicionY; i>=hasta; i--){
            this.dameLaCelda(posicionX,i).quitarMuroDeMelamina();
        }
    }


    public boolean tieneMuroEnCelda(int posicionX, int posicionY) {
        return this.dameLaCelda(posicionX,posicionY).tieneMuro();
    }
}
